package com.letscoding.batch.mysqlcrm.dbmodel.mysql;


import com.letscoding.dbmodel.CoreEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "std",name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student implements CoreEntity<Long> {


    @Id
    @Column(name="ID")
    private Integer id;

    @Column(name="studentname")
    private String studentname;

    @Column(name="surname")
    private String surname;

    @Column(name = "status")
    private String status;

}
