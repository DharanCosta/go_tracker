package go.tracker.api.config

import go.tracker.domain.config.DomainConfig
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(DomainConfig::class)
@ComponentScan(basePackages = ["go.tracker.domain"])
class APIConfig {

    @Bean
    fun openAPI(): OpenAPI =
        OpenAPI()
            .info(
                Info()
                    .title("Go Tracker")
                    .description("API do aplicação GO Tracker")
            )

}