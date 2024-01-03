package example.spring_movie.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("example.spring_movie.domain")
@EnableJpaRepositories("example.spring_movie.repos")
@EnableTransactionManagement
public class DomainConfig {
}
