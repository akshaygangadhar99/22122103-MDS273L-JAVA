import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalTime;

class Lab4{
    // Declare the global variables
    static int acNo;
    static String acHoldName;
    static int acBal;    
    static Scanner sc = new Scanner(System.in);

    static void userAcNo(){
        // Description: Collect Account no. data
        System.out.println("Enter User Account No.: ");
        acNo = Integer.parseInt(sc.nextLine());    
        
    }

    static void userName(){
        // Description: Collect Account Holder Name data
        System.out.println("Enter Account Holder Name: ");
        acHoldName = sc.nextLine();
    }

    static void userAcBal(){
        // Description: Collect Account Balance Data
        System.out.println("Enter Account Balance: ");
        acBal = Integer.parseInt(sc.nextLine());
    }

    static void intializeCust(){
        // Description: Call the appropriate functions to initialize customer account
        userAcNo();
        userName();
        userAcBal();
    }

    static void accountSummary(){
        // Description: Display account information
        System.out.println("Account Number: "+acNo);
        System.out.println("Account Holder Name:"+acHoldName);
        System.out.println("Final Account Balance: "+acBal);
    }

    static int Deposit(){
        // Description: Collect deposit amount and modify account balance
        System.out.println("Enter amount to be deposited: ");
        int depAmt = Integer.parseInt(sc.nextLine());
        acBal += depAmt;
        return depAmt;
    }

    static int[] Withdraw(){
        // Description: Collect Withdrawal Amount and Check for Appropriate Conditions Before Allowing Transaction
        int[] wdResult = new int[2];
        System.out.println("Enter amount to be withdrawn: ");
        int wdAmt = Integer.parseInt(sc.nextLine());
        wdResult[0] = wdAmt;
        int tempAcBal = acBal - wdAmt;
        if (tempAcBal<0){
            System.out.println("INSUFFICIENT FUNDS. PLEASE TRY AGAIN!!!");
            wdResult[1] = 1;
            // If wdResult[1] = 1, then the transaction will NOT be added
        } else{
            acBal = tempAcBal;
            wdResult[1] = 0;
            // if wdResult[1] = 0, then the transaction will be added to summary
        }        
        return wdResult;        
    }

    static String[][] addTransactions(int type, int amt, String[][] transArr, int indexCount){
        /* 
        Description: Update the transaction summary data in the 2D corresponding 2D array
        Arguments (explanation):
            type = 1: Deposit 
            type = 2: Withdraw
        */ 

        // Transaction No.
        transArr[indexCount][0] = Integer.toString(indexCount);

        // Date:
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
        transArr[indexCount][1] = dateFormat.format(date);

        // Time:
        LocalTime time = LocalTime.now();
        transArr[indexCount][2] = time.toString();

        // Transaction Amount
        if (type==1){
            transArr[indexCount][3] = "+" + Integer.toString(amt);
            //indexCount will be incremented outside the function
        }
        else{
            transArr[indexCount][3] = "-" + Integer.toString(amt);
        }
        
        // New balance:
        transArr[indexCount][5] = Integer.toString(acBal);

        // Input new balance as old balance of next row:
        transArr[indexCount+1][4] = Integer.toString(acBal);

        return transArr;  
    }

    static String[][] initTransSummary(){
        // Set maximum transaction limit to 50 for present program
        String[][] transSummary = new String[50][6];
        transSummary[0][0] = "Transaction No.";
        transSummary[0][1] = "Date";
        transSummary[0][2] = "Time";
        transSummary[0][3] = "Amount";
        transSummary[0][4] = "Previous Balance";
        transSummary[0][5] = "Current Balance";
        
        // Input original balance as old balance for transaction #1
        transSummary[1][4] = Integer.toString(acBal);
        return transSummary;
    }

    static void printTransactions(String[][] transSummary, int indexCount){
        // Description: Display the Account Transaction Summary in tabular format using custom centerString function
        int counter = (20*6) + 2 + (2*5);
        System.out.println("****************************************************ACCOUNT TRANSACTION SUMMARY*****************************************************");
        String s = "";
        for (int i=0; i<indexCount; i++){
            if (i<2) {                
                for(int k=0; k<counter;k++){
                    System.out.print("-");
                }
                System.out.println("");
            }
            for(int j=0; j<6; j++){
                s = centerString(transSummary[i][j],20);
                System.out.print("|"+s+"|");
            }
            System.out.println("");
        }
        for (int k=0; k<counter; k++){
            System.out.print("-");
        }
    }

    // CENTER FUNCTION
    static String centerString(String s, int n){
        int len_s = s.length();
        int startInd;
        if (n%2==0){
            if (len_s%2!=0){
                // Word is of odd-length
                startInd = (n/2) - (len_s+1)/2;
            } else{
                // Word is of even-length
                startInd = (n/2) - (len_s)/2;
            }            
        } else{
            if (len_s%2!=0){
                // Word is of odd-length
                startInd = ((n-1)/2) - (len_s-1)/2;
            } else{
                // Word is of even-length
                startInd = ((n-1)/2) - (len_s/2) + 1;
            }
        }
        
        String str = "";
        for(int i=0; i<startInd; i++){
            str += " ";
        }  

        for(int i=0; i<len_s; i++){
            str += s.charAt(i);
        }

        int finalCount = startInd + len_s;
        while (finalCount<n){
            str += " ";
            finalCount += 1;
        }

        return str;
    }

    public static void main(String args[]){
        // Obtain intial account summary details
        intializeCust();
        String[][] transSummary = initTransSummary();
        int indexCount = 1;

        int check = 0;
        while (check==0){
            System.out.println("\nEnter: \n1-Deposit \n2-Withdraw \n3-Print Transactions \n4-Account Summary \n5-Exit");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    int depAmt = Deposit();
                    transSummary = addTransactions(1, depAmt, transSummary, indexCount);
                    indexCount += 1;
                    break;
                case 2:
                    int[] wdResult = Withdraw();
                    // ONLY if Balance is >= 0, the transaction will be added!
                    // This is verified using value stored in wdResult[1]
                    if (wdResult[1]==0){
                        transSummary = addTransactions(2, wdResult[0], transSummary, indexCount);
                        indexCount += 1;
                    }
                    break;
                case 3:
                    printTransactions(transSummary, indexCount);
                    break;
                case 4:
                    accountSummary();
                    break;
                case 5:
                    check = 1;
                    System.out.println("***********************************************************END OF PROGRAM***********************************************************");
                    break;
                default:
                    System.out.println("INVALID INPUT. PLEASE TRY AGAIN!");
                    break;
            }
        }      
    }
}