package go.tracker.persistence

import jakarta.persistence.EntityManagerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.PropertySource
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "goTrackerEntityManager",
    basePackages = ["go.tracker.persistence.repository"],
    transactionManagerRef = "goTrackerTransactionManager"
)
@PropertySource(value = ["classpath:application-database-local.properties"])
class DatabaseConfig {

    private val url = "jdbc:postgresql://localhost:5432/GOTrackerDB\n"
    private val user = "postgres"
    private val password = "Dcosta55"

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "go.tracker.datasource")
    fun goTrackerDataSource(): DataSource = DataSourceBuilder.create().build()

    @Bean
    fun goTrackerEntityManager(
        builder: EntityManagerFactoryBuilder,
        datasource: DataSource
    ): LocalContainerEntityManagerFactoryBean =
        builder
            .dataSource(datasource)
            .packages("go.tracker.persistence.entity")
            .build()

    @Bean
    fun goTrackerTransactionManager(
        @Qualifier("goTrackerEntityManager") entityManagerFactory: EntityManagerFactory?
    ): PlatformTransactionManager = JpaTransactionManager(entityManagerFactory!!)

}