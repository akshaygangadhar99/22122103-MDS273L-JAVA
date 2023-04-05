import java.io.*;
import myFunctions.*;
public class Lab6ExtraTask{
    
    static String readFile(){
        // This method simply reads the file content of the html.txt file and returns this in the form of a string  
        String filePath = "htmlFile.txt";
        StringBuilder buildString = new StringBuilder();
        File file = new File(filePath);
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine())!=null){
                buildString.append(line);            
            }
            br.close();
        } catch(Exception ex){
            //
        }        
        return buildString.toString();
    }

    static String[] getPartialString(String htmlString){
        // First we shall extract the entire HTML data that is contained within the "Top Categories" Section
        String startKeyWord = "Top Categories";
        String endKeyWord = "/ul";
        int startIndex = htmlString.indexOf(startKeyWord);
        int endIndex = htmlString.indexOf(endKeyWord, startIndex + startKeyWord.length());
        String mainSubString = htmlString.substring(startIndex,endIndex);

        /*
         * There are a total of 20 "Top Categories" that need to be extracted.
         * In HTML, the ampersand character "&" is displayed using its entity reference "&amp;"
         * This will be duly replaced in our output to show the actual ampersand "&" character.
         */
        
        int firstKeyCheck = 1;
        String[] topCtg = new String[20];
        for(int i=0; i<20; i++){
            if(firstKeyCheck==1){
                startKeyWord = "/\">";
                endKeyWord = "</a></li>";
                startIndex = mainSubString.indexOf(startKeyWord);
                endIndex = mainSubString.indexOf(endKeyWord, startIndex + startKeyWord.length());
                topCtg[i] = mainSubString.substring(startIndex+startKeyWord.length(), endIndex).replace("&amp;","&");
                firstKeyCheck = 0;
                continue;
            }
            startIndex = mainSubString.indexOf(startKeyWord, endIndex);
            endIndex = mainSubString.indexOf(endKeyWord, startIndex + startKeyWord.length());
            topCtg[i] = mainSubString.substring(startIndex + startKeyWord.length(), endIndex).replace("&amp;","&");
        }

        return topCtg;

    }

    static void displayResults(String[] topCtg){
        align myObj = new align("-",42,"-");
        align headerObj = new align("TOP CATEGORIES",40);

        System.out.println(myObj.center());        
        System.out.println("|" + headerObj.center() + "|");
        System.out.println(myObj.center());

        for(int i=0; i<topCtg.length; i++){
            align myCtg = new align(topCtg[i],40);
            System.out.println("|"+myCtg.center()+"|");
        }

        System.out.println(myObj.center());

    }
    

    public static void main(String[] args) {
        String htmlString = readFile();
        String[] topCtg = getPartialString(htmlString);
        displayResults(topCtg);
    }


}