## AIM 
1) To take user-defined inputs including - Name, Age, State, Gender - and to display the same with some additional constraints.
2) To take gender input as (m/f) to to read the output as MALE/FEMALE correspondingly.
3) To display region of the individual as (North/South/East/West) based on value of state input.

## How to run the program?
1) Go to the directory containing the code: cd '.\D:\Work\Data Science\Christ University\Academics\Semester 2\Java\22122103-MDL273L-JAVA\22122103-MDS273L-JAVA\Lab 1\' 
2) Compile the program: javac Lab1.java
3) Run the program: java Lab1

## Output
Please enter your details: 
Name: 
Akshay
Age: 
23
Gender (m/f): 
m
Which state are you from?
Kerala
PERSONAL DETAILS
NAME: Akshay
AGE: 23 years
GENDER: MALE
Akshay is from the Southern states of India.

## Code Explanation
All inputs have been taken using the Scanner method present in the util class

Name - String
Age - int
State - String
Gender - char

To display gender as MALE or FEMALE, if-else condition has been used.
To display region based on state, switch statement has been used.