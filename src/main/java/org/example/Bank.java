package org.example;

import java.util.Scanner;

class BankAccount{
    private String accntNumber;
    private String accntHolderName;
    private double banalce;

    public String getAccntNumber() {
        return accntNumber;
    }

    public void setAccntNumber(String accntNumber) {
        this.accntNumber = accntNumber;
    }

    public String getAccntHolderName() {
        return accntHolderName;
    }

    public void setAccntHolderName(String accntHolderName) {
        this.accntHolderName = accntHolderName;
    }

    public double getBanalce() {
        return banalce;
    }

    public void setBanalce(double banalce) {
        this.banalce = banalce;
    }

    //constructor
    public BankAccount(String accntNumber, String accntHolderName, double banalce) {
        this.accntNumber = accntNumber;
        this.accntHolderName = accntHolderName;
        this.banalce = banalce;
    }

    //Desposit method
    public void deposit(double bal){
        if(banalce>0){
            bal+=banalce;
            System.out.println("bal deposited successfully");
        }else {
            System.out.println("invalid amount");
        }
    }

    //withdraw balance
    public void withdrwa(double bal1){
        if(banalce >0 && banalce<=bal1){
            banalce-=bal1;
            System.out.println("withdraw successfully");
        }else{
            System.out.println("insufficient  balance");
        }
    }
}


public class Bank {
    private static BankAccount[] accnt = new BankAccount[5];
    private static int accntNum = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1. create accnt");
            System.out.println("2.  desosit");
            System.out.println("3. withdrwa");
            System.out.println("4. check balance");
            System.out.println("5. exit");
            System.out.println("choose options");
            int ch = sc.nextInt();

            switch (ch){
                case 1 : createaccnt(sc);
                case 2 : desposit(sc);
                case 3:
                case 4:
                case 5:
            }
        }
    }
    public static void createaccnt(Scanner sc){
        if(accntNum >=  accnt.length){
            System.out.println("create accnt");
        }
        System.out.println("enter accnt num");
        String accntNumber = sc.next();

        System.out.println("enter accnt holder name");
        String accntHolderName = sc.next();

        System.out.println("enter initial bal");
        double accntbal = sc.nextDouble();

        BankAccount bankAccount = new BankAccount(accntNumber,accntHolderName,accntbal);
        accnt[accntNum] = bankAccount;
        accntNum++;

        System.out.println("accnt created successfully");
    }

    //desposit

    public static void desposit(Scanner sc){
        String accountNumber = sc.next();

        System.out.println("enter accnt number");
        BankAccount account = findAccount(accountNumber);
        if(account!=null){
            double amount = sc.nextDouble();
            account.deposit(amount);
        }
        else {
            System.out.println("accnt not found");
            }
        }

        //find acccnt number
    private static BankAccount findAccount(String accountNumber) {
        for (int  i =0;i<accntNum;i++){
            if(accnt[i].getAccntNumber().equals(accountNumber)){
                return accnt[i];
            }
        }
        return null;
    }


}
