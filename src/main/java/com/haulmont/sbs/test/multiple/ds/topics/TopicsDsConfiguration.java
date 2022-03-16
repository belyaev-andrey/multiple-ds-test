package com.haulmont.sbs.test.multiple.ds.topics;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class TopicsDsConfiguration {

    @Bean
    @ConfigurationProperties("topics.datasource")
    public DataSourceProperties topicsDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource topicsDatasource() {
        return topicsDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

//    @Bean
//    public DataSourceInitializer topicDataSourceInitializer(@Qualifier("topicDatasource") DataSource datasource) {
//        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
//        resourceDatabasePopulator.addScript(new ClassPathResource("schema-topic.sql"));
//        resourceDatabasePopulator.addScript(new ClassPathResource("data-topic.sql"));
//
//        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
//        dataSourceInitializer.setDataSource(datasource);
//        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
//        return dataSourceInitializer;
//    }

}