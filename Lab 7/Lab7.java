import java.io.*;
import java.util.*;
import myFunctions.*;

public class Lab7{
    /*
     * => Given the famous iris dataset, find the 5-point summary [Mean, Median, Mode, Min, Max] 
     * for the attributes: SepalLengthCm, SepalWidthCm, PetalLengthCm, PetalWidthCm.
     * 
     * => Once the overall summary statistics have been calculated, 
     * identify the summary statistics for each Species of iris flower [Iris-setosa, Iris-versicolor, Iris-virginica].
     * 
     * => Present your results in the appropriate format and write the results in a file.
     */

    static String[][] readFile(){
        String[][] irisInit = new String[151][6];
        try{
            File file = new File("Iris.csv");
            Scanner read = new Scanner(file);
            int count = 0;
            while(read.hasNextLine()){
                irisInit[count] = read.nextLine().split(",");
                count += 1;
            }
            read.close();
        } catch (Exception ex){
            //
        }

        String[][] iris = new String[150][5];
        int count = 0;
        for(int i=0; i<151; i++){
            // Exclude row 0 since it only contains headers
            if(i!=0){
                for(int j=1; j<6; j++){
                    // Only capture columns 1-5, since column 0 is ID
                    iris[count][j-1] = irisInit[i][j];                    
                }
                count += 1;
            }
            
        }

        return iris;
    }

    static float getMean(String[] numArr){
        // Returns the mean of a number array containing floating point values in String format

        float sum = 0.0f;
        for(int i=0; i<numArr.length; i++){
            sum += Float.parseFloat(numArr[i]);
        }

        return sum/numArr.length;

    }

    static float getMedian(String[] arr){
        // Returns the median of a string array containing floating point numbers

        float[] newArr = new float[arr.length];
        for(int i=0; i<arr.length; i++){
            newArr[i] = Float.parseFloat(arr[i]);
        }

        Arrays.sort(newArr);

        if(newArr.length%2 != 0){
            // If total numbers is odd:
            int medLoc = (newArr.length-1)/2;
            return newArr[medLoc];
        } else{
            // If total numbers is even:
            int medLoc1 = (newArr.length/2)-1;
            int medLoc2 = (newArr.length/2);
            return (newArr[medLoc1] + newArr[medLoc2])/2;
        }
    }

    static Boolean checkUniqueness(String element, String[] eltArr, int index){
        // Checks for uniqueness of element in eltArr

        for(int i=0; i<index; i++){
            if(eltArr[i].equals(element)){
                return false;
            }
        }
        return true;
    }

    static String[] getUnique(String[] arr){
        // Returns array containing unique elements of the array "arr"

        String[] initArr = new String[arr.length];
        int index = 0;
        for(int i=0; i<arr.length; i++){
            if(i==0){
                initArr[index] = arr[i];
                index += 1;
            } else{
                if(checkUniqueness(arr[i],initArr, index)){
                    initArr[index] = arr[i];
                    index += 1;
                }
            }
        }

        String[] uniArr = new String[index];
        for(int i=0; i<index; i++){
            uniArr[i] = initArr[i];
        }

        return uniArr;
    }

    static int[] getCount(String[] uniArr, String[] arr){
        // Returns count of each unique element in the arr

        int[] countArr = new int[uniArr.length];
        for(int i=0; i<countArr.length; i++){
            int count = 0;
            String elt = uniArr[i];
            for(int j=0; j<arr.length; j++){
                if(elt.equals(arr[i])){
                    count += 1;
                }
            }
            countArr[i] = count;
        }

        return countArr;
    }

    static float getMode(String[] arr){
        // Returns the mode of an array

        // Get array of unique elements
        String[] uniqueArr = getUnique(arr);

        // Get count of each unique element
        int[] countArr = getCount(uniqueArr, arr);

        // Get index location of most-occurring element
        int maxLoc = 0;
        for(int i=1; i<countArr.length; i++){
            if(countArr[i]>countArr[maxLoc]){
                maxLoc = i;
            }
        }

        return Float.parseFloat(uniqueArr[maxLoc]);
    }

    static float getMinMax(String[] arr, int choice){
        // Returns the max/min value of elements in arr based on choice

        float[] newArr = new float[arr.length];
        for(int i=0 ;i<arr.length; i++){
            newArr[i] = Float.parseFloat(arr[i]);
        }

        if(choice==1){
            // Get max
            float max = newArr[0];
            for(int i=1; i<newArr.length; i++){
                if(newArr[i]>max){
                    max = newArr[i];
                }
            }
            return max;
        } else{
            float min = newArr[0];
            for(int i=1; i<newArr.length; i++){
                if(newArr[i]<min){
                    min = newArr[i];
                }
            }
            return min;
        }
    }

    static float getVal(int choice, String[] arr){
        // Returns the required statistic value based on user choice for a given array

        if(choice==0){
            // Mean
            return getMean(arr);
        } else if(choice==1){
            // Median
            return getMedian(arr);
        } else if(choice==2){
            // Mode
            return getMode(arr);
        } else if(choice==3){
            // Min
            return getMinMax(arr, 2);
        } else{
            // Max
            return getMinMax(arr,1);
        }
    }

    static String[] getColumn(int col, String[][] arr){
        // Returns the specified column from the 2D array in the form of a 1D array

        int rows = arr.length;
        String[] res = new String[rows];
        for(int i=0; i<rows; i++){
            res[i] = arr[i][col];
        }
        return res;
    }

    static void getOverallStats(String[][] iris){
        // Tabulate and display overall summary statistics in a neat and formatted manner and stores the same in a .txt file

        String overallResult = "";

        String[] sepLen = getColumn(0, iris);
        String[] sepWid = getColumn(1,iris);
        String[] petLen = getColumn(2,iris);
        String[] petWid = getColumn(3, iris);


        String[][] overallStats = new String[5][4];
        // Each row corresponds to a statistic (mean/median/mode/min/mix)
        // Each column corresponds to an attribute

        for(int i=0; i<5; i++){
            overallStats[i][0] = Float.toString(getVal(i,sepLen));
            overallStats[i][1] = Float.toString(getVal(i,sepWid));
            overallStats[i][2] = Float.toString(getVal(i,petLen));
            overallStats[i][3] = Float.toString(getVal(i,petWid));            
        }

        align overallAlign = new align("OVERALL SUMMARY",81,"*");
        System.out.println("\n"+overallAlign.center());
        overallResult += "\n" + overallAlign.center();

        align mySeparator = new align("-",81,"-");
        System.out.println(mySeparator.center());
        overallResult += "\n" + mySeparator.center() + "\n";
        
        // Print the headers
        String[] headers = {"Statistic","Sepal Length", "Sepal Width","Petal Length","Petal Width"};
        String res = "|";
        for(int i=0; i<headers.length; i++){
            align myHeader = new align(headers[i],15);
            res += myHeader.center() + "|";
        }
        System.out.println(res);
        overallResult += res + "\n";
        System.out.println(mySeparator.center());
        overallResult += mySeparator.center() +"\n";

        String[] rowHeaders = {"Mean","Median","Mode","Min","Max"};

        for(int i=0; i<5; i++){
            res = "|";
            align myHeader2 = new align(rowHeaders[i],15);
            res += myHeader2.center() + "|";
            for(int j=0; j<4; j++){
                align myObj = new align(overallStats[i][j],15);
                res += myObj.center() + "|";
            }
            System.out.println(res);
            overallResult += res + "\n";
        }

        System.out.println(mySeparator.center());
        overallResult += mySeparator.center();
        
        try{
            File file = new File("OverallStatistics.txt");
            if(file.createNewFile()){
                FileWriter wr = new FileWriter(file);
                wr.write(overallResult);
                wr.close();
            } 
        } catch (Exception ex){
            //
        }
    
    }

    static String[][] getSpeciesData(String specie, String[][] iris){
        // Extracts attribute-wise information for given specie from the complete iris data set

        String[][] specieInfoInit= new String[150][4];

        int index = 0;
        for(int i=0; i<150; i++){
            if(specie.equals(iris[i][4])){
                for(int j=0; j<4; j++){
                    specieInfoInit[index][j] = iris[i][j];
                }
                index += 1;
            }
        }

        String[][] specieInfo = new String[index][4];

        for(int i=0; i<index; i++){
            for(int j=0; j<4; j++){
                specieInfo[i][j] = specieInfoInit[i][j];
            }
        }

        return specieInfo;
    }

    static void printSpecieSummary(String specie, String[][] specieData){
        // Prints and stores the summary statistics of given specie in a .txt file

        String statString = "";

        align specieName = new align(specie,81,"*");
        System.out.println("\n"+specieName.center());
        statString += specieName.center() + "\n";
        
        align mySeparator = new align("-",81,"-");
        System.out.println(mySeparator.center());
        statString += mySeparator.center() +"\n";

        // Print the headers
        String[] headers = {"Statistic","Sepal Length", "Sepal Width","Petal Length","Petal Width"};
        String res = "|";
        for(int i=0; i<headers.length; i++){
            align myHeader = new align(headers[i],15);
            res += myHeader.center() + "|";
        }
        System.out.println(res);
        statString += res + "\n";
        System.out.println(mySeparator.center());
        statString += mySeparator.center() + "\n";

        String[] sepLen = getColumn(0, specieData);
        String[] sepWid = getColumn(1,specieData);
        String[] petLen = getColumn(2,specieData);
        String[] petWid = getColumn(3, specieData);

        String[][] overallStats = new String[5][4];
        // Each row corresponds to a statistic (mean/median/mode/min/mix)
        // Each column corresponds to an attribute

        for(int i=0; i<5; i++){
            overallStats[i][0] = Float.toString(getVal(i,sepLen));
            overallStats[i][1] = Float.toString(getVal(i,sepWid));
            overallStats[i][2] = Float.toString(getVal(i,petLen));
            overallStats[i][3] = Float.toString(getVal(i,petWid));            
        }

        String[] rowHeaders = {"Mean","Median","Mode","Min","Max"};

        for(int i=0; i<5; i++){
            res = "|";
            align myHeader2 = new align(rowHeaders[i],15);
            res += myHeader2.center() + "|";
            for(int j=0; j<4; j++){
                align myObj = new align(overallStats[i][j],15);
                res += myObj.center() + "|";
            }
            System.out.println(res);
            statString += res + "\n";
        }

        System.out.println(mySeparator.center());
        statString += mySeparator.center();
        
        // Store to file
        String fileName = specie.toUpperCase() + ".txt";
        try{
            File file = new File(fileName);
            if(file.createNewFile()){
                FileWriter fw = new FileWriter(file);
                fw.write(statString);
                fw.close();
            }
        } catch (Exception ex){
            //
        }

    }

    static void getSpecieStats(String[][] iris){
        // Combines the above two methods, namely - getSpeciesData() and printSpecieSummary() - to obtain specie-wise summary statistics  
        String[] allSpecies = new String[150];
        for(int i=0; i<150; i++){
            allSpecies[i] = iris[i][4];
        }

        // Get list of unique species
        String[] uniqueSpecies = getUnique(allSpecies);

        for(int i=0; i<uniqueSpecies.length; i++){
            String[][] specieData = getSpeciesData(uniqueSpecies[i], iris);
            printSpecieSummary(uniqueSpecies[i], specieData);
        }

    }

    public static void main(String[] args) {
        String[][] iris = readFile();
        getOverallStats(iris);
        getSpecieStats(iris);
    }
}