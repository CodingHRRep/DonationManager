package DonationManager;

import javax.swing.*;
import static DonationManager.DonationsBox.*;

/**
 * Created by Jonathan Joffroy on 27/11/2021
 */
public class Interface
{

   private static int result;
   private static int accountPosition;

   public static void LaunchInterface()
   {
      int arrayIndex = 0;
      Donor [] donors = new Donor[10];

      startMenu();

      if((result == 0) && (donors[0] == null))
      {
         JOptionPane.showMessageDialog(null, "No active accounts. Please create one first.");
         startMenu();
      }

      while (result == 1)
      {
         donors[arrayIndex] = new Donor();
         arrayIndex = arrayIndex + 1;

         accountCreatedMessage();

         startMenu();
      }//Create Donor object

      if(result == 0)
      {
         logIn(donors);
      }
   }//LaunchInterface

   protected static void startMenu()
   {

      String [] options = {"Login", "Create an Account"};
      result = JOptionPane.showOptionDialog(null,
            "Welcome to the Donation Management System. Please select an option.",
            "Donation Management System",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]);

   }//startMenu method

   public static void logIn(Donor [] pDonors)
   {
      String username, password;
      boolean found = false;

      username = JOptionPane.showInputDialog("Please enter the email associated with your account");
      if(findDonorUsername(username, pDonors) == true)
      {
         JOptionPane.showMessageDialog(null, "Account found successfully");
         password = JOptionPane.showInputDialog("Please enter your password");
         if(findDonorPassword(password, pDonors) == true)
         {
            JOptionPane.showMessageDialog(null, "Password correct, you have now logged in successfully");
            postLoginMenu(pDonors);
         }//if
         else
         {
            JOptionPane.showMessageDialog(null, "Password incorrect. Please attempt to log in again");
            logIn(pDonors);
         }
      }//if
      else
      {
         JOptionPane.showMessageDialog(null, "Account not found");
         logIn(pDonors);
      }//else

   }//logIn method

   public static boolean findDonorUsername(String username, Donor[] pDonors)
   {
      int index = 0;
      boolean found = false;
      try
       {
      while (!found && (index < pDonors.length))
      {
         if (username.equals(pDonors[index].getEmail()))
         {
            found = true;
            accountPosition = index;
            return found;
         }
         try
         {
            index++;
         }
         catch (ArrayIndexOutOfBoundsException error)
         {
            JOptionPane.showMessageDialog(null, "Account not found. Please try again.");
            logIn(pDonors);
         }
      }//while
       }
      catch(NullPointerException error)
      {
         JOptionPane.showMessageDialog(null, "Account not found. Please try again.");
         logIn(pDonors);
      }

      return found;
   }//findDonorUsername

   public static boolean findDonorPassword(String password, Donor[] pDonors)
   {
      return password.equals(pDonors[accountPosition].getPassword());
   }//findDonorPassword

   protected static void postLoginMenu(Donor [] pDonors)
   {
      int choice;

      String [] loginOptions = {"Donation Centre", "Change Account Details", "Show Account Details", "Exit"};
      choice = JOptionPane.showOptionDialog(null,
            "Welcome to the Donation Management System. Please select an option.",
            "Donation Management System",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            loginOptions,
            null);

      if(choice == 0)
      {
         showMenu();
         /**do {
            makeDonations();
            amountOptionMenu();
            donateAgainMenu ();
         }while (anotherDonation.equalsIgnoreCase("yes"));**/
      }//Donation if

      if(choice == 1)
      {
         int detailChoice;
         String [] AccountDetails = {"Change First Name", "Change surname", "Change address"};

         detailChoice = JOptionPane.showOptionDialog(null,
            "What details would you like to change?",
            "Donation Management System",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            AccountDetails,
            null);

         if(detailChoice == 0)
         {
            String firstNameChange;
            firstNameChange = JOptionPane.showInputDialog("Please enter the new first name for your account");
            pDonors[accountPosition].setFirstName(firstNameChange);

            JOptionPane.showMessageDialog(null, "Details changed successfully, returning to main menu.");
            postLoginMenu(pDonors);
         }//change first name if

         if(detailChoice == 1)
         {
            String surnameChange;
            surnameChange = JOptionPane.showInputDialog("Please enter the new first name for your account");
            pDonors[accountPosition].setSurname(surnameChange);

            JOptionPane.showMessageDialog(null, "Details changed successfully, returning to main menu.");
            postLoginMenu(pDonors);

         }//change surname if

         if(detailChoice == 2)
         {
            int houseNoChange = 0;
            String streetChange, countyChange, postCodeChange;
            boolean invalid = true;


            do {
               try {
                  houseNoChange = Integer.parseInt(JOptionPane.showInputDialog("Please enter your House Number: "));
                  invalid = false;
               }
               catch (NumberFormatException error)
               {
                  JOptionPane.showMessageDialog(null, "House number must be a whole number, try again.");
               }//catch to avoid error upon parsing integer
            }//do
            while(invalid);//while

            pDonors[accountPosition].setHouseNumber(houseNoChange);

            streetChange = JOptionPane.showInputDialog("Please enter the new street name for your account");
            pDonors[accountPosition].setStreet(streetChange);
            countyChange = JOptionPane.showInputDialog("Please enter the new county for your account");
            pDonors[accountPosition].setCounty(countyChange);
            postCodeChange = JOptionPane.showInputDialog("Please enter the new post code for your account");
            pDonors[accountPosition].setPostCode(postCodeChange);

            JOptionPane.showMessageDialog(null, "Details changed successfully, returning to main menu.");
            postLoginMenu(pDonors);
         }//change address details if

      }//change account if

      if(choice == 2)
      {
         JOptionPane.showMessageDialog(null, pDonors[accountPosition].toString());
         postLoginMenu(pDonors);
      }//show account details

      if(choice == 3)
      {
         JOptionPane.showMessageDialog(null, "Exit selected. Exiting the system.");
         System.exit(0);
      }//exit the system

   }//postLoginMenu

   protected static void accountCreatedMessage()
   {
      JOptionPane.showMessageDialog(null, "Account Created. Returning to Main Menu");
   }//created Account Message

}//class


