# Lab 4  
## Write a JAVA Menu driven program that does the following:  
You can ONLY have the below variables as global variables:  
- Account Number  
- Account Holder Name  
- Account Balance  

You MUST have the below as functions:  
- To initialize the customer  
- To deposit money  
- To withdraw money  
- To print the transactions  
- To print account summary  

Your menu will have the following operations once the customer is created:  
- To deposit money  
- To withdraw money  
- To print the transactions  
- To print account summary  

## Code Explanation:  
The program contains the following functions:  
1) userAcNo(): Collect Account no. data  
2) userName(): Collect Account Holder Name data  
3) userAcBal(): Collect Account Balance data
4) initializeCust(): Call the appropriate functions to initialize customer account  
5) accountSummary(): Display account information  
6) Deposit(): Collect deposit amount and modify account balance  
7) Withdraw(): Collect Withdrawal Amount and Check for Appropriate Conditions Before Allowing Transaction  
8) initTransSummary(): This function initializes the transaction summary sheet for the user  
9) addTransactions(int type, int amt, String[][] transArr, int indexCount): This function updates the 2D array containing the user transaction summary  
10) printTransactions(String[][] transSummary, int indexCount): Update the transaction summary data in the corresponding 2D array  
### 11) centerString(String s, int n): This is essentially a recreation of the python .center() method used to center align the corresponding string within the designated space  

## Constraints:  
- The account balance, withdrawal and deposited amount must all be integer values. This is simply a matter of convenience. The data types can easily be changed to float/double format if required.  
- The centerString() function centers the argument string using space as the default character to be fill the remaining empty spots. This is also simply a matter of convenience. In future programs, this function will be modified to include user-defined characters for the centering function.  
- The program has only been written for a single user - usage. It needs to be re-run everytime a user needs to use it.  
- The program does not access any real-time database to collect initial user-information. This is why initial user-detail initialization is required.  

## Overall Program Flowchart:  
![Lab4_1](https://user-images.githubusercontent.com/118504392/220646428-4c58c1fc-2db5-4b71-a294-40e2fb9f1ba4.jpg)


## Output:  
![image](https://user-images.githubusercontent.com/118504392/220630864-71367e40-6910-4a44-9f44-6d80cd62bb6e.png)  
![image](https://user-images.githubusercontent.com/118504392/220630912-884bca5f-4add-41fb-8d14-7d4e84165c5f.png)  
![image](https://user-images.githubusercontent.com/118504392/220630949-2d1f5b1a-a6e4-430a-926f-315dbf6d59e3.png)  
![image](https://user-images.githubusercontent.com/118504392/220631075-03bd024f-f22a-4e49-96e5-6dbd89d229a5.png)



