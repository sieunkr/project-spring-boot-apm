package spring.api.client.providers;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomSource {

    @Output("SOURCE-HEALTH")
    MessageChannel output();
}
