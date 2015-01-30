/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_hibernate_a_mano;

/**
 *
 * @author Enrique
 */
public class Main {
    
    public static void main(String[] args) {
        
        ManageEmployee ME = new ManageEmployee();
        
        /* Add few employee records in database */
        Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
        Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
        Integer empID3 = ME.addEmployee("John", "Paul", 10000);
        
    /*    Integer empID1 = 26;
        Integer empID2 = 27;
        Integer empID3 = 28;
    */    
        // List down all the employees
        ME.listEmployees();
        
        // Update employee's records
        ME.updateEmployee(empID1, 5000);
        
        // Delete an employee from the database
        ME.deleteEmployee(empID2);
        
        // List down new list of the employees
        ME.listEmployees();
    
        ME.close();
    }
}

//<mapping class="ad_hibernate_a_mano.Employee"/>
//<mapping resource="ad_hibernate_a_mano/Employee.hbm.xml"/>