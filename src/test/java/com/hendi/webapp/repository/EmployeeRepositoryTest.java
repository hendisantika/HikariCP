/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendi.webapp.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 *
 * @author hendi.santika
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = SpringBootDemoApplication.class)
@Sql(
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts = {"/data/employee.sql"}
)
public class EmployeeRepositoryTest {
    
    @Autowired
    private EmployeeRepository er;
    
    @Autowired
    private DataSource ds;
    
//    @After
//    public void hapusData() throws Exception {
//        String sql = "delete from employee where emp_name = 'Momochi Zabuza'";
//        try (Connection c = ds.getConnection()) {
//            c.createStatement().executeUpdate(sql);
//        }
//    }
    
//    @Test
//    public void testInsert() throws SQLException {
//        Employee e = new Employee();
////        e.setId("444");
//        e.setEmpName("Momochi Zabuza");
//        e.setEmpDesignation("Rogue Ninja");
//        e.setEmpSalary(212.212F);
//        er.save(e);
//        
//        
//        String sql = "select count(*) as jumlah "
//                + "from employee "
//                + "where emp_name = 'Momochi Zabuza'";
//        
//        try (Connection c = ds.getConnection()) {
//            ResultSet rs = c.createStatement().executeQuery(sql);
//            Assert.assertTrue(rs.next());
//            
//            Long jumlahRow = rs.getLong("jumlah");
//            Assert.assertEquals(1L, jumlahRow.longValue());
//        }
//    }
    
    @Test
    public void testHitung(){
        Long jumlah = er.count();
        Assert.assertEquals(3L, jumlah.longValue());
    }
    
//    @Test
//    public void testCariById(){
//        Employee e = er.findOne("aa3");
//        Assert.assertNotNull(e);
//        Assert.assertEquals("Monkey D. Luffy", e.getEmpName());
//        Assert.assertEquals("Mugiwara Captain", e.getEmpDesignation());
//        
//        Employee ex = er.findOne("aa4");
//        Assert.assertNull(ex);
//    }
    // OK
}
