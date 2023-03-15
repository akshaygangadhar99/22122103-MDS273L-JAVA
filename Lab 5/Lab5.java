import java.util.*;
import java.io.*;
import myFunctions.*;

class Student{
    // Declare the required variables
    static String regNo;
    static String name;
    static String email;
    static String phoneNo;
    static String dep;

    Student(){
        /* CONSTRUCTOR
         * (1) Initializes the initial values of the variables on creation of class object
         * (2) Stores student details into a file with the filename as - studentName - immediately
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Registration No.: ");
        regNo = sc.nextLine();
        System.out.println("\nEnter student name: ");
        name = sc.nextLine();
        System.out.println("\nEnter Email-ID: ");
        email = sc.nextLine();
        System.out.println("\nEnter Phone No.: ");
        phoneNo = sc.nextLine();
        System.out.println("\nEnter Department: ");
        dep = sc.nextLine();
        
        String[] stdData = getDetails();
        String fileContent = createFileContent(stdData);
        writeToFile(fileContent);
    }

    String[] getDetails(){
        // This function stores the student details in an array and returns the resultant array
        String[] details = {regNo,name,email,phoneNo,dep};
        return details;
    }

    void printDetails(){
        // This function prints the details of the specific object containing the student details
        String[] details = getDetails();
        String[] headers = {"Registration No.","Name","Email-ID","Phone No.","Department"};
        for(int i=0; i<details.length; i++){
            System.out.println(headers[i]+": "+details[i]);
        }
    }

    /*
     * EXTENSION: Save the details of each student in a file, with his/her name with the help of a method in student class, when the Student object is getting created
     */


    static String createFileContent(String[] newStdData){
        // This method formats the content to be stored into the file in a neat manner 
        String[] headers = {"Sr. No.", "Registration No.", "Name","Email-ID","Phone No.","Department"};
        String fileContent = "";
        align designObj = new align("-",53,"-");
        fileContent += designObj.center() +"\n";
        align designHeader = new align("STUDENT DETAILS",51);
        fileContent += "|" + designHeader.center() + "|" + "\n";
        fileContent += designObj.center() + "\n";
        for(int i=0; i<5; i++){
            String text = newStdData[i];
            align headerObj = new align(headers[i+1],20);
            align textObj = new align(text,25);
            fileContent += "| " + headerObj.ljust() + ":    " + textObj.ljust() + "|" + "\n";
        }
        fileContent += designObj.center();

        return fileContent;
    }

    static void writeToFile(String fileContent){
        // This method stored the formatted file content into a .txt file with filename as - studentName
        String fileName = name + ".txt";
        try{
            File file = new File(fileName);
            if(file.createNewFile()){
                FileWriter wr = new FileWriter(file,true);
                wr.write(fileContent);
                wr.close();
            }
        } catch (Exception ex) {
            // EMPTY
        }
    }       

}

public class Lab5 {
    /*  Declaring two global variables that are utilized throughout the program - for convenience 
    (1) allStdData: 2D array containing details pertaining to all the students
    (2) indexCount: last index value of entered student details in allStdData array, i.e., total number of students 
    */
    static int indexCount = 0;
    static String[][] allStdData = new String[100][5];

    static void storeDetails(String newStdData[]){
        // Stores new student data into the allStdData array
        for(int i=0; i<newStdData.length; i++){
            allStdData[indexCount][i] = newStdData[i];
        }
    }

    static void displayDetails(){
        /* Displays the details of all students contained in the allStdData array in a neat and formatted manner
         * A custom package - myFunctions - is utilized for the formatting
         * myFunctions - contains methods such as center, ljust, rjust - within the align class, that are similar to their python counterparts
         */

        String ch = "=";
        // 30(6) + 2(6) = 192
        align obj1 = new align(ch,192,"=");
        System.out.print(obj1.center());
        System.out.println("");
        String[] headers = {"Sr. No.", "Registration No.", "Name","Email-ID","Phone No.","Department"};
        for(String head : headers){
            align obj2 = new align(head,30);
            System.out.print("|"+obj2.center()+"|");
        }
        System.out.println("");
        System.out.print(obj1.center());
        System.out.println("");

        for(int i=0;i<indexCount;i++){
            for(int j=0;j<6;j++){
                if(j==0){
                    align obj3 = new align(Integer.toString(i+1),30);
                    System.out.print("|"+obj3.center()+"|");
                }
                else{
                    align obj3 = new align(allStdData[i][j-1],30);
                    System.out.print("|"+obj3.center()+"|");
                }
                
            }
            System.out.println("");
        }
        System.out.print(obj1.center());
    }

    static void addStudentData(){
        // Collects and adds new student information into the allStdData array
        String[] tempDet = new String[5];
        Student newStd = new Student();
        tempDet = newStd.getDetails();
        storeDetails(tempDet);
    }

    static int getStdLoc(String regNo, String name){
        // Gets the row index location of student in the allStdData array
        for(int i=0; i<indexCount; i++){
            // use .toLowerCase() and str1.equals(str2) to compare for equality between 2 strings
            if(((allStdData[i][0].toLowerCase()).equals(regNo.toLowerCase())) && ((allStdData[i][1].toLowerCase()).equals(name.toLowerCase()))){
                return i;
            }
        }
        return 999; // default value if student is not found
    }

    static void dispStdDet(int indexLoc){
        /*
         * Displays specific student details based on search
         * The output is neatly formatted using the methods present within the myFunctions custom package
         */

        String[] headers = {"Sr. No.", "Registration No.", "Name","Email-ID","Phone No.","Department"};
        if (indexLoc==999){
            String errorMsg = "STUDENT NOT FOUND";
            align tempObj = new align(errorMsg,192,"*");
            System.out.println(tempObj.center());
        }
        else{
            System.out.println("");
            align designObj = new align("-",53,"-");
            System.out.println(designObj.center());
            align designHeader = new align("STUDENT DETAILS",51);
            System.out.println("|"+designHeader.center()+"|");
            System.out.println(designObj.center());

            for(int i=0; i<5;i++){
                String text = allStdData[indexLoc][i];
                align headerObj = new align(headers[i+1],20);
                align textObj = new align(text,25);
                System.out.println("| "+headerObj.ljust()+":    "+textObj.ljust()+"|");
            }

            System.out.println(designObj.center());
        }

    }

    static void searchStd(){
        /* 
        This function combines the above 2 functions:
        getStdLoc() & dispStdDet() 
        and prints the appropriate message on the screen
        */ 
    
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Registration No.: ");
        String regNoSearch = sc.nextLine();
        System.out.println("Enter Name: ");
        String nameSearch = sc.nextLine();
        int indexLoc = getStdLoc(regNoSearch, nameSearch);
        dispStdDet(indexLoc);
    }

    static int showMenu(){
        // Displays menu with options and return the user choice for the same
        Scanner sc = new Scanner(System.in);
        System.out.println("\nSelect choice: \n1-Add new student \n2-Search for student \n3-Display all student details \n4-Exit");
        int choice = Integer.parseInt(sc.nextLine());
        if(choice>4){
            choice = 0;
        }
        return choice;        
    }

    static int runUserChoice(int choice){
        /*
         * Based on user choice, this function performs the appropriate task
         */
        int check = 0;
        switch(choice){
            case 1:
                addStudentData();   
                indexCount += 1;
                if(indexCount==100){
                    check = 1;
                }
                break;
            case 2:
                // Search for student details based on Name and Reg. No.
                searchStd();
                break;
            case 3:
                // Display all Student Details
                displayDetails();
                break;
            case 4:
                check = 1;
                break;
            default:
                String errorMsg = "INVALID INPUT. PLEASE TRY AGAIN";
                align tempObj = new align(errorMsg, 125, "*");
                System.out.println(tempObj.center());
                break;
        }
        return check;
    }

    static void dispTerminalMessage(int x){
        // This function simply displays a "START" and "END" message on program initialization and termination respectively
        if(x==0){
            String message = "BEGIN PROGRAM";
            align object = new align(message, 192, "*");
            System.out.println(object.center());
        } else{
            String message = "END PROGRAM";
            align object = new align(message, 192, "*");
            System.out.println(object.center()); 
        }
    }

    public static void main(String[] args) {
        String[] tempDet = new String[5];
        int check = 0;
        int firstStdCheck = 1;
        while(check==0){
            // On program initialiation, the user is automatically asked to enter details of student #1
            if(firstStdCheck==1){
                dispTerminalMessage(0);
                Student newStd = new Student();
                tempDet = newStd.getDetails();
                storeDetails(tempDet);
                indexCount += 1; 
                firstStdCheck = 0;
            } else{
                int choice = showMenu();
                check = runUserChoice(choice);
            }
        }
        dispTerminalMessage(1);
    }
}