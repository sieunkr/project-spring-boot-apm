package spring.api.client.providers;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableBinding(CustomSource.class)
public class MessagePublishComponent {

    @Autowired
    private CustomSource customSource;

    public void sendMessageByte(String info) {
        customSource.output().send(MessageBuilder.withPayload(SerializationUtils.serialize(info)).build());
    }

}
