/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nattawut
 */
public class Customer {
    private CheckingAccount acct;
    private String firstName;
    private String lastName;
    
    public Customer(){
        this("","",null);
    }
    
    public Customer(String firstName, String lastName, CheckingAccount acct){
        this.firstName = firstName;
        this.lastName = lastName;
        this.acct = acct;
    }
    
    public Customer(String firstName, String lastName){
        this(firstName,lastName,null);
    }
    
    public CheckingAccount getAcct(){
        return acct;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setAcct(CheckingAccount acct){
        this.acct = acct;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public boolean equals(Customer c){
        return !firstName.equals(lastName);
    }
    
    @Override
    public String toString(){
        if (acct == null){
            return (firstName + " " + lastName + " doesn’t have account.");
        }else{
            return ("The " + firstName + " account has " + acct.getBalance() + " baht and " + acct.getCredit() +" credits.");
        }
    }
}
