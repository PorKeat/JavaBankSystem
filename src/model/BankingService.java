package model;

public interface BankingService {
    void deposit();
    void withDraw();
    void showBalance();
    void transfer(Account account);
    void transactionHistory();
}
