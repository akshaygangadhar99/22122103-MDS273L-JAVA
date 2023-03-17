# Question 
Create a student class, that will store the details of the Student:  
- Reg. No.  
- Name  
- Email  
- Phone  
- Class  
- Department  

## Additional Constraints  
- The class will have a constructor to initialize the values of the Student and a method to print the Details of the Student.  
- In the main-method class, create an array of Student Class to hold maximum details of 100 Students.  

In the menu-driven program, the menu options will have:  
- Add a student  
- Adds the details of 1 student to the array of Student  
- Search for a student
    - Search for the details of a student from the array of Student  
    - (Optional) Searching can be done with Name & Register Number  
- Display all students  
    - Displays the details of all students 

### Extension (Optional):  
- Save the details of each student in a file, with his name with the help of a method in student class, when the student is getting created.

### Note: Make use of functions to implement the menu options  

--------------------------------------------------------------------------------------------------------------------------------------------------------------------

# CODE EXPLANATION  
- The program contains 2 classes:  
    - class Student  
    - class Lab5  

- class Student is required to initialize the student information as required in the lab task
- class Lab5 is the main program class encapsulating several functions that are required for execution of tasks  

## class Student  
- This class contains one constructor that initializes the variables pertaining to key student information such as: Registration no., Name, Email-ID, Phone no. and Department.  
- There are 4 additional methods, of which the functionalities of the first two are rather self-explanatory. These are:  
    - getDetails(): This stores the student information in the form of a 1-D array and returns the same  
    - printDetails(): This prints the student details in a neat manner  
- The other two methods are:  
    - createFileContent(String[] newStdData): This method creates a neat, formatted string which can be written into the corresponding file as required  
    - writeToFile(String fileContent): This method simply writes the formatted file content into a .txt file with the file name as the student name  

## class Lab5  
- There are several methods defined within this that are required for the smooth execution of the main() method  
- These methods and their core functionalities are explained below  

(1) storeDetails(String newStdData[])  
- Objective: To store the new student details into the allStdData array  
- Arguments:  
    - newStdData[]: 1D array containing student information  

(2) displayDetails()  
- Objective: To display the details pertaining to all the students in a neat and formatted manner  
- The formatting has been done using the methods present in the custom-buily myFunctions package (more on this package at a later section)
- No arguments  

(3) addStudentData()  
- Objective: Collects student details from the getDetails() method of the Student object and stores this information into the allStdData array  
- No arguments  

(4) getStdLoc(String regNo, String name)  
- Objective: To get the row index location in the allStdData 2D array of the student whose details need to be fetched  
- Arguments: There are two arguments, namely - regNo and name - which are the 2 task-specified search criteria to be utilized  

(5) dispStdDet(int indecLoc)  
- Objective: To display the details of the student, once his/her location has been found using the getStdLoc() function  
- Arguments: Only one argument, namely - indexLoc - which contains the row index location that is obtained used the getStdLoc() function  

(6) searchStd()  
- Objective: To combine the functionalities of the above two functions - getStdLoc() & dispStdDet() - which can then be utilized to obtain one single start-to-finish method for obtaining a single student's details  
- No arguments  
- An appropriate default message is displayed if the student is not present in the current database, i.e., allStdData array  

(7) showMenu()  
- Objective: To display the menu containing task-specific options and return the user-defined choice for the same  
- No arguments  

(8) runUserChoice(int choice)  
- Objective: To perform the subsequent task based on the user-specified choice - utilizing all above custom methods  
- Arguments: Single argument, namely - choice (integer ranging from 0 to 4)  

(9) dispTerminalMessage(int x)  
- Objective: To print the "Program Start" or "Program End" message based on requirement  
- Arguments:  
    - int x: prints the "Program Start" message if x is 0, and "Program End" message if x is 1  

## Packages Used  
The code uses three packages.  
- Two are in-built packages, namely - util, which is utilized for its Scanner method to read user-specified input, and io, which is utilized for its file-handling methods.  

### myFunctions  
The third package, is the myFunctions package. This is a custom-built package that, at present, contains one class - align - with the following methods:  
- center()  
- ljust()  
- rjust()  

The functionality of these methods are rather self-explanatory, as they are named after their Python counterparts, and are built for the exact same usage.  
- The center() function is used to center-justify a string for a user-defined width  
- The ljust() function is used to left-justify a string for a user-defined width  
- The rjust() function is used to right-justify a string for a user-defined width  

For all three methods, if the fill-in character is not specified by the user, then the default fill-in character is taken as space (same as the Python counterparts). This is achieved using constructor overloading. 

## Overall Program Flowchart  
![Lab5_1 drawio](https://user-images.githubusercontent.com/118504392/225942448-b4f90091-f009-4dac-b454-7a90b49793fd.png)  

## CONSTRAINTS  
- The one major constraint that the program contains is that all the user-specified values have been treated as strings, including the Registration No. and Phone No. variables. This has been done primarily to ensure that any "faulty" values entered by the user for these two variables do not throw up an error by the JDK during compiling. However, this can be modified and made more rigid using exception handling techniques. This task has been left for future work, to be done as and when required  
- Another constraint is the possible entry of repeating values. While names can possibly be repeated, Registration numbers are supposed to be unique. However, no check has been added to ensure the uniqueness of new user-specified inputs. This additional functionality can, however, be added easily and has been left for future work.  

## Sample Output  
![image](https://user-images.githubusercontent.com/118504392/225953981-251a4902-0c4e-42fb-9ceb-0d81217d10c1.png)  
![image](https://user-images.githubusercontent.com/118504392/225954062-d202175c-39c5-4ced-9284-e3084e9a93d8.png)  
![image](https://user-images.githubusercontent.com/118504392/225954106-e8d2b064-cccd-423a-ac86-70a5eec90747.png)






