package com.company.floatanddouble;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<String,Bank> bank = new HashMap<String,Bank>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Hello There !");
        int choice = 0;
        showMenu();
        do{
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    System.out.println("Enter your name");
                    String name = sc.nextLine();
                    System.out.println("Enter the bank name");
                    String bankName = sc.nextLine();
                    System.out.println("Enter the account balance");
                    long balance = Long.parseLong(sc.nextLine());
                    createAccount(bankName,name,balance);
                    break;
                case 2:
                    System.out.println("Enter the bank name");
                    bankName = sc.nextLine();
                    System.out.println("Enter account name or account number");
                    String arg = sc.nextLine();
                    showBalance(bankName,arg);
                    break;
                case 3:
                    System.out.println("Enter the bank name");
                    bankName = sc.nextLine();
                    System.out.println("Enter the money to be deposited");
                    long money = Long.parseLong(sc.nextLine());
                    System.out.println("Enter account name or account number");
                    arg = sc.nextLine();
                    depositMoney(bankName,money,arg);
                    break;
                case 4:
                    System.out.println("Enter the bank name");
                    bankName = sc.nextLine();
                    System.out.println("Enter the money to be withdrawn");
                    money = Long.parseLong(sc.nextLine());
                    System.out.println("Enter account name or account number");
                    arg = sc.nextLine();
                    withdrawMoney(bankName,money,arg);
                    break;
                case 5:
                    System.out.println("Enter the bank name");
                    bankName = sc.nextLine();
                    System.out.println("Enter the money for loan");
                    money = Long.parseLong(sc.nextLine());
                    System.out.println("Enter account number");
                    long loanAccount = Long.parseLong(sc.nextLine());
                    bank.get(bankName).grantLoan(loanAccount,money);
                    break;
                case 6:
                    showMenu();
            }
        }while(choice!=7);

    }

    private static void depositMoney(String bankName, long money, String arg) {
        if(bank.containsKey(bankName) == false){
            Bank newBank = new Bank();
            bank.put(bankName,newBank);
        }
        if(whatIsArg(arg)==0) System.out.println("Wrong account name or account number");
        else if(whatIsArg(arg)==1) bank.get(bankName).depositMoney(Long.parseLong(arg),money);
        else bank.get(bankName).depositMoney(arg,money);
    }

    private static void withdrawMoney(String bankName, long money, String arg) {
        if(bank.containsKey(bankName) == false){
            Bank newBank = new Bank();
            bank.put(bankName,newBank);
        }
        if(whatIsArg(arg)==0) System.out.println("Wrong account name or account number");
        else if(whatIsArg(arg)==1) bank.get(bankName).withdrawMoney(arg,money);
        else bank.get(bankName).withdrawMoney(arg,money);
    }

    private static void showBalance(String bankName, String arg) {
        if(bank.containsKey(bankName) == false){
            Bank newBank = new Bank();
            bank.put(bankName,newBank);
        }
        if(whatIsArg(arg)==0) System.out.println("Wrong account name or account number");
        else if(whatIsArg(arg)==1) bank.get(bankName).showBalance(Long.parseLong(arg));
        else bank.get(bankName).showBalance(arg);
    }

    private static int whatIsArg(String arg) {
        int length = arg.length();
        int isAccountNo = 0;
        for(int i=0;i<length;i++){
            if(isAccountNo == 0 && (arg.charAt(i) >= '0') && (arg.charAt(i) <= '9'))
                isAccountNo = 1;
            else if(isAccountNo == 1)
                isAccountNo = 3;
            else if(isAccountNo == 0)
                isAccountNo = 2;
        }
        return isAccountNo;
    }

    private static void createAccount(String bankName, String name, Long money) {
        if(bank.containsKey(bankName) == false){
            Bank newBank = new Bank();
            bank.put(bankName,newBank);
        }
        bank.get(bankName).createAccount(name,money);
    }

    public static void showMenu(){
        System.out.println("1. Create Account");
        System.out.println("2. Show Balance");
        System.out.println("3. Deposit Money");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Apply for Loan");
        System.out.println("6. Show Menu");
        System.out.println("7. Quit");
    }
}