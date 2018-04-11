package haho.web.admin.beans;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@EnableAutoConfiguration
public class DevaDataSourceConfig {
    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.deva")
    public DataSourceProperties devaDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.deva")
    public DataSource devaDataSource() {
        return devaDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @Primary
    public DataSourceTransactionManager devaTransactionManager() {
        return new DataSourceTransactionManager(this.devaDataSource());
    }

    @Bean
    @Primary
    public JdbcTemplate devaJdbcTemplate() {
        return new JdbcTemplate(this.devaDataSource());
    }
}
