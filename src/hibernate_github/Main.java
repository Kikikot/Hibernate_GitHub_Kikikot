/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate_github;

import java.util.TreeMap;

/**
 *
 * @author Enrique
 */
public class Main {
    
    public static void main(String[] args) {
        ManageEmployee ME = new ManageEmployee(); 
        
        /* Add few employee records in database */
        Integer empID1 = ME.addEmployee("Zara", "Ali", 2000);
        Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
        Integer empID3 = ME.addEmployee("John", "Paul", 5000);
        Integer empID4 = ME.addEmployee("Mohd", "Yasee", 3000);
        
        /* List down all the employees */
        ME.listEmployees();
        
        /* Print Total employee's count */
        ME.countEmployee();
        
        /* Print Toatl salary */
        ME.totalSalary();
        
        ME.close();
    }
}