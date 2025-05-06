package model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Scanner;

@Data
public class Account implements BankingService{
    private Integer id;
    private String uuid;
    private String accountType;
    private BigDecimal balance = new BigDecimal("0");
    private final static Scanner scanner = new Scanner(System.in);


    @Override
    public void deposit() {
        System.out.print("[+] Insert Money To Deposit To "+accountType+": ");
        BigDecimal amount = scanner.nextBigDecimal();
        if(amount.compareTo(BigDecimal.ZERO)>0){
            balance = balance.add(amount);
            System.out.println("[+] Deposit Successfully Into " + accountType + " New Balance: " + balance);
        }else{
            System.out.println("[!] You can't deposit 0 or smaller than 0");
        }
    }

    @Override
    public void withDraw() {
        System.out.print("[+] Insert Money To Withdraw From "+accountType+": ");
        BigDecimal amount = scanner.nextBigDecimal();
        if (amount.compareTo(BigDecimal.ZERO)>0 && amount.compareTo(balance)<=0){
            balance = balance.subtract(amount);
            System.out.println("[+] Withdraw Successful From " + accountType + " New Balance: " + balance);
        }else if(amount.compareTo(balance) > 0){
            System.out.println("[!] You Can't withdraw more than your balance");
        }else {
            System.out.println("[!] Withdrawal amount exceeds current balance");
        }
    }

    @Override
    public void showBalance() {
        System.out.println("[+] Your Balance: "+ balance);
    }

    @Override
    public void transfer(Account account) {
        System.out.println("[+] Insert Money To Transfer To "+ account.accountType +": ");
        BigDecimal amount = scanner.nextBigDecimal();
        if (amount.compareTo(BigDecimal.ZERO)>0 && amount.compareTo(balance)<=0){
            account.setBalance(account.getBalance().add(amount));
            System.out.println("[+] Transfer Successful From " + accountType + " New Balance: " + account.balance);
        }else if(amount.compareTo(balance) > 0){
            System.out.println("[!] You Can't transfer more than your balance");
        }else {
            System.out.println("[!] Withdrawal amount exceeds current balance");
        }
    }

    @Override
    public void transactionHistory() {

    }
}
