package com.ad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="studentInfo")
@Data
public class Student {
@Id
@SequenceGenerator(name="gen1",sequenceName="std_id_seq",initialValue=1,allocationSize=1)
@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
private Integer sno;
@Column(length=30)
private String sname;
@Column(length=30)
private String qualification;
private Integer age;
@Column(length=30)
private String email;

}
