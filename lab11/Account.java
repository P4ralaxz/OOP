/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nattawut
 */
public class Account {
    protected double balance;
    protected String name;
    
    public Account(double balance, String name){
        this.balance = balance;
        this.name = name;
    }
    
    public void withdraw(double amount) throws WithdrawException {
        if (this.balance < amount){
            throw new WithdrawException("Account "+getName()+" has not enough money!");
        }else if(amount > 0){
            setBalance(getBalance() - amount);
            System.out.println(amount + " baht is withdraw from " + getName() + ".");
        }
        else{
            System.out.println("Input number must be a positive integer.");
        }
    }
    
    public double getBalance(){
        return balance;
    }
    
    public String getName(){
        return name;
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void deposit(double a){
        if (a>=0){
            balance += a;
            System.out.println(a + " baht is deposited to " + name + ".");
        }else{
            System.out.println("Input number must be a positive integer.");
        }
    }
    
    
    
    public void showAccount(){
        System.out.println(name + " account has " + balance + " baht.");
    }
}
