package haho.web.admin.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataSourceSwith implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private static JdbcTemplate jdbcTemplate;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DataSourceSwith.applicationContext = applicationContext;
    }

    public static JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public static void switchToDeva() {
        jdbcTemplate = (JdbcTemplate) applicationContext.getBean("devaJdbcTemplate");
    }

    public static void switchToTesta() {
        jdbcTemplate = (JdbcTemplate) applicationContext.getBean("testaJdbcTemplate");
    }

    public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        DataSourceSwith.jdbcTemplate = jdbcTemplate;
    }

}
