package com.hendi.webapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

//	@Id
//	@Column(name="id")
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "emp_name", length = 50, nullable = true)
    private String empName;

    @Column(name = "emp_designation", length = 50, nullable = true)
    private String empDesignation;

    @Column(name = "emp_salary", nullable = true)
    private Float empSalary;

}
