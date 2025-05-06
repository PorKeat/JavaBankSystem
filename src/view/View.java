package view;

import model.CreditAccount;
import model.SavingAccount;

import java.util.Scanner;

public class View {
    private final static Scanner scanner = new Scanner(System.in);
    private final static SavingAccount savingAccount = new SavingAccount();
    private final static CreditAccount creditAccount = new CreditAccount();

    public static int chooseOption(){
        System.out.print("Choose option: ");
        return scanner.nextInt();
    }

    public  static void title(String title) {
        int totalWidth = 25;
        int titleLength = title.length();
        int equalCount = (totalWidth - titleLength) / 2;
        int remainder = (totalWidth - titleLength) % 2;
        System.out.println("=".repeat(equalCount) + title + "=".repeat(equalCount + remainder));
    }

    public  static void line(){
        System.out.println("=".repeat(24));
    }

    public  static void menu(String type){
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Show Balance");
        System.out.println("4. Transaction History");
        if (type.equals("saving")){
            System.out.println("5. Back");
        }
        if (type.equals("credit")){
            System.out.println("5. Transfer");
            System.out.println("6. Back");
        }
    }

    public void view(){
        try {
            while (true){
                title("Account");
                System.out.println("1. Saving Account");
                System.out.println("2. Credit Account");
                System.out.println("3. Exit");
                line();
                switch (chooseOption()){
                    case 1->{
                        inner:
                        while (true){
                            title("Saving Account");
                            menu("saving");
                            line();
                            switch (chooseOption()){
                                case 1 -> savingAccount.deposit();
                                case 2 -> savingAccount.withDraw();
                                case 3 -> savingAccount.showBalance();
                                case 4 -> savingAccount.transactionHistory();
                                case 5 -> {
                                    break inner;
                                }
                            }
                        }
                    }
                    case 2-> {
                        inner:
                        while (true){
                            title("Credit Account");
                            menu("credit");
                            line();
                            switch (chooseOption()){
                                case 1 -> creditAccount.deposit();
                                case 2 -> creditAccount.withDraw();
                                case 3 -> creditAccount.showBalance();
                                case 4 ->  creditAccount.transactionHistory();
                                case 5 -> creditAccount.transfer(savingAccount);
                                case 6 -> {
                                    break inner;
                                }
                            }
                        }
                    }
                    case 3-> System.exit(0);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
