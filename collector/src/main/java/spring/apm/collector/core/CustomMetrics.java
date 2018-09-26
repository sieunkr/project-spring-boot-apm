package spring.apm.collector.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;

@Document(collection = "metrics")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CustomMetrics {

    @Id
    private String id;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    @JsonProperty("createdate")
    private Date createdDate;

    @JsonProperty("application.name")
    private Object applicationName;

    @JsonProperty("jvm.memory.max")
    private Object jvmMemMax;

    @JsonProperty("http.server.requests")
    private Object httpServerRequests;

    @JsonProperty("jvm.gc.memory.promoted")
    private Object jvmGcMemoryPromoted;






}
