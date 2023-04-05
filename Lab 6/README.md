# Question  
Write a JAVA program that reads a file (text file) and finds the following details.  
    1. Vowels and their count. Eg: [a:100, e:45, I:55, ..]  
    2. Digits and their count. Eg: [0:1000, 1:10, 2:40, ...]  
    3. Top Five repeated words and their count.  
    4. Least Five repeated words and their count.  
    5. Top Five repeated characters and their count.  
    6. Least FIve repeated characters and their count.  
    
## Note:  
- Use the file attached.  
- Use functions to implement the six functions asked.  
- Pass the file content to the functions and return the values accordingly.  
- No Global variables are allowed to be used.  

## Additional Task [`htmlFile.txt`]:  
You have been given an HTML file; from the HTML File, identify the Top categories, display it to the user, and write the content to the file.  

# Code Explanation (Primary Task)    
## User-defined methods  
1. readFile()  
    - Reads the "text.txt" file and returns the content in the form of a string.   
    - No arguments  
2. countVowels()  
    - Calculates the total occurrences of each vowel and returns this in the form of an integer array.  
    - Argument(s):
        - contentString: A string containing thetext.txt file content  
3. countDigits()  
    - Calculates the total occurrences of each digit and returns this in the form of an integer array.  
    - Argument(s):
        - contentString: A string containing the text.txt file content  
4. removeChar()  
    - This method removes unwanted characters such as ,.() from the string and returns the output in the form of a String array.  
    - Argument(s):
        - oldStringArr[]: A string array  
5. checkUniqueness()  
    - This method checks for whether the given word is unique or not in a given array and returns a boolean output.  
    - Argument(s):  
        - wordToCheck: The word which needs to be checked for uniqueness in the string array  
        = wordArray: String array containing list of words  
        - index: The index location till which uniqueness needs to be checked  
6. getUniqueWords():  
    - This method returns a string array containing a list of all unique words in the text string.  
    - Argument(s):  
        - contentString: A string containing the txt file content  
7. getCount(String[] uniqueWords, String contentString, int selection):  
    - This method calculates the count of each unique word/character based on the selection criteria in the given string and returns this count in the form of an integer array.  
    - Argument(s):  
        - uniqueWords: A string array containing list of unique words/characters  
        - contentString: A string containing the text.txt file content  
        - selection: If selection is 1, then the method calculates count of words, else, it calculates count of characters  
8. getMaxMin():  
    - Returns the index location of largest/smallest occurring value in a given integer array.  
    - Argument(s):  
        - countArr: An integer array containing count of unique words/characters  
        - choice: If choice is 1, then calculates "maximum", else, "minimum"  
9. removeInt():  
    - Removes the row pertaining to a specified index location and returns updated integer array  
    - Argument(s):  
        - countArr: An integer array contaning count of unique words/characters  
        - loc: Index location that needs to be removed from the array  
10. removeString():  
    - Removes the row pertaining to a specified index location and returns updated string array  
    - Argument(s):  
        - uniqueArr: A string array contaning list of unique words/characters  
        - loc: Index location that needs to be removed from the array  
11. getTopBottomFive():  
    - Returns a 2D string array containing list of top/bottom five repeated words/characters and their count based on user-specified choice  
    - Argument(s):  
        - uniqueWords: A string array containing list of unique words/characters  
        - uniqueCount: An integer array containing count of the unique words/characters   
        - choice: If choice is 1, then returns details of top 5, else, returns details of bottom 5  
12. getUniqueChar():  
    - Returns a string array containing list of unique characters in a given string  
    - Argument(s):  
        - contentString: A string containing the text.txt file content  
13. displayResults():  
    - Displays the code output in neatly formatted manner using the custom-defined package "myFunctions"  

## Flowchart  
![Lab6_FlowChart drawio](https://user-images.githubusercontent.com/118504392/230112470-02fe1be5-d19d-443e-b4be-b747cfe8dcdd.png)

## Output  
![image](https://user-images.githubusercontent.com/118504392/230107013-431f63b1-72e2-4236-9be1-7d5b684d8d9b.png)  
![image](https://user-images.githubusercontent.com/118504392/230108050-a8ccbeab-75d4-44bd-9402-6d32a3787ccc.png)



# Code Explanation (Optional Task)  
## User-defined methods  
1. readFile():  
    - This method simply reads the file content of the html.txt file and returns this in the form of a string.  
    - It is important to note that this method uses the BufferedReader class in conjunction with the StringBuilder method to generate the required string from the html.txt file, instead of using the usual File class in conjunction with the Scanner.NextLine() method.  
    - This is inherently because of the large size of the html.txt file. In the first case, wherein a File object is utilized in conjuction with a Scanner object to read and concatenate the file content in a line-wise manner, a new string is created each time to concatenate two strings, since strings are deemed as immutable in Java.  
    - This can lead to issues in performance in cases where a large number of strings need to be concatenated, which is the present sscenario. This in turn, requires a lot of memory allocation and dealllocation.  
    - In large files, such as our html.txt file, this can also lead to some parts of the file being omitted, which was precisely the case while using this technique.  
    - Therefore, to bypass this issue, the "StringBuilder" object was used in conjunction with teh "BufferedReader" object to read and store the file content in the form of a string.  
    - The "StringBuilder" object is capable of storing the line-wise string data in a mutable buffer, which bypasses the need to create a new string object each time, thereby making this method of reading and storing the file data much more efficient.  
2. getPartialString():  
    - In this method, the Java in-built methods, namely, indexOf() and substring(), have been utilized to identify the section of the HTML file that contains the information pertaining to the "Top Categories" section.  
    - The information is stored and returned in the form of a string array.  
3. displayResults():  
    - Displays the code output in neatly formatted manner using the custom-defined package "myFunctions"  

## Output  
![image](https://user-images.githubusercontent.com/118504392/230107294-83e99b34-1628-4640-8ba1-e8a40ccaa4af.png)

