package spring.api.client.configuration;

import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricConfig {

    @Bean
    JvmThreadMetrics threadMetrics(){
        return new JvmThreadMetrics();
    }
}
