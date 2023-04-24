//program for atm interface
import java.util.*;
class ATMinterface
{
    static String username  = "nanditha";
    static int userPin = 1000;
    static int enteredPin;
    static String enteredname;
    static char ans;
    static Scanner sc = new Scanner(System.in);
    static int withdraw(int balance,int amount)
    {
            return balance-amount;
    }
    static int deposit(int balance,int amount)
    {
        return balance+amount;
    }
    static void menu()
    {
        int choice,balance=5000,amount;
        char ans;
        ArrayList<String> transactions = new ArrayList<>();
        do{
            System.out.println("Here are list of transactons you can perform:");
            System.out.println("\n1.Transaction History\n2.Withdraw\n3.Deposit\n4.Transfer\n5.Balance Enquiry\n6.exit");
            System.out.println("\nEnter your choice:");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1 : if (transactions.size()==0)
                            System.out.println("Your Transaction History is empty");
                         else
                            {
                                System.out.println("Transaction History");
                                for(String transaction:transactions)
                                    System.out.println(transaction);
                            }
                        break;
                case 2 :  System.out.println("Enter amount:");
                        amount = sc.nextInt();
                        if (balance >= amount)
                            balance = withdraw(balance,amount);
                        else
                            System.out.println("You cannot make this transaction.");
                        System.out.println("balance amount : "+ balance);
                        transactions.add(amount + " successfully withdrawn from your account.");
                        break;
                case 3 : System.out.println("Enter amount to deposit:");
                        amount = sc.nextInt();
                        balance = deposit(balance,amount);
                        System.out.println("balance amount : "+ balance);
                        transactions.add(amount + " successfully deposited to your account.");
                        break;
                case 4 : System.out.println("Enter recipent's account number: ");
                         int transferAccountNo = sc.nextInt();
                         System.out.println("Enter transfer amount: ");
                         int transferAmount = sc.nextInt();
                         if(transferAmount>balance)
                            System.out.println("Insufficient Balance.");
                         else
                         {
                            balance -= transferAmount;
                            String x = "Your amount " + transferAmount + " is successfully transfered to " + transferAccountNo;
                            System.out.println(x);
                            transactions.add(x);
                         }
                         break;
                case 5 :System.out.println("Your balance : "+ balance);
                        break;
                case 6 : System.exit(0);
            }   
            System.out.println("\ndo you want to continue?");
            ans = sc.next().charAt(0);
        }while(ans =='Y'|| ans =='y');
        System.out.println("Thank you!!");
        System.exit(0);
    }
    public static void main(String args[])
    {
        int attempts=1;
        while(attempts<=3)
        {   
                System.out.println("\nEnter your username:");
                enteredname = sc.next();
                System.out.println("\nEnter your PIN:");
                enteredPin = sc.nextInt();
                if(userPin == enteredPin)
                {
                    System.out.println("\nWelcome to SBI Bank ATM");
                    menu();
                }
                else
                {
                    System.out.println("inavlid credentials.\n");
                    if (attempts==3)
                        System.out.println("You have tried for 3 times already\n");
                }
            attempts++;
        }
    } 
}