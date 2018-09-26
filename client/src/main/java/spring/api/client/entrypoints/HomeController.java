package spring.api.client.entrypoints;

import lombok.RequiredArgsConstructor;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.api.client.core.ActuatorUseCase;
import spring.api.client.providers.MessagePublishComponent;

@RestController
@RequiredArgsConstructor
@RequestMapping("/metric")
public class HomeController {

    private final ActuatorUseCase actuatorUseCase;

    private final MessagePublishComponent messagePublishComponent;

    @GetMapping
    public void getMetric(){



        messagePublishComponent.sendMessageByte(actuatorUseCase.getMetric());

    }


}
