/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate_github;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
            Criteria cr = session.createCriteria(Employee.class);
            // Add restriction.
            cr.add(Restrictions.gt("salario", 2000));
            List employees = cr.list();
            
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
    
    /* Method to print total number of records */
    public void countEmployee(){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);
            // To get total row count.
            cr.setProjection(Projections.rowCount());
            List rowCount = cr.list();
            System.out.println("Total Coint: " + rowCount.get(0) );
            tx.commit();
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback(); 
            e.printStackTrace(); 
        }finally { 
            session.close(); 
        } 
    }
    
    /* Method to print sum of salaries */
    public void totalSalary(){ 
        Session session = factory.openSession();
        Transaction tx = null; 
        try{ 
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);
            // To get total salary.
            cr.setProjection(Projections.sum("salario"));
            List totalSalary = cr.list();
            System.out.println("Total Salary: " + totalSalary.get(0) );
            tx.commit();
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally { 
            session.close(); 
        } 
    }
}
