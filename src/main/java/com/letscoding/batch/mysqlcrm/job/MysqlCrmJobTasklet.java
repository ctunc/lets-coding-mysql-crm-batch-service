package com.letscoding.batch.mysqlcrm.job;


import com.letscoding.batch.mysqlcrm.dbmodel.mysql.Student;
import com.letscoding.batch.mysqlcrm.repository.mysql.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MysqlCrmJobTasklet implements Tasklet {
    private static Logger logger= LoggerFactory.getLogger(MysqlCrmJobTasklet.class);

    @Autowired
    StudentRepository studentRepository;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

            List<Student> studentList =studentRepository.getStudentList();
        for (Student e: studentList
             ) {
            logger.info("student name: "+ e.getStudentname());
        }
            logger.info("hello mysqlCrm job");
            return RepeatStatus.FINISHED;
    }
}
