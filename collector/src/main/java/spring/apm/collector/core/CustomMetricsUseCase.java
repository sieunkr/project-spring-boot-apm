package spring.apm.collector.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomMetricsUseCase {

    private final CustomMetricsDetails customMetricsDetails;

    public void save(CustomMetrics customMetrics){
        customMetricsDetails.save(customMetrics);
    }

}
