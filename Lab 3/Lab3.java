import java.util.*;

public class Lab3{
    static int[] CreateArray(int n){
        // This function generates and returns a user-defined array of size "n"

        Scanner sc = new Scanner(System.in);
        int[] newArr = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter integer "+(i+1)+": ");
            newArr[i] = Integer.parseInt(sc.nextLine());
        }
        return newArr;
    }
    
    static float getMean(int[] arr){
        // This function returns the mean of a given integer list

        float temp = 0;
        for (int item : arr) {
            temp += item;         
        }
        return (temp/arr.length);
    }

    static float getMedian(int[] arr){
        /* This function returns the median of a given integer list
         * If length of list is even, then the median is the average of the middle two values.
         * If length of list is odd, then the median is simply the middle value
         */

        int n = arr.length;
        int index = 0;
        float medianVal = 0;
        Arrays.sort(arr); // Used to sort given integer array in ascending order
        if (n%2 == 0){
            // If total length of list is even, then median is average of two middle values
            index = n/2;
            int[] medianArr = {arr[index-1],arr[index]};
            medianVal = getMean(medianArr);
            return medianVal;    
        } else{
            index = (n-1)/2;
            medianVal = arr[index];
            return medianVal;
        }
    }

    static int[] getUnique(int[] arr){
        // This function returns a list of all the unique numbers in given array

        int n = arr.length;
        int[] uniArr = new int[n];
        int uniIndex = 0;
        uniArr[0] = arr[0];
        uniIndex += 1;
        int check = 0;
        for(int i=1;i<n;i++){
            check = 0;
            for(int j=0;j<uniIndex;j++){
                // If similar element is found, then change check variable to 1, and break out of inner loop
                if (uniArr[j]==arr[i]){
                    check = 1;
                    break;
                }
            }
            // Check for uniqueness
            if (check==0){
                uniArr[uniIndex] = arr[i];
                uniIndex += 1;
            }
        }
        
        // Store unique elements into an array that is initialized to required length
        int[] uniElements = new int[uniIndex];
        for (int i=0;i<uniIndex;i++){
            uniElements[i] = uniArr[i];
        }
        return uniElements;
    }    
     

    static int getMax(int[] arr){
        // This function returns the maximum integer value present in an array

        int n = arr.length;
        int maxVal = arr[0];
        for (int i=1; i<n; i++){
            if (arr[i]>arr[i-1]){
                maxVal = arr[i];
            }
        }
        return maxVal;
    }

    static int[] getMode(int[] arr){
        // This function returns the most recurring element(s) in the given integer array
        // Two other functions, namely - getUnique and getMax - are called within this function

        int n = arr.length;
        int[] uniArr = getUnique(arr);
        int[] uniCount = new int[uniArr.length];
        int count;
        for(int i=0; i<uniArr.length; i++){
            count = 0;
            // Iterate through orginial array (arr) and store "count" of each unique element in new array - uniCount
            for(int j=0;j<n;j++){
                if (uniArr[i]==arr[j]){
                    count += 1;
                }
            }
            uniCount[i] = count;
        }

        int maxCount = getMax(uniCount);

        // Initialize new array with length = no. of unique elements
        int[] finalArr = new int[uniArr.length];
        int modeIndex = 0;
        for(int i=0; i<uniArr.length; i++){
            if (maxCount==uniCount[i]){
                finalArr[modeIndex] = uniArr[i];
                modeIndex += 1;
            }
        }

        // Store final results and return mode in the form of a list
        int[] modeList = new int[modeIndex];
        for (int i=0; i<modeIndex; i++){
            modeList[i] = finalArr[i];
        }
        return modeList;
    }

    public static void main(String[] args){
        System.out.println("******************BEGIN PRORGRAM*******************");
        Scanner sc = new Scanner(System.in);
        System.out.print("How many integers do you want to enter? ");
        int n = Integer.parseInt(sc.nextLine());
        int[] intList = CreateArray(n);
        System.out.println("Select: \n1-Mean \n2-Median \n3-Mode\n");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1:
                float mean = getMean(intList);
                System.out.println("Mean of given integer list is: "+mean);
                break;
            
            case 2:
                float median = getMedian(intList);
                System.out.println("Median of given integer list is: "+median);
                break;

            case 3:
                int[] mode = getMode(intList);
                System.out.println("Mode of given integer list is: ");
                for(int item : mode){
                    System.out.print(item+" ");
                }
                break;
            
            default:
                System.out.println("***************INVALID INPUT. PLEASE TRY AGAIN******************");
                break;
        }
        System.out.println("\n******************END OF PRORGRAM*******************");      
        
    
        
    }    
}
