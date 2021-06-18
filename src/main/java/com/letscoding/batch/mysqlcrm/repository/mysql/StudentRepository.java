package com.letscoding.batch.mysqlcrm.repository.mysql;


import com.letscoding.batch.mysqlcrm.dbmodel.mysql.Student;
import com.letscoding.repository.common.BaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends BaseJpaRepository<Student,Long> {

    @Query(value="select * from std.student",nativeQuery = true)
    public List<Student> getStudentList();

}
