/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate_github;

public class Certificate {
    private int id;
    private String name;
    private int employeeId;
    
    public Certificate() {
        
    }
    
    public Certificate(String name) {
        this.name = name;
    } 
    
    public int getEmployeeId(){
        return this.employeeId;
    }
    
    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    } 
    
    public String getName() { 
        return name;
    } 
    
    public void setName( String name ) { 
        this.name = name;
    } 
    
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!this.getClass().equals(obj.getClass())) return false;
        Certificate obj2 = (Certificate)obj;
        if((this.id == obj2.getId()) && (this.name.equals(obj2.getName()))) {
            return true;
        }
        return false;
    }
    
    public int hashCode() {
        int tmp = 0;
        tmp = ( id + name ).hashCode();
        return tmp;
    }
}