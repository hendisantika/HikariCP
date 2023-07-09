/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendi.webapp.repository;

import com.hendi.webapp.domain.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 *
 * @author hendi.santika
 */
//@Sql(
//        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
//        scripts = {"/data/employee.sql"}
//)
@DataJpaTest
@ComponentScan(basePackages = {"com.hendi.webapp.repository"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DataSource ds;

//    @After
//    public void hapusData() throws Exception {
//        String sql = "delete from employee where emp_name = 'Momochi Zabuza'";
//        try (Connection c = ds.getConnection()) {
//            c.createStatement().executeUpdate(sql);
//        }
//    }

    @Test
    void testInsert() throws SQLException {
        Employee e = new Employee();
        e.setId("943759e6-3b99-4ee1-a464-2612d223e67d");
        e.setEmpName("Momochi Zabuza");
        e.setEmpDesignation("Rogue Ninja");
        e.setEmpSalary(BigDecimal.valueOf(1000000));
        employeeRepository.save(e);

        String sql = "select count(*) as jumlah "
                + "from employee "
                + "where emp_name = 'Momochi Zabuza'";

        try (Connection c = ds.getConnection()) {
            ResultSet rs = c.createStatement().executeQuery(sql);
            Assertions.assertTrue(rs.next());

            long jumlahRow = rs.getRow();
            Assertions.assertEquals(1L, jumlahRow);
            Assertions.assertNotNull(e.getId());
            Assertions.assertNotNull(e.getEmpName());
            Assertions.assertNotNull(e.getEmpDesignation());
            Assertions.assertNotNull(e.getEmpSalary());
        }
    }

    @Test
    void testHitung() {
        employeeRepository.deleteAll();
        Employee e = new Employee();
        e.setId("06ec886f-0e6c-43ba-85db-61f7ed7b20bd");
        e.setEmpName("Chrystine Bumgardner");
        e.setEmpDesignation("Rogue Ninja");
        e.setEmpSalary(BigDecimal.valueOf(2509));

        Employee e1 = new Employee();
        e1.setId("f8bcd896-28a0-42c6-880b-120e45a55856");
        e1.setEmpName("Ory Borrero");
        e1.setEmpDesignation("Rogue Ninja");
        e1.setEmpSalary(BigDecimal.valueOf(212.212));

        Employee e2 = new Employee();
        e2.setId("218e3fe1-0843-4216-929b-5c82f90c0650");
        e2.setEmpName("Cherity Chaparro");
        e2.setEmpDesignation("Rogue Ninja");
        e2.setEmpSalary(BigDecimal.valueOf(212.212));

        employeeRepository.saveAll(Arrays.asList(e, e1, e2));

        long jumlah = employeeRepository.count();
        Assertions.assertEquals(3L, jumlah);
        Assertions.assertNotNull(e2.getId());
        Assertions.assertNotNull(e2.getEmpName());
        Assertions.assertNotNull(e2.getEmpDesignation());
        Assertions.assertNotNull(e2.getEmpSalary());
    }

    @Test
    void testCariById() {
        Employee e = new Employee();
        e.setId("cb783fd9-310f-4c5e-b59c-7659eb8297ce");
        e.setEmpName("Shawniece Gurrola");
        e.setEmpDesignation("Rogue Ninja");
        e.setEmpSalary(BigDecimal.valueOf(212.212));
        employeeRepository.save(e);

        employeeRepository.findById(e.getId());
        Assertions.assertNotNull(e.getId());
    }
    // OK
}
