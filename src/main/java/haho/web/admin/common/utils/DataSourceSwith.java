package haho.web.admin.common.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataSourceSwith implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private static ThreadLocal<JdbcTemplate> localJdbc = new ThreadLocal<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        DataSourceSwith.applicationContext = applicationContext;
    }

    public static JdbcTemplate getJdbcTemplate() {
        // 默认使用deva
        if (localJdbc.get() == null) {
            switchToDeva();
        }
        return localJdbc.get();
    }

    // dev-a
    public static void switchToDeva() {
        localJdbc.set((JdbcTemplate) applicationContext.getBean("devaJdbcTemplate"));
    }

    // dev-b
    public static void switchToDevb() {
        localJdbc.set((JdbcTemplate) applicationContext.getBean("devbJdbcTemplate"));
    }

    // test-a
    public static void switchToTesta() {
        localJdbc.set((JdbcTemplate) applicationContext.getBean("testaJdbcTemplate"));
    }

    // test-b
    public static void switchToTestb() {
        localJdbc.set((JdbcTemplate) applicationContext.getBean("testbJdbcTemplate"));
    }

    // yufabu
    public static void switchToYufabu() {
        localJdbc.set((JdbcTemplate) applicationContext.getBean("yufabuJdbcTemplate"));
    }
}
