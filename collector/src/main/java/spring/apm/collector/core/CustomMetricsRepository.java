package spring.apm.collector.core;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomMetricsRepository extends MongoRepository<CustomMetrics, Integer> {
}
