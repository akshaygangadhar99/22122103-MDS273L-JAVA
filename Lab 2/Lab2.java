import java.util.*;
public class Lab2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] Name = new String[1024];
        int lastIndex = 0;
        int check = 0;
        int FirstTime = 1;
        do {
            System.out.println("Enter your choice: \n1. Enter a name \n2. Search for a name \n3. Remove a name \n4. Show all names \n5. Exit");
            int choice = Integer.parseInt(sc.nextLine());
            //System.out.print(choice);
            switch (choice) {
                case 1: // Enter name
                    System.out.println("Enter a name: ");
                    String NewName = sc.nextLine();
                    int checkName = 0;
                    if (FirstTime==0){
                        for (int index =0; index<lastIndex; index++){
                            String item = Name[index];
                            if (NewName.length()==item.length()){
                                for(int i=0;i<NewName.length();i++){
                                    if (NewName.charAt(i)!=item.charAt(i)) {
                                        checkName = 1;
                                        break;
                                    }
                                    }
                                } else{
                                    checkName = 1;
                                }  
                            }
                            if (checkName==1){
                                Name[lastIndex] = NewName;
                                lastIndex += 1;
                            } else {
                                System.out.println("This name already exists!! Try again!! ");
                            } 
                    } else{
                        Name[lastIndex] = NewName;
                        lastIndex += 1;
                        FirstTime = 0;
                    }
                     
                    break;
                    
                case 2: // Search for a name
                    System.out.println("Enter name to be searched: ");
                    String searchName = sc.nextLine();
                    int searchCheck = 0;
                    int loc = 9999;
                    for (int i=0; i<=lastIndex; i++) {
                        String item = Name[i];
                        if (item.length()==searchName.length()) {
                            for(int j=0;j<item.length();j++){
                                if (item.charAt(j)!=searchName.charAt(j)){
                                    searchCheck = 1;
                                    break;
                                }
                            
                            }
                            if (searchCheck==0){
                                loc = i;
                                break;
                            }  
                        }
                          
                    }

                    if (loc==9999){
                        System.out.print("This name does not exist in the list! ");
                    } else {
                        System.out.print("Index location of "+searchName+": "+loc+"\n");
                    }

                    break;

                case 3: // Remove a name
                    System.out.println("Enter name to be removed: ");
                    String removedName = sc.nextLine();
                    String[] newName = new String[1024];
                    int newIndex = 0;
                    for (String item : Name) {
                        if (item!=removedName) {
                            newName[newIndex] = item;
                            newIndex += 1;
                        }                                         
                    }
                    Name = newName;
                    lastIndex -= 1;
                    break;

                case 4: // Show all names
                    for (int i=0;i<lastIndex;i++){
                        System.out.println(Name[i]+" ");
                    }
            
                    break;
                
                case 5: // EXIT
                    check = 1;
                    System.out.println("END OF PROGRAM");
                    break;

                
            }

        } while (check == 0);

    }
}