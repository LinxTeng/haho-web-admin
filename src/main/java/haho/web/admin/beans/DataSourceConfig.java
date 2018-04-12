package haho.web.admin.beans;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@EnableAutoConfiguration
public class DataSourceConfig {
    // ----------------------dev-a环境-----------------------------
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
    public JdbcTemplate devaJdbcTemplate() {
        return new JdbcTemplate(this.devaDataSource());
    }

    // --------------------------dev-b环境----------------------------------------
    @Bean
    @ConfigurationProperties("app.datasource.devb")
    public DataSourceProperties devbDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("app.datasource.devb")
    public DataSource devbDataSource() {
        return devbDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public JdbcTemplate devbJdbcTemplate() {
        return new JdbcTemplate(this.devbDataSource());
    }

    // ----------------------test-a环境-------------------------------------
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
    public JdbcTemplate testaJdbcTemplate() {
        return new JdbcTemplate(this.testaDataSource());
    }

    // ------------------------test-b环境-------------------------------------
    @Bean
    @ConfigurationProperties("app.datasource.testb")
    public DataSourceProperties testbDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("app.datasource.testb")
    public DataSource testbDataSource() {
        return testbDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public JdbcTemplate testbJdbcTemplate() {
        return new JdbcTemplate(this.testbDataSource());
    }

    // ------------------------------预发布环境-------------------------------
    @Bean
    @ConfigurationProperties("app.datasource.yufabu")
    public DataSourceProperties yufabuDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("app.datasource.yufabu")
    public DataSource yufabuDataSource() {
        return yufabuDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public JdbcTemplate yufabuJdbcTemplate() {
        return new JdbcTemplate(this.yufabuDataSource());
    }

}
