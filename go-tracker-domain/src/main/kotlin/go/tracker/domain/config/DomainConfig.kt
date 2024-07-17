package go.tracker.domain.config

import go.tracker.persistence.DatabaseConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(DatabaseConfig::class)
@ComponentScan(
    basePackages = ["go.tracker.persistence.service"]
)
class DomainConfig