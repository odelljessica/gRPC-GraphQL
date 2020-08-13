package com.personal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource quasarDataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = this.getEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(quasarDataSource);
        entityManagerFactory.setPackagesToScan("com.personal.entities");
        return entityManagerFactory;
    }

    private LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter adaptor = new HibernateJpaVendorAdapter();
        adaptor.setDatabasePlatform("org.hibernate.dialect.SQLServerDialect");
        factory.setJpaVendorAdapter(adaptor);
        factory.setJpaProperties(hibernateProperties());
        return factory;
    }

    private Properties hibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.show_sql", "true");
        prop.put("hibernate.use_sql_comments", "true");
        prop.put("hibernate.format_sql", "true");
        prop.put("hibernate.type", "trace");
        prop.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        return prop;
    }

}