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
        
        TreeMap set = new TreeMap();
        set.put("ComputerScience", new Certificate("MCA"));
        set.put("ProjectManagement", new Certificate("PMP"));
        set.put("BusinessManagement", new Certificate("MBA"));
        
        /* Add employee records in the database */
        Integer empID = ME.addEmployee("Manoj", "Kumar", 4000, set);
        
        /* Another set of certificates for the second employee */
        TreeMap set2 = new TreeMap();
        set2.put("ComputerScience", new Certificate("MCA"));
        set2.put("BusinessManagement", new Certificate("MBA"));
        
        
        /* Add another employee record in the database */
        Integer empID2 = ME.addEmployee("Dilip", "Kumar", 3000, set2);
        
        /* List down all the employees */
        ME.listEmployees();
        
        /* Update employee's salary records */
        ME.updateEmployee(empID, 5000);
        
        /* Delete an employee from the database */
        ME.deleteEmployee(empID2);
        
        /* List down all the employees */
        ME.listEmployees();
        
        ME.close();
    }
}