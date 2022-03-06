/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermreviewcodeforpartc;

import java.util.Scanner;

/**
 * The signIn page for UnoOnline.
 * Takes in a user name and password and then
 * validates the password before creating a new user in the list
 * of possible users. To be used as the beginning code for MidtermReview C.
 * @author dancye, 2019
 */
public class UnoOnline extends PasswordValidator
{
    private User users[] = new User[100];//room for 100 online players!
    int userCount;//keep track of number of users for array
    /**
     * Main method with call to private run method, to encapsulate our
     * main functionality.
     * @param args - not used
     */
    public static void main(String[] args) 
     {
       UnoOnline newPortal = new UnoOnline();
       Scanner input = new Scanner(System.in);
        
        for(newPortal.userCount=0; newPortal.userCount<newPortal.users.length; ){
            System.out.print("will you add an user(Y / N): ");            
            String mark=input.next();
            
            if (mark.equals("Y"))
                newPortal.run(); //main path, continue to add one new user
            else if (mark.equals("N"))
                break;//alternate path, stop adding new users
        }
       
    }
     /**
     * method that takes in the User's name and chosen password
     * and then continues prompting until the password is valid based on the
     * following two rules:
     * 1. The password must be at least length 8
     * 2. The password must contain at least one "special character"
     * 
     */
    private void run()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter your desired user name:");
        String userName = sc.nextLine();
        boolean validPassword=false;
        String password="";
        while(!validPassword)
        {
            System.out.println("Passwords must have at least 8 characters");
            System.out.println("Passwords must have at least one special character");
            System.out.println("Please enter your desired password:"); 
            
            password = sc.nextLine();
            
            //delegate the password validation to a PasswordValidator class
            //PasswordValidator pwdVal=new PasswordValidator();
            //validPassword=pwdVal.passwordValidate(password);
            
            // extend UnoOnline class to add PasswordValidator class
            validPassword=passwordValidate(password);
            
        }//loop only ends when password is valid so now we create the User
        
        User newUser = new User(userName, password);
        users[userCount] = newUser;//add the new user to the user list
        userCount++;
        System.out.println("New User Added");
        System.out.println("UserName: " + userName);
        System.out.println("Password: just kidding can't show password");
    }//end run method
   
    
}//end class
