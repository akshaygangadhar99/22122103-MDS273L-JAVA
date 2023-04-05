import java.util.*;
import java.io.*;
import myFunctions.*;

public class Lab6 {

    static String readFile(){
        /*
         * Reads the text.txt file and returns it in the form of a string
         */

        String textFilePath = "text.txt";
        String fileText = "";
        try{
            File file = new File(textFilePath);
            Scanner read = new Scanner(file);
            
            while (read.hasNextLine()){
                fileText += read.nextLine();
            }

            read.close();
        } catch (Exception ex){
            //
        }

        return fileText;     
        
    }    

    static int[] countVowels(String contentString){
        int len = contentString.length();
        int[] count = {0,0,0,0,0};

        /*
         * count[] stores the vowel count based on index as follows:
         * count[0]: "a"
         * count[1]: "e"
         * count[2]: "i"
         * count[3]: "o"
         * count[4]: "u"
         */

        for(int i =0; i<len; i++){
            char c = Character.toLowerCase(contentString.charAt(i));

            switch (c){
                case 'a':
                    count[0] += 1;
                    break;
                case 'e':
                    count[1] += 1;
                    break;
                case 'i':
                    count[2] += 1;
                    break;
                case 'o':
                    count[3] += 1;
                    break;
                case 'u':
                    count[4] += 1;
                    break;
                default:
                    //
                    break;
            }
        }

        return count;
        
    }

    static int[] countDigits(String contentString){
        int[] count = {0,0,0,0,0,0,0,0,0,0};

        /*
         * count[] contains the digit count based on index.
         * For example: count[0] gives the total no. of zeros in the text file
         */

        int len = contentString.length();
        for(int i=0; i<len; i++){
            char c = contentString.charAt(i);
            if(Character.isDigit(c)){
                switch (c){
                    case '0':
                        count[0] += 1;
                        break;
                    case '1':
                        count[1] += 1;
                        break;
                    case '2':
                        count[2] += 1;
                        break;
                    case '3':
                        count[3] += 1;
                        break;
                    case '4':
                        count[4] += 1;
                        break;
                    case '5':
                        count[5] += 1;
                        break;
                    case '6':
                        count[6] += 1;
                        break;
                    case '7':
                        count[7] += 1;
                        break;
                    case '8':
                        count[8] += 1;
                        break;
                    case '9':
                        count[9] += 1;
                        break;
                    default:
                        //
                        break;                   

                }
            }
        }

        return count;
    }

    static String[] removeChar(String[] oldStringArr){
        /*
         * This method removes unwanted characters such as ,.() from the string
         */

        int len = oldStringArr.length;
        String[] newStringArr = new String[len];
        String[] charList = {",","\\.","\\(","\\)"};

        for(int i=0; i<len; i++){
            String oldWord = oldStringArr[i];
            String[] temp = new String[charList.length+1];
            temp[0] = oldWord;
            int tempIndex = 1;
            for(String c: charList){
                temp[tempIndex] = temp[tempIndex-1].replaceAll(c,""); 
                tempIndex += 1;   
            }
            
            newStringArr[i] = temp[tempIndex-1];           
        }

        return newStringArr;
    }

    static Boolean checkUniqueness(String wordToCheck, String[] wordArray, int index){
        /*
         * This method checks for whether the given word is unique or not in the wordArray
         */

        String word = wordToCheck.toLowerCase();
        for(int i=0; i<index; i++){
            String wordToCompare = wordArray[i];
            if(word.equals(wordToCompare.toLowerCase())){
                return false;
            }
        }
        return true;
    }

    static String[] getUniqueWords(String contentString){
        /*
         * This method returns a string array containing a list of all unique words in the text string
         */

        String[] allWords = contentString.split("\\s"); // splits the content string based on space character (no. of spaces >= 1)
        int index = 0;
        String[] tempString = new String[allWords.length];
        // tempString will store intial list of unique words


        for(int i=0; i<allWords.length; i++){
            if(i==0){
                // First word is stored automatically in the tempString array
                tempString[index] = allWords[i];
                index += 1;
            } else{
                // Each word in the allWords array is to be checked for uniqueness within the tempString array
                // If unique, store in tempString

                if(checkUniqueness(allWords[i], tempString, index)){
                    tempString[index] = allWords[i];
                    index += 1;
                }
            }            
        }        

        String[] uniqueWords = new String[index];
        for(int i=0; i<index; i++){
            uniqueWords[i] = tempString[i];
        }

        uniqueWords = removeChar(uniqueWords);

        return uniqueWords;
        
    }  
    
    static int[] getCount(String[] uniqueWords, String contentString, int selection){
        /* 
         * Returns count of each unique word in the contentString
         * If selection = 1, getCount for words
         * Else, getCount for characters
         */

        String[] allWords;
        if(selection==1){
            allWords = contentString.split("\\s");
            allWords = removeChar(allWords);
        }
        else{
            allWords = contentString.split(""); // split each individual character
        }

        int[] wordCount = new int[uniqueWords.length];
        int index = 0;

        for(String word: uniqueWords){
            word = word.toLowerCase();
            int count = 0;
            for(String wordToCheck: allWords){
                if(word.equals(wordToCheck.toLowerCase())){
                    count += 1;
                }
            }
            wordCount[index] = count;
            index += 1;
        }

        return wordCount;

    }

    static int getMaxMin(int[] countArr, int choice){
        // This method returns the position of the max/min count value in the array based on user choice

        if (choice==1){
            // Find max count
            int maxLoc = 0;
            for(int i=1; i<countArr.length; i++){
                if(countArr[i]>countArr[maxLoc]){
                    maxLoc = i;
                }
            }
            return maxLoc;
        } else{
            // Find min count
            int minLoc = 0;
            for(int i=1; i<countArr.length; i++){
                if(countArr[i]<countArr[minLoc]){
                    minLoc = i;
                }
            }
            return minLoc;
        }
        

    }

    static int[] removeInt(int[] countArr, int loc){
        // Removes the row pertaining to a specified index location and returns updated array
        int[] newCountArr = new int[countArr.length-1];
        int index = 0;
        for(int i=0; i<countArr.length; i++){
            if(i==loc){
                continue;
            }
            newCountArr[index] = countArr[i];
            index += 1;
        }
        return newCountArr;
    }

    static String[] removeString(String[] uniqueArr, int loc){
        // Removes the row pertaining to a specified index location and returns updated array
        String[] newUniqueArr = new String[uniqueArr.length-1];
        int index = 0;
        for(int i=0; i<uniqueArr.length; i++){
            if(i==loc){
                continue;
            }
            newUniqueArr[index] = uniqueArr[i];
            index += 1;
        }
        return newUniqueArr;
    }

    

    static String[][] getTopBottomFive(String[] uniqueWords, int[] uniqueCount, int choice){
        // Returns a 1D array with top/bottom 5 words and their count

        if (choice==1){
            // Get top 5
            String[][] topFive = new String[5][2];
            for(int i=0; i<5; i++){
                int maxLoc = getMaxMin(uniqueCount,1);
                topFive[i][0] = uniqueWords[maxLoc];
                topFive[i][1] = Integer.toString(uniqueCount[maxLoc]);

                // Remove rows corresponding to max/min count values

                uniqueWords = removeString(uniqueWords, maxLoc);
                uniqueCount = removeInt(uniqueCount, maxLoc);
            }
            return topFive;
        } else{
            // Get bottom 5
            String[][] bottomFive = new String[5][2];
            for(int i=0; i<5; i++){
                int minLoc = getMaxMin(uniqueCount,2);
                bottomFive[i][0] = uniqueWords[minLoc];
                bottomFive[i][1] = Integer.toString(uniqueCount[minLoc]);

                // Remove rows corresponding to max/min count values

                uniqueWords = removeString(uniqueWords, minLoc);
                uniqueCount = removeInt(uniqueCount, minLoc);
            }
            return bottomFive;

        }
        
    }

    static String[] getUniqueChar(String contentString){
        // This method returns list of unique characters (excluding spaces) present in the contentString data

        String[] charArr = new String[contentString.length()];
        int index = 0;
        for (int i=0; i<contentString.length(); i++){
            String c = String.valueOf(contentString.charAt(i)).toLowerCase(); // convert to lowercase before saving the value in the array
            if(c.equals(" ")){
                // ignore spaces
                continue;
            }
            if(index==0){
                // NEED TO RESOLVE CAPITAL AND SMALL LETTERS ISSUE -> RESOLVED IN LINE 335
                charArr[index] = c;
                index += 1;
                continue;
            }
            //if(checkUniqueness(c, charArr, index))
            if(checkUniqueness(c, charArr, index)){
                charArr[index] = c;
                index += 1;
            }
        }
        String[] finalCharArr = new String[index];
        for(int i=0; i<index; i++){
            finalCharArr[i] = charArr[i];
        }
        return finalCharArr;
    }   

    static void displayResults(int[] vowelCount, int[] digitCount, String[][] topFiveWords, String[][] bottomFiveWords, String[][] topFiveChar, String[][] bottomFiveChar){
        System.out.println("");
        align splitObj = new align("-",53,"-"); 

        // TASK 1: VOWEL COUNT
        System.out.println(splitObj.center());

        String res = "";
        String[] vowels = {"a","e","i","o","u"};    
        align header1 = new align("VOWEL",25);
        align header2 = new align("COUNT",25);
        res += "|"+ header1.center() + "|" + header2.center() + "|";
        System.out.println(res);

        System.out.println(splitObj.center());          
        
        for(int i=0; i<5; i++){
            res = "";
            align vowAlign = new align(vowels[i],24);
            align countAlign = new align(Integer.toString(vowelCount[i]), 25);
            res += "| " + vowAlign.center() + "|" + countAlign.center() + "|";
            System.out.println(res);
        }

        System.out.println(splitObj.center());

        // TASK 2: DIGIT COUNT
        System.out.println("");
        System.out.println(splitObj.center());

        res = "";
        align header3 = new align("DIGIT", 25);
        res += "|"+ header3.center() + "|" + header2.center() + "|";
        System.out.println(res);
        System.out.println(splitObj.center());

        for(int i=0; i<10; i++){
            res = "";
            align digAlign = new align(Integer.toString(i), 25);
            align digCountAlign = new align(Integer.toString(digitCount[i]), 25);
            res += "|" + digAlign.center() + "|" + digCountAlign.center() + "|";
            System.out.println(res);
        }
        System.out.println(splitObj.center());

        // TASK 3: TOP 5 REPEATED WORDS + COUNT
        System.out.println("");
        
        System.out.println(splitObj.center());
        align header4 = new align("TOP 5 REPEATED WORDS",51);
        System.out.println("|"+header4.center()+"|");

        System.out.println(splitObj.center());
        res = "";
        align header5 = new align("WORD",25);
        res += "|" + header5.center() + "|" + header2.center() + "|";
        System.out.println(res);
        System.out.println(splitObj.center());

        for(int i=0; i<5; i++){
            res = "";
            align topWord = new align(topFiveWords[i][0],25);
            align topWordCount = new align(topFiveWords[i][1], 25);
            res += "|" + topWord.center() + "|" + topWordCount.center() + "|";
            System.out.println(res);
        }

        System.out.println(splitObj.center());

        // TASK 4: BOTTOM 5 REPEATED WORDS + COUNT
        System.out.println("");
        
        System.out.println(splitObj.center());
        align header6 = new align("BOTTOM 5 REPEATED WORDS",51);
        System.out.println("|"+header6.center()+"|");

        System.out.println(splitObj.center());
        res = "";
        res += "|" + header5.center() + "|" + header2.center() + "|";
        System.out.println(res);
        System.out.println(splitObj.center());

        for(int i=0; i<5; i++){
            res = "";
            align botWord = new align(bottomFiveWords[i][0],25);
            align botWordCount = new align(bottomFiveWords[i][1], 25);
            res += "|" + botWord.center() + "|" + botWordCount.center() + "|";
            System.out.println(res);
        }

        System.out.println(splitObj.center());

        // TASK 5: TOP 5 REPEATED CHARACTERS + COUNT
        System.out.println("");
        
        System.out.println(splitObj.center());
        align header7 = new align("TOP 5 REPEATED CHARACTERS",51);
        System.out.println("|"+header7.center()+"|");

        System.out.println(splitObj.center());
        res = "";
        align header8 = new align("CHARACTER",25);
        res += "|" + header8.center() + "|" + header2.center() + "|";
        System.out.println(res);
        System.out.println(splitObj.center());

        for(int i=0; i<5; i++){
            res = "";
            align topChar = new align(topFiveChar[i][0],25);
            align topCharCount= new align(topFiveChar[i][1], 25);
            res += "|" + topChar.center() + "|" + topCharCount.center() + "|";
            System.out.println(res);
        }

        System.out.println(splitObj.center());

        // TASK 5: BOTTOM 5 REPEATED CHARACTERS + COUNT
        System.out.println("");
        
        System.out.println(splitObj.center());
        align header9 = new align("BOTTOM 5 REPEATED CHARACTERS",51);
        System.out.println("|"+header9.center()+"|");

        System.out.println(splitObj.center());
        res = "";
        //align header8 = new align("CHARACTER",25);
        res += "|" + header8.center() + "|" + header2.center() + "|";
        System.out.println(res);
        System.out.println(splitObj.center());

        for(int i=0; i<5; i++){
            res = "";
            align botChar = new align(bottomFiveChar[i][0],25);
            align botCharCount= new align(bottomFiveChar[i][1], 25);
            res += "|" + botChar.center() + "|" + botCharCount.center() + "|";
            System.out.println(res);
        }

        System.out.println(splitObj.center());

    }

    public static void main(String[] args) {
        // Read file
        String fileText = readFile();

        // Get vowel count
        int[] vowelCount = countVowels(fileText);

        // Get digit count
        int[] digitCount = countDigits(fileText);

        // Get list of unique words
        String[] uniqueWords = getUniqueWords(fileText);
        System.out.println("\nThere are "+uniqueWords.length+" unique words.");

        // Get count of unique words
        int[] uniqueCount = getCount(uniqueWords, fileText,1);

        // Get list of top and bottom 5 repeated words
        String[][] myTopFiveWords = getTopBottomFive(uniqueWords, uniqueCount,1);
        String[][] myBottomFiveWords = getTopBottomFive(uniqueWords, uniqueCount, 2);

        // Get list of unique characters
        String[] uniCharArr = getUniqueChar(fileText);
        int[] uniCharCount = getCount(uniCharArr, fileText,2);

        // Get list of top and bottom five repeated characters
        String[][] myTopFiveChar = getTopBottomFive(uniCharArr, uniCharCount, 1);
        String[][] myBottomFiveChar = getTopBottomFive(uniCharArr, uniCharCount, 2);

        // Display results
        displayResults(vowelCount, digitCount, myTopFiveWords, myBottomFiveWords, myTopFiveChar, myBottomFiveChar);

    }
    
}
