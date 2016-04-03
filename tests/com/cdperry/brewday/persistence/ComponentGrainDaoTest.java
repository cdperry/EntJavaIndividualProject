package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ComponentGrainEntity;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.sql.Date;

import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class ComponentGrainDaoTest {

    @Test
    public void testGetAllComponentGrains() throws Exception {

        ComponentGrainDao me = new ComponentGrainDao();
        ComponentGrainEntity testComponent;
        List<ComponentGrainEntity> componentGrains;
        int componentGrainEntityID;
        java.util.Date now = new java.util.Date();
        java.sql.Date date = new java.sql.Date(now.getTime());

        // create a test grain and add them to the database
        testComponent = new ComponentGrainEntity();
        testComponent.setName("Grain 1");
        testComponent.setOriginId(1);
        testComponent.setSupplierId(1);
        testComponent.setGrainTypeId(1);
        testComponent.setColor(new BigDecimal("1.5"));
        testComponent.setPotential(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(date);
        testComponent.setCreateDate(date);

        componentGrainEntityID = me.addComponentGrainEntity(testComponent);

        // create a test grain and add them to the database
        testComponent = new ComponentGrainEntity();
        testComponent.setName("Grain 2");
        testComponent.setOriginId(1);
        testComponent.setSupplierId(1);
        testComponent.setGrainTypeId(1);
        testComponent.setColor(new BigDecimal("1.5"));
        testComponent.setPotential(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(date);
        testComponent.setCreateDate(date);

        componentGrainEntityID = me.addComponentGrainEntity(testComponent);

        componentGrains = me.getAllComponentGrains();
        assertTrue(componentGrains.size() > 0);

        // clean up
        for (ComponentGrainEntity component : componentGrains) {
            me.deleteComponentGrainEntity(component);
        }

    }

    @Test
    public void testGetComponentGrainEntity() throws Exception {

        ComponentGrainDao me = new ComponentGrainDao();
        ComponentGrainEntity testComponent = new ComponentGrainEntity();
        int componentGrainEntityID;
        java.util.Date now = new java.util.Date();
        java.sql.Date date = new java.sql.Date(now.getTime());

        // create a test grain and add them to the database
        testComponent.setName("Grain");
        testComponent.setOriginId(1);
        testComponent.setSupplierId(1);
        testComponent.setGrainTypeId(1);
        testComponent.setColor(new BigDecimal("1.5"));
        testComponent.setPotential(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(date);
        testComponent.setCreateDate(date);

        componentGrainEntityID = me.addComponentGrainEntity(testComponent);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero component ID, got " + componentGrainEntityID, componentGrainEntityID > 0);

        // confirm that the component can be retrieved from the database
        testComponent = me.getComponentGrainEntity(componentGrainEntityID);
        assertNotNull(testComponent);

        // clean up
        me.deleteComponentGrainEntity(testComponent);

    }

    @Test
    public void testUpdateComponentGrainEntity() throws Exception {

        ComponentGrainDao me = new ComponentGrainDao();
        ComponentGrainEntity testComponent = new ComponentGrainEntity();
        int componentGrainEntityID;
        java.util.Date now = new java.util.Date();
        java.sql.Date date = new java.sql.Date(now.getTime());

        // create a test component and add them to the database
        testComponent.setName("Grain");
        testComponent.setOriginId(1);
        testComponent.setSupplierId(1);
        testComponent.setGrainTypeId(1);
        testComponent.setColor(new BigDecimal("1.5"));
        testComponent.setPotential(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(date);
        testComponent.setCreateDate(date);

        componentGrainEntityID = me.addComponentGrainEntity(testComponent);

        // retrieve the test component from the database and change its name
        testComponent = me.getComponentGrainEntity(componentGrainEntityID);
        testComponent.setName("New Name");
        me.updateComponentGrainEntity(testComponent);

        // retrieve the updated employee and test that the update took place
        testComponent = me.getComponentGrainEntity(componentGrainEntityID);

        assertEquals("Expected New Name, got " + testComponent.getName(),
                "New Name", testComponent.getName());

        // clean up
        me.deleteComponentGrainEntity(testComponent);

    }

    @Test
    public void testDeleteComponentGrainEntity() throws Exception {

        ComponentGrainDao me = new ComponentGrainDao();
        ComponentGrainEntity testComponent = new ComponentGrainEntity();
        int componentGrainEntityID;
        java.util.Date now = new java.util.Date();
        java.sql.Date date = new java.sql.Date(now.getTime());

        // create a test component and add them to the database
        testComponent.setName("Grain");
        testComponent.setOriginId(1);
        testComponent.setSupplierId(1);
        testComponent.setGrainTypeId(1);
        testComponent.setColor(new BigDecimal("1.5"));
        testComponent.setPotential(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(date);
        testComponent.setCreateDate(date);

        componentGrainEntityID = me.addComponentGrainEntity(testComponent);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero component ID, got " + componentGrainEntityID, componentGrainEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteComponentGrainEntity(me.getComponentGrainEntity(componentGrainEntityID));
        assertNull(me.getComponentGrainEntity(componentGrainEntityID));

    }

    @Test
    public void testAddComponentGrainEntity() throws Exception {

        ComponentGrainDao me = new ComponentGrainDao();
        ComponentGrainEntity testComponent = new ComponentGrainEntity();
        int componentGrainEntityID;
        java.util.Date now = new java.util.Date();
        java.sql.Date date = new java.sql.Date(now.getTime());

        // create a test component and add them to the database
        testComponent.setName("Grain");
        testComponent.setOriginId(1);
        testComponent.setSupplierId(1);
        testComponent.setGrainTypeId(1);
        testComponent.setColor(new BigDecimal("1.5"));
        testComponent.setPotential(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(date);
        testComponent.setCreateDate(date);

        componentGrainEntityID = me.addComponentGrainEntity(testComponent);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero component ID, got " + componentGrainEntityID, componentGrainEntityID > 0);

        // clean up
        testComponent = me.getComponentGrainEntity(componentGrainEntityID);
        me.deleteComponentGrainEntity(testComponent);

    }

    /*
    public class EmployeeDaoWithHibernateTest {

        @Test
        public void testGetAllEmployees() throws Exception {
            EmployeeDaoWithHibernate me = new EmployeeDaoWithHibernate();
            List<Employee> employees = me.getAllEmployees();
            assertTrue(employees.size() > 0);
        }

        @Test
        public void testGetEmployee() throws Exception {

            EmployeeDaoWithHibernate me = new EmployeeDaoWithHibernate();
            Employee testEmployee = new Employee();
            int employeeID;

            // create a test employee and add them to the database
            testEmployee.setFirstName("Chris");
            testEmployee.setLastName("Perry");
            testEmployee.setSocialSecurityNumber("111-11-1111");
            testEmployee.setDepartment("IT");
            testEmployee.setRoom("123");
            testEmployee.setPhone("704-2052");

            employeeID = me.addEmployee(testEmployee);

            // confirm that a non-zero employee ID was returned (indicator of success)
            assertTrue("Expected a non-zero employee ID, got " + employeeID, employeeID > 0);

            // confirm that the employee can be retrieved from the database
            testEmployee = me.getEmployee(employeeID);
            assertNotNull(testEmployee);

            // clean up
            me.deleteEmployee(testEmployee);

        }

        @Test
        public void testUpdateEmployee() throws Exception {

            EmployeeDaoWithHibernate me = new EmployeeDaoWithHibernate();
            Employee testEmployee = new Employee();
            int employeeID;

            // create a test employee and add them to the database
            testEmployee.setFirstName("Chris");
            testEmployee.setLastName("Perry");
            testEmployee.setSocialSecurityNumber("111-11-1111");
            testEmployee.setDepartment("IT");
            testEmployee.setRoom("123");
            testEmployee.setPhone("704-2052");

            employeeID = me.addEmployee(testEmployee);

            // retrieve the test employee from the database and change their last name
            testEmployee = me.getEmployee(employeeID);
            testEmployee.setLastName("THISISATEST");
            me.updateEmployee(testEmployee);

            // retrieve the updated employee and test that the update took place
            testEmployee = me.getEmployee(employeeID);

            assertEquals("Expected THISISATEST, got " + testEmployee.getLastName(),
                    "THISISATEST", testEmployee.getLastName());

            // clean up
            me.deleteEmployee(testEmployee);

        }

        @Test
        public void testDeleteEmployee() throws Exception {

            EmployeeDaoWithHibernate me = new EmployeeDaoWithHibernate();
            Employee testEmployee = new Employee();
            int employeeID;

            // create a test employee and add them to the database
            testEmployee.setFirstName("Chris");
            testEmployee.setLastName("Perry");
            testEmployee.setSocialSecurityNumber("111-11-1111");
            testEmployee.setDepartment("IT");
            testEmployee.setRoom("123");
            testEmployee.setPhone("704-2052");

            employeeID = me.addEmployee(testEmployee);

            // make sure the employee was added before proceeding
            assertTrue("Expected a non-zero employee ID, got " + employeeID, employeeID > 0);

            // delete the employee and verify that they are no longer in the database
            me.deleteEmployee(me.getEmployee(employeeID));
            assertNull(me.getEmployee(employeeID));

        }

        @Test
        public void testAddEmployee() throws Exception {

            EmployeeDaoWithHibernate me = new EmployeeDaoWithHibernate();
            Employee testEmployee = new Employee();
            int employeeID;

            // create a test employee and add them to the database
            testEmployee.setFirstName("Chris");
            testEmployee.setLastName("Perry");
            testEmployee.setSocialSecurityNumber("111-11-1111");
            testEmployee.setDepartment("IT");
            testEmployee.setRoom("123");
            testEmployee.setPhone("704-2052");

            employeeID = me.addEmployee(testEmployee);

            // confirm that a non-zero employee ID was returned (indicator of success)
            assertTrue("Expected a non-zero employee ID, got " + employeeID, employeeID > 0);

            // clean up
            testEmployee = me.getEmployee(employeeID);
            me.deleteEmployee(testEmployee);

        }

    }
    */
}