/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate_github;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Enrique
 */
public class ManageEmployee {
    
    private static SessionFactory factory;
    
    public ManageEmployee(){
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        factory = configuration.buildSessionFactory(serviceRegistry);
    }
    
    public void close(){
        factory.close();
    }
    
    /* Method to add an employee record in the database */ 
    public Integer addEmployee(String fname, String lname, int salary, HashMap cert){ 
        Session session = factory.openSession(); 
        Transaction tx = null;
        Integer employeeID = null; 
        try{ 
            tx = session.beginTransaction(); 
            Employee employee = new Employee(fname, lname, salary); 
            employee.setCertificates(cert); 
            employeeID = (Integer) session.save(employee); 
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback(); 
            e.printStackTrace(); 
        }finally { 
            session.close(); 
        } 
        return employeeID; 
    } 
    
    /* Method to list all the employees detail */ 
    public void listEmployees( ){ 
        Session session = factory.openSession(); 
        Transaction tx = null; 
        try{ 
            tx = session.beginTransaction(); 
            List employees = session.createQuery("FROM Employee").list(); 
            for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();){ 
                Employee employee = (Employee) iterator1.next(); 
                System.out.print("First Name: " + employee.getFirstName()); 
                System.out.print("    Last Name: " + employee.getLastName()); 
                System.out.println("    Salary: " + employee.getSalario()); 
                Map certificates = employee.getCertificates(); 
                System.out.println("Certificate: " +
                        (((Certificate)certificates.get("ComputerScience")).getName())); 
                System.out.println("Certificate: " +
                        (((Certificate)certificates.get("BusinessManagement")).getName()));
                System.out.println("Certificate: " +
                        (((Certificate)certificates.get("ProjectManagement")).getName()));
            } tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback(); 
            e.printStackTrace(); 
        }finally { 
            session.close(); 
        } 
    }
    
    /* Method to update salary for an employee */ 
    public void updateEmployee(Integer EmployeeID, int salary ){ 
        Session session = factory.openSession(); 
        Transaction tx = null; 
        try{ 
            tx = session.beginTransaction(); 
            Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
            employee.setSalario( salary ); 
            session.update(employee); 
            tx.commit(); 
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback(); 
            e.printStackTrace(); 
        }finally { 
            session.close(); 
        } 
    } 
    
    /* Method to delete an employee from the records */ 
    public void deleteEmployee(Integer EmployeeID){ 
        Session session = factory.openSession(); 
        Transaction tx = null; 
        try{ 
            tx = session.beginTransaction(); 
            Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
            session.delete(employee); 
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback(); 
            e.printStackTrace(); 
        }finally { 
            session.close(); 
        } 
    }
}
