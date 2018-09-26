package spring.apm.collector.entrypoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.util.SerializationUtils;
import spring.apm.collector.core.CustomMetrics;
import spring.apm.collector.core.CustomMetricsUseCase;

import java.io.IOException;

@EnableBinding(ActuatorListener.Sink.class)
@RequiredArgsConstructor
public class ActuatorListener {

    private final CustomMetricsUseCase customMetricsUseCase;

    @StreamListener("sink-merge")
    public void subscribe2(Message<?> message) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            CustomMetrics customMetrics = objectMapper.readValue((String)SerializationUtils.deserialize((byte[])message.getPayload()), CustomMetrics.class);
            customMetricsUseCase.save(customMetrics);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface Sink {
        @Input("sink-merge")
        SubscribableChannel HealthListener();
    }
}
