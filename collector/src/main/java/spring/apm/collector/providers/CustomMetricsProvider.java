package spring.apm.collector.providers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.apm.collector.core.CustomMetrics;
import spring.apm.collector.core.CustomMetricsDetails;
import spring.apm.collector.core.CustomMetricsRepository;

@Component
@RequiredArgsConstructor
public class CustomMetricsProvider implements CustomMetricsDetails {

    private final CustomMetricsRepository customMetricsRepository;

    @Override
    public void save(CustomMetrics customMetrics) {
        customMetricsRepository.save(customMetrics);
    }
}
