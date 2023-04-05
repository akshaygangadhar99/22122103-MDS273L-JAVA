package myFunctions;

public class align{
    String str;
    int n;
    String ch;

    public align(){
        // Empty constructor
    }
    
    // 2 additional parameterized constructors are created to initialize values accordingly
    // If user does not specify any character, default character is assumed to be space " "

    public align(String s, int len){
        // Ensures that default character is space " " 
        str = s;
        n = len;
        ch = " ";

    }

    public align(String s, int len, String character){
        str = s;
        n = len;
        ch = character;
    }

    public String center(){
        int startInd = 0;
        int len_str = str.length();
        if ((n%2)==0){
            if (len_str%2!=0){
                // Word is of odd-length
                startInd = (n/2) - (len_str+1)/2;
            } else{
                // Word is of even-length
                startInd = (n/2) - (len_str)/2;
            }            
        } else{
            if ((len_str%2)!=0){
                // Word is of odd-length
                startInd = ((n-1)/2) - (len_str-1)/2;
            } else{
                // Word is of even-length
                startInd = ((n-1)/2) - (len_str/2) + 1;
            }
        }
        
        String res = "";
        for(int i=0; i<startInd; i++){
            res += ch;
        }  

        for(int i=0; i<len_str; i++){
            res += str.charAt(i);
        }

        int finalCount = startInd + len_str;
        while (finalCount<n){
            res += ch;
            finalCount += 1;
        }      

        return res;
    }

    public String ljust(){
        String res = "";
        for(int i=0; i<str.length(); i++){
            res += str.charAt(i);
        }
        int count = str.length();
        while (count<n){
            res += ch;
            count += 1;
        }
        return res;      
    }

    public String rjust(){
        int startInd = n - str.length();
        String res = "";
        for(int i=0; i<startInd; i++){
            res += ch;
        }
        for(int i=0; i<str.length(); i++){
            res += str.charAt(i);
        }
        return res;
    }
}

