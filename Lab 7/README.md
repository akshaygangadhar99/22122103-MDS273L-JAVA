# Question  
Given the famous iris dataset, find the 5-point summary [Mean, Median, Mode, Min, Max] for the attributes: SepalLengthCm, SepalWidthCm, PetalLengthCm, PetalWidthCm.  

Once the overall summary statistics have been calculated, identify the summary statistics for each Species of iris flower [Iris-setosa, Iris-versicolor, Iris-virginica].  

Present your results in the appropriate format and write the results in a file.  

# Code Explanation  
## User-Defined Methods  
1. readFile():  
    - Reads the Iris.csv file and returns the data in the form of a 2D String array  
    - No arguments  
2. getMean():  
    - Returns the mean of values in a string array containing elements in floating point format  
    - Argument(s):  
        - numArr: String array containing floating point elements  
3. getMedian():  
    - Returns the median values in a string array containing floating point numbers  
    - Argument(s):  
        - arr: String array containing floating point elements  
4. checkUniqueness():  
    - Checks for the uniqueness of an element in the given array and returns a boolean value  
    - Argument(s):  
        - element: String value which needs to be checked for uniqueness  
        - eltArr: String array within which the element is checked for uniqueness  
        - index: Integer value that pertains to the location till which elements are stored in the eltArr array  
5. getUnique():  
    - Returns array containing unique elements of the input argument array  
    - Argument(s):  
        - arr: String array  
6. getCount():  
    - Returns count of each unique element in the String array  
    - Argument(s):  
        - uniArr: String array containing list of unique elements  
        - arr: Original String array containing complete list of elements  
7. getMode():  
    - Returns the mode of an array  
    - Argument(s):  
        - arr: String array containing floating point elements  
8. getMinMax():  
    - Returns the max/min value of elements in arr based on choice  
    - Argument(s):  
        - arr: String array containing floating point elements  
        - choice: Integer value; If choice is 1, then returns max, else, returns min  
9. getVal():  
    - Returns the required statistic value based on user choice for a given array  
    - Argument(s):  
        - arr: String array containing floating point elements  
        - choice: Integer value  
            - If choice is 0, returns mean  
            - If choice is 1, returns median  
            - If choice is 2, returns mode  
            - If choice is 3, returns min
            - Else, returns max  
10. getColumn():  
    - Returns the specified column from the 2D array in the form of a 1D array  
    - Argument(s):  
        - arr: 2D String array containing pertaining dataset  
        - col: Integer value specifying column to be extracted  
11. getOverallStats():  
    - Tabulates and displays overall summary statistics in a neat and formatted manner and stores the same in a .txt file  
    - Argument(s):  
        - iris: 2D String array containing entire iris dataset  
12. getSpeciesData():  
    - Extracts attribute-wise information for given specie from the complete iris data set  
    - Argument(s):  
        - specie: String containing name of specie whose details need to be extracted  
        - iris: 2D String array containing entire dataset information  
13. printSpecieSummary():  
    - Prints and stores the summary statistics of given specie in a .txt file  
    - Argument(s):  
        - specie: String specifying name of specie  
        - specieData: 2D String array containing the extracted data pertaining to the given specie  
14. getSpecieStats():  
    - Combines the above two methods, namely - getSpeciesData() and printSpecieSummary() - to obtain specie-wise summary statistics  
    - Argument(s):  
        - iris: 2D String array containing entire iris dataset  

## Packages used  
1. java.io: For its file-handling capabilities  
2. java.util: For its Scanner class  
3. myFunctions: Custom-built package for its text-formatting capabilities  

# Flowchart  

# Output  

