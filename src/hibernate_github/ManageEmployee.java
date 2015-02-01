/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate_github;

import java.util.Iterator;
import java.util.List;
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
        configuration.setInterceptor(new MyInterceptor());
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        factory = configuration.buildSessionFactory(serviceRegistry);
    }
    
    public void close(){
        factory.close();
    }
    
    /* Method to add an employee record in the database */ 
    public Integer addEmployee(String fname, String lname, int salary){ 
        Session session = factory.openSession(); 
        Transaction tx = null;
        Integer employeeID = null; 
        try{ 
            tx = session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary);
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
    
    /* Method to READ all the employees having salary more than 2000 */
    public void listEmployees( ){ 
        Session session = factory.openSession(); 
        Transaction tx = null; 
        try{ 
            tx = session.beginTransaction(); 
            List employees = session.createQuery("FROM Employee").list();
            
            for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                Employee employee = (Employee) iterator.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print(" Last Name: " + employee.getLastName());
                System.out.println(" Salary: " + employee.getSalario());
            }
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback(); 
            e.printStackTrace(); 
        }finally { 
            session.close(); 
        } 
    }
    
    /* Method to UPDATE salary for an employee */ 
    public void updateEmployee(Integer EmployeeID, int salary ){ 
        Session session = factory.openSession(); 
        Transaction tx = null; 
        try{ 
            tx = session.beginTransaction(); 
            Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
            employee.setSalario( salary );
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally { 
            session.close(); 
        } 
    }
    
    /* Method to DELETE an employee from the records */
    public void deleteEmployee(Integer EmployeeID){ 
        Session session = factory.openSession(); 
        Transaction tx = null; 
        try{ tx = session.beginTransaction(); 
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
