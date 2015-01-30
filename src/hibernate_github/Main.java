/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate_github;

import java.util.HashSet;

/**
 *
 * @author Enrique
 */
public class Main {
    
    public static void main(String[] args) {
        ManageEmployee ME = new ManageEmployee(); 
        
        /* Let us have a set of certificates for the first employee */ 
        HashSet set1 = new HashSet(); 
        set1.add(new Certificate("MCA")); 
        set1.add(new Certificate("MBA")); 
        set1.add(new Certificate("PMP")); 
        
        /* Add employee records in the database */ 
        Integer empID1 = ME.addEmployee("Manoj", "Kumar", 4000, set1); 
        
        /* Another set of certificates for the second employee */ 
        HashSet set2 = new HashSet(); 
        set2.add(new Certificate("ACA")); 
        set2.add(new Certificate("AMA")); 
        
        /* Add another employee record in the database */ 
        Integer empID2 = ME.addEmployee("Testero", "Tester", 2000, set2);
        
        /* List down all the employees */ 
        ME.listEmployees(); 
        
        /* Update employee's salary records */ 
        ME.updateEmployee(empID1, 5000); 
        
        /* Delete an employee from the database */
        ME.deleteEmployee(empID2);
        
        /* List down all the employees */
        ME.listEmployees(); 
        
        ME.close();
    }
}