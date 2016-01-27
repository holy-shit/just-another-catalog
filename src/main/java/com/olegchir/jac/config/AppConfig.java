package com.olegchir.jac.config;

import com.olegchir.jac.bootstrap.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by olegchir on 25/01/16.
 */

@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan(basePackages = {"com.olegchir.jac"})
@EntityScan(basePackages = {"com.olegchir.jac.entities"})
@EnableTransactionManagement
@Import({TilesConfig.class, DisableErrorFilter.class})
public class AppConfig {

    public static final String DATABASE_DIALECT = "org.hibernate.dialect.HSQLDialect";
    public static final String ENTITIES_ROOT = "com.olegchir.jac.entities";

    @Autowired
    ConfigurableEnvironment env;

    @Bean
    DataLoader dataLoader() {
        return new DataLoader();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPackagesToScan(ENTITIES_ROOT);

        Properties props = new Properties();
        props.put("hibernate.dialect", DATABASE_DIALECT);
        props.put("ddl-auto", "create-drop");
        props.put("show-sql", true);
        bean.setHibernateProperties(props);

        return bean;
    }

}
