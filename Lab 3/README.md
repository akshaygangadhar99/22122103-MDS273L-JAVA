## Question
Create a java program that performs the following operation:  
The program should collect an integer array from the user.  

After the array is entered, you need to create a menu of items:
1) Find the Mean Value
2) Find the Median Value
3) Find the Mode Value
From the user-given array.  

The program should have a minimum of 3 functions apart from the main function; each of the functions implements the Mean, Median, and Mode computation by accepting the array user has entered as a parameter and returning the value as a result. From the main method, you will display the result.

### How to run the code?  
- First, set the path to the required directory using the command: cd "D:\Work\Data Science\Christ University\Academics\Semester 2\Java\22122103-MDL273L-JAVA\22122103-MDS273L-JAVA\Lab 3"
- Once the path is set, run the following commands in order:  
- javac Lab3.java  
- java Lab3  

Provided that no error is found during the compilation, the program will get executed in the terminal.  

### Constraints present in the code  
- The input values must be integers only  
- The user is required to specify the size of integer list before-hand, i.e., values cannot be entered into the array indefinitely  

### Code Explanation  
- There are a total of 6 user-defined functions in the code, namely:
1) CreateArray(int n)
2) getMean(int[] arr)
3) getMedian(int[] arr)
4) getUnique(int[] arr)
5) getMax(int[] arr)
6) getMode(int[] arr)  

#### CreateArray  
Input Argument(s): size of array (n)  
Output: user-defined integer list (arr)  

#### getMean  
Input Argument(s): integer list (arr)  
Output: mean of integer list elements  

#### getMedian  
Input Argument(s): integer list (arr)  
Output: median of integer list elements  

#### getUnique  
Input Argument(s): integer list (arr)  
Output: array of unique elements from input array (arr)  
 

#### getCount  
Input Argument(s): integer list (arr)  
Output: maximum value in the input array  
This function is utilized in the following getMode function  

#### getMode  
Input Argument(s): integer list (arr)  
Output: mode of elements in input integer array (may be single or multiple elements)  

### FlowChart  

![Lab3FlowChart](https://user-images.githubusercontent.com/118504392/219274609-c45debb2-2173-43f7-bac7-8a7fbd299b9d.jpg)  

![Lab3FlowChart2](https://user-images.githubusercontent.com/118504392/219274643-e972247b-435d-4cc2-b2f1-dd30de2ecf7b.jpg)  

![Lab3FlowChart3](https://user-images.githubusercontent.com/118504392/219274666-87f4c543-b65a-43bd-9ad4-69589fe5b4fa.jpg)  

![Lab3FlowChart4](https://user-images.githubusercontent.com/118504392/219274788-9a033df7-609a-486b-a08b-6a15dff1448e.jpg)  

![Lab3FlowChart5](https://user-images.githubusercontent.com/118504392/219274823-ba0576df-f020-4e51-8bbc-959a813a31dd.jpg)  


### Sample Output  
#### Median (length of list = even)  

******************BEGIN PROGRAM*******************  
How many integers do you want to enter? 4  
Enter integer 1:  
1  
Enter integer 2:  
2  
Enter integer 3:  
3  
Enter integer 4:  
4  
Select:  
1-Mean  
2-Median  
3-Mode  

2  
Median of given integer list is: 2.5
******************END OF PROGRAM*******************  

#### Median (length of list = odd)  

******************BEGIN PROGRAM*******************  
How many integers do you want to enter? 5  
Enter integer 1:  
5  
Enter integer 2:  
2  
Enter integer 3:  
3  
Enter integer 4:  
4  
Enter integer 5:  
1  
Select:  
1-Mean  
2-Median  
3-Mode  

2  
Median of given integer list is: 3.0  
******************END OF PROGRAM*******************  

#### Mean  
******************BEGIN PROGRAM*******************  
How many integers do you want to enter? 5  
Enter integer 1:  
5  
Enter integer 2:  
10  
Enter integer 3:  
15  
Enter integer 4:  
20  
Enter integer 5:  
25  
Select:  
1-Mean  
2-Median  
3-Mode  

1  
Mean of given integer list is: 15.0  
******************END OF PROGRAM*******************  

#### Mode  
******************BEGIN PROGRAM*******************  
How many integers do you want to enter? 7  
Enter integer 1:  
1  
Enter integer 2:  
2  
Enter integer 3:  
3  
Enter integer 4:  
4  
Enter integer 5:  
2  
Enter integer 6:  
3  
Enter integer 7:  
6  
Select:  
1-Mean  
2-Median  
3-Mode  

3  
Mode of given integer list is:  
2 3  
******************END OF PROGRAM*******************



