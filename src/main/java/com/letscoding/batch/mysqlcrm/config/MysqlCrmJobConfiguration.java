package com.letscoding.batch.mysqlcrm.config;


import com.letscoding.batch.mysqlcrm.job.MysqlCrmJobTasklet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

@Configuration
public class MysqlCrmJobConfiguration {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    Environment environment;

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;


    public MysqlCrmJobConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory){
        this.jobBuilderFactory=jobBuilderFactory;
        this.stepBuilderFactory=stepBuilderFactory;
    }

    @Bean
    public Job mysqlCrmJob(MysqlCrmJobTasklet mysqlCrmJobTasklet) {

        return jobBuilderFactory.get("mysqlCrmJob")
                .start(mysqlCrmJobStep(mysqlCrmJobTasklet))
                .build();
    }

    @Bean
    public Step mysqlCrmJobStep(MysqlCrmJobTasklet mysqlCrmJobTasklet) {
        DefaultTransactionAttribute attribute = new DefaultTransactionAttribute();
        attribute.setTimeout(2000);

        return stepBuilderFactory.get("mysqlCrmJobStep")
                .tasklet(mysqlCrmJobTasklet)
                .transactionAttribute(attribute)
                .build();
    }
}
