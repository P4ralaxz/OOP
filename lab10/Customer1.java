/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nattawut
 */
public class Customer1 {
    private CheckingAccount Cacct;
    private String firstName;
    private String lastName;
    private Account acct[];
    private int numofAccount;
    
    
    public void addAccount(Account ac){
        acct[numofAccount] = ac;
        numofAccount += 1;
    }
    
    public Account getAccount(int index){
        return acct[index];
    }
    
    public int getNumOfAccount(){
        return numofAccount;
    }
    
    public Customer1(){
        this("","");
        acct = new Account[5];
    }
    
    
    public Customer1(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        acct = new Account[5];
    }
    
    public CheckingAccount getAcct(){
        return Cacct;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setAcct(CheckingAccount acct){
        this.Cacct = acct;
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
        if(acct == null){
            return firstName + " " + lastName + " doesn’t have account.";
        }
        else{
            return this.firstName + " " + this.lastName + " has " + numofAccount + " Account.";
        }
    }
}
