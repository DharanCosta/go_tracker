package go.tracker.api.config

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.support.ReloadableResourceBundleMessageSource

class MessageConfig {

    @Bean
    fun messageSource(): MessageSource =
        ReloadableResourceBundleMessageSource().apply {
            this.setBasenames("classpath:/messages")
            this.setDefaultEncoding("UTF-8")
        }
}