// January 25, 2023
import java.util.*;
public class Lab1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your details: ");
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Gender (m/f): ");
        char gender = sc.next().charAt(0);
        System.out.println("Which state are you from?");
        sc.nextLine();
        String state = sc.nextLine();
        System.out.println("PERSONAL DETAILS");
        System.out.println("NAME: "+name);
        System.out.println("AGE: "+age+" years");

        if (gender=='m'){
            System.out.println("GENDER: MALE");
        } else if (gender=='f') {
            System.out.println("GENDER: FEMALE");
        } else {
            System.out.println("INVALID GENDER INPUT");
        }
        
        switch (state){
            case "Jammu and Kashmir":
            System.out.println(name+" is from the Northern states of India.");
            break;
            case "Himachal Pradesh":
            System.out.println(name+" is from the Northern states of India.");
            break;
            case "New Delhi":
            System.out.println(name+" is from the Northern states of India.");
            break;
            case "Punjab":
            System.out.println(name+" is from the Northern states of India.");
            break;
            case "Haryana":
            System.out.println(name+" is from the Northern states of India.");
            break;
            case "Rajasthan":
            System.out.println(name+" is from the Northern states of India.");
            break;
            case "Uttarakhand":
            System.out.println(name+" is from the Northern states of India.");
            break;
            case "Uttar Pradesh":
            System.out.println(name+" is from the Northern states of India.");
            break;
            case "Madhya Pradesh":
            System.out.println(name+" is from the Northern states of India.");
            break;
            case "Chattisgarh":
            System.out.println(name+" is from the Northern states of India.");
            break;
            case "Jharkhand":
            System.out.println(name+" is from the Northern states of India.");
            break;
            case "Assam":
            System.out.println(name+" is from the Eastern states of India.");
            break;
            case "Manipur":
            System.out.println(name+" is from the Eastern states of India.");
            break;
            case "Tripura":
            System.out.println(name+" is from the Eastern states of India.");
            break;
            case "Sikkim":
            System.out.println(name+" is from the Eastern states of India.");
            break;
            case "West Bengal":
            System.out.println(name+" is from the Eastern states of India.");
            break;
            case "Odisha":
            System.out.println(name+" is from the Eastern states of India.");
            break;
            case "Gujarat":
            System.out.println(name+" is from the Western states of India.");
            break;
            case "Maharashtra":
            System.out.println(name+" is from the Western states of India.");
            break;
            case "Karnataka":
            System.out.println(name+" is from the Western states of India.");
            break;
            case "Goa":
            System.out.println(name+" is from the Western states of India.");
            break;
            case "Tamil Nadu":
            System.out.println(name+" is from the Southern states of India.");
            break;
            case "Telangana":
            System.out.println(name+" is from the Southern states of India.");
            break;
            case "Andhra Pradesh":
            System.out.println(name+" is from the Southern states of India.");
            break;
            case "Kerala":
            System.out.println(name+" is from the Southern states of India.");
            break;
            default:
            System.out.println("INVALID STATE INPUT");
            break;

        }
    }
}
