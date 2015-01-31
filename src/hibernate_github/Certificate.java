/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate_github;

public class Certificate {
    private int id;
    private String name;
    
    public Certificate() {
        
    }
    
    public Certificate(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() { 
        return name;
    } 
    
    public void setName( String name ) { 
        this.name = name;
    }
}