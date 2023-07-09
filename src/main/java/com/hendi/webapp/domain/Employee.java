package com.hendi.webapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.UUIDGenerator;

import java.math.BigDecimal;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {

//	@Id
//	@Column(name="id")
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", type = UUIDGenerator.class)
    private String id;

    @Column(name = "emp_name", length = 50)
    @NotEmpty
    @NotBlank
    private String empName;

    @Column(name = "emp_designation", length = 50)
    @NotEmpty
    @NotBlank
    private String empDesignation;

    @Column(name = "emp_salary")
    @Positive
    private BigDecimal empSalary;

}
