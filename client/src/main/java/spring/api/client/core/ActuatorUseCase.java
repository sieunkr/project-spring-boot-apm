package spring.api.client.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActuatorUseCase {

    private final ActuatorDetails actuatorDetails;

    public String getMetric(){
        return actuatorDetails.getMetric();
    }
}
