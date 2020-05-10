package com.company.floatanddouble;

public class User {

    private String name;
    private Long balance;
    private Long accountNo;
    private Long loanAccount;
    public User() {
    }

    public User(String name, Long balance, Long accoutnNo) {
        this.name = name;
        this.balance = balance;
        this.accountNo = accoutnNo;
        this.loanAccount = null;
    }

    public String getName() {
        return name;
    }

    public Long getBalance() {
        return balance;
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public Long getLoanAccount() {
        return loanAccount;
    }

    public void setLoanAccount(Long loanAccount) {
        this.loanAccount = loanAccount;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", accountNo=" + accountNo +
                '}';
    }
}
