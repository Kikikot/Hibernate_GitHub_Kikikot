/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate_github;

import java.util.Collection;

public class Employee {
    
    private int id;
    
    private String firstName;
    
    private String lastName;
    
    private int salario;
    
    private Collection<Certificate> certificates;

    public Employee() {
    }
    
    public Employee(String firstName, String lastName, Integer salario) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salario = salario;
    }
    
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    
    public Collection<Certificate> getCertificates() {
        return certificates;
    }
    
    public void setCertificates(Collection<Certificate> certificates) {
        this.certificates = certificates;
    }
}
