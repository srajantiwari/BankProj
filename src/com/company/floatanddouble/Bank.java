package com.company.floatanddouble;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import static java.lang.Math.*;

public class Bank {

    public static long accountCount = (long)(random()*23784273);
    public static long loanAccountCount = (long)(random()*23784273);
    private HashMap<Long,User> accountHolders = new HashMap<Long,User>();

    public void createAccount (String username, long money){
        User user = new User(username,money,accountCount);
        accountHolders.put(accountCount,user);
        accountCount++;
        System.out.println("Account Created!");
    }

    public void depositMoney ( long accountNo , long money ){
        User user = getUser(accountNo);
        if(user == null){
            System.out.println("The user is not an account holder");
        }
        else{
            user.setBalance(user.getBalance() + money);
            System.out.println("Balance has been updated to : "+user.getBalance());
        }
    }

    public void depositMoney ( String username , long money ){
        User user = getUser(username);
        if(user == null){
            System.out.println("The user is not an account holder");
        }
        else{
            user.setBalance(user.getBalance() + money);
            System.out.println("Balance has been updated to : "+user.getBalance());
        }
    }

    public void withdrawMoney ( long accountNo , long money ){
        User user = getUser(accountNo);
        if(user == null){
            System.out.println("The user is not an account holder");
        }
        else{
            user.setBalance(user.getBalance() - money);
            System.out.println("Balance has been updated to : "+user.getBalance());
        }
    }

    public void withdrawMoney ( String username , long money ){
        User user = getUser(username);
        if(user == null){
            System.out.println("The user is not an account holder");
        }
        else{
            user.setBalance(user.getBalance() - money);
            System.out.println("Balance has been updated to : "+user.getBalance());
        }
    }

    public void grantLoan ( long accountNo , long money ) {
        User user = getUser(accountNo);
        if(user == null){
            System.out.println("User is not an account holder");
        }
        else{
            if(user.getLoanAccount() == null) {
                user.setLoanAccount(loanAccountCount);
                loanAccountCount++;
            }
            user.setBalance(user.getBalance() + money);
            System.out.println("Balance has been updated to : "+user.getBalance());
        }
    }

    public void showBalance(long accountNo){
        if(getUser(accountNo) != null){
            System.out.println(getUser(accountNo).toString());
        }
        else{
            System.out.println("Sorry, please try entering account number, either no account exists or multiple accounts with same name exist!");
        }
    }

    public void showBalance(String username){
        if(getUser(username) != null){
            System.out.println(getUser(username).toString());
        }
        else{
            System.out.println("Sorry, please try entering account number, either no account exists or multiple accounts with same name exist!");
        }
    }

    public User getUser(String username){
        int noOfAccountsWithSameName = 0;
        User requiredUser = null;
        for (Map.Entry user : accountHolders.entrySet()) {
            User userObject = (User) user.getValue();
            if(userObject.getName().equals(username)){
                noOfAccountsWithSameName++;
                requiredUser = userObject;
            }
        }

        if(noOfAccountsWithSameName == 1){
            return requiredUser;
        }
        else{
            return null;
        }
    }

    public User getUser(long accountNo){
        return accountHolders.getOrDefault(accountNo, null);
    }
}