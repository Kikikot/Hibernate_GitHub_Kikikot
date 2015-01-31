/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate_github;

import java.util.HashMap;

/**
 *
 * @author Enrique
 */
public class Main {
    
    public static void main(String[] args) {
        ManageEmployee ME = new ManageEmployee(); 
        
        HashMap set = new HashMap();
        set.put("ComputerScience", new Certificate("MCA"));
        set.put("BusinessManagement", new Certificate("MBA"));
        set.put("ProjectManagement", new Certificate("PMP"));
        
        /* Add employee records in the database */
        Integer empID = ME.addEmployee("Manoj", "Kumar", 4000, set);
        
        /* List down all the employees */
        ME.listEmployees();
        
        /* Update employee's salary records */
        ME.updateEmployee(empID, 5000);
        
        /* List down all the employees */
        ME.listEmployees();
        
        ME.close();
    }
}