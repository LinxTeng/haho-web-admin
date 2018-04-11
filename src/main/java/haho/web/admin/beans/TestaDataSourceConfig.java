package haho.web.admin.beans;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@EnableAutoConfiguration
public class TestaDataSourceConfig {
    @Bean
    @ConfigurationProperties("app.datasource.testa")
    public DataSourceProperties testaDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("app.datasource.testa")
    public DataSource testaDataSource() {
        return testaDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public DataSourceTransactionManager testaTransactionManager() {
        return new DataSourceTransactionManager(this.testaDataSource());
    }

    @Bean
    public JdbcTemplate testaJdbcTemplate() {
        return new JdbcTemplate(this.testaDataSource());
    }
}
