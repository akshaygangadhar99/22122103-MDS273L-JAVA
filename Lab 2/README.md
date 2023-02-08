LAB 2
You are supposed to create a menu-driven program that has the following menu options:
1. Enter a name
2. Search for a name
3. Remove a name
4. Show all names

Note:
The menu-driven program has to be made with the help of a do-while loop and switch-case statements.

Constraints:
1. The names collected must be stored in an array with a max length of 1024.
2. The names in the array should be UNIQUE; no duplicate entries are expected!
3. Provide necessary validations that the user enters only valid names that are not going to be repeated.
4. Removing a name should not create empty space inside the array!

SOLUTION:
Important Points to note in the solution code:
1) do-while and switch case statements have been used to peform the major tasks
2) No in-built functions have been utilized
3) Self-written codes using functions such as charAt, string.length, etc have been used for minor conveniences
4) This is clearly evident in lines 21-31 and 53-65 where character-wise comparison is performed between 2 strings

SAMPLE OUTPUT:
Enter your choice: 
1. Enter a name
2. Search for a name
3. Remove a name
4. Show all names
5. Exit
1
Enter a name: 
Akshay
Enter your choice: 
1. Enter a name
2. Search for a name
3. Remove a name
4. Show all names
5. Exit
1
Enter a name: 
Ash
Enter your choice: 
1. Enter a name
2. Search for a name
3. Remove a name
4. Show all names
5. Exit
1
Enter a name: 
Sanjeev
Enter your choice: 
3. Remove a name
4. Show all names
5. Exit
4
Akshay
Ash
Enter your choice:
1. Enter a name
2. Search for a name
3. Remove a name
4. Show all names
5. Exit
5
END OF PROGRAM