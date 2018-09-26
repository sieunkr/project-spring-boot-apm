package spring.api.client.providers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.api.client.core.ActuatorDetails;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ActuatorProvider implements ActuatorDetails {

    private final MeterRegistry registry;

    @Override
    public String getMetric() {

        Map<String, Object> result = new LinkedHashMap<String, Object>();

        result.put("application.name", "client01");

        result.put("createdate", new Date());

        for (Meter meter : registry.getMeters()) {
            result.put(meter.getId().getName(), meter.measure());
        }

        try {
            String metrics = new ObjectMapper().writeValueAsString(result);
            //byte[] metricsByte = SerializationUtils.serialize(metrics);
            return metrics.trim();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
