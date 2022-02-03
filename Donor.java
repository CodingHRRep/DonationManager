package DonationManager;

import javax.swing.*;
import java.text.DecimalFormat;

/**
 * Created by Jonathan Joffroy on 27/11/2021
 */
public class Donor
{

   DecimalFormat df = new DecimalFormat("00000");

   private static int noOfDonors = 0;
   private static int accountNumber = 1;
   private static final int donationNumber = 1;

   private String memFirstName, memSurname, memStreet, memCounty, memPostCode, memEmail, memPassword;
   private int memHouseNum;
   private final int donorNumber;

   private boolean invalid = true;

   public Donor ()
   {
      memFirstName = JOptionPane.showInputDialog("Please enter your first name: ");
      firstNameValidation(memFirstName);
      memSurname = JOptionPane.showInputDialog("Please enter your surname: ");
      surnameValidation(memSurname);
      memEmail = JOptionPane.showInputDialog("Please enter your email address (This will be your username): ");
      emailValidation(memEmail);

      do {
         try {
            memHouseNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter your House Number: "));
            invalid = false;
         }
         catch (NumberFormatException error)
         {
            JOptionPane.showMessageDialog(null, "House number must be a whole number, try again.");
         }//catch to avoid error upon parsing integer
      }//do
      while(invalid);

      memStreet = JOptionPane.showInputDialog("Please enter your Street Name: ");
      streetValidation(memStreet);
      memCounty = JOptionPane.showInputDialog("Please enter the county of your address: ");
      countyValidation(memCounty);
      memPostCode = JOptionPane.showInputDialog("Please enter your post code: ");
      codeValidation(memPostCode);
      memPassword = JOptionPane.showInputDialog("Please create a password for your account: ");

      donorNumber = accountNumber;
      accountNumber = accountNumber + 1;

      noOfDonors++;
   }//constructor

   protected void firstNameValidation(String name)
   {
      if (name == null)
      {
         JOptionPane.showMessageDialog(null, "Cancel button selected, exiting the process");
         System.exit(0);
      }//if

      String[] memFNValidation = name.split(" ");//splitting the input to check it's just one word

      if((name.isEmpty()) || (memFNValidation.length > 1))
      {
         JOptionPane.showMessageDialog(null, "First name must be one word only, please try again");
         memFirstName = JOptionPane.showInputDialog("Please enter your first name: ");
         firstNameValidation(memFirstName); //resetting the validation to check again
      }//if
   }//First Name validation method

   protected void surnameValidation(String name)
   {
      if (name == null)
      {
         JOptionPane.showMessageDialog(null, "Cancel button selected, exiting the process");
         System.exit(0);
      }//if

      String[] memSNValidation = name.split(" ");//splitting the input to check it's just one word

      if((name.isEmpty()) || (memSNValidation.length > 1))
      {
         JOptionPane.showMessageDialog(null, "surname must be one word only, please try again");
         memSurname = JOptionPane.showInputDialog("Please enter your surname: ");
         surnameValidation(memSurname); //resetting the validation to check again
      }//if
   }//First Name validation method

   protected void emailValidation(String email)
   {
      if (email == null)
      {
         JOptionPane.showMessageDialog(null, "Cancel button selected, exiting the process");
         System.exit(0);//exiting if cancel  selected
      }//if

      if(email.contains("@") == false)
      {
         JOptionPane.showMessageDialog(null, "Email must contain @ symbol, please try again");
         memEmail = JOptionPane.showInputDialog("Please enter your email address: ");
         emailValidation(memEmail); //rerunning validation to check now ok
      }//if
   }//surnameValidation method

   protected void streetValidation(String street)
   {
      if (street == null)
      {
         JOptionPane.showMessageDialog(null, "Cancel button selected, exiting the process");
         System.exit(0);//exiting if cancel selected
      }//if
      if(street.isEmpty())
      {
         JOptionPane.showMessageDialog(null, "Entry was blank, please try again");
         memStreet = JOptionPane.showInputDialog("Please enter your Street Name: ");
         streetValidation(memStreet);
      }//if
   }//streetValidation method

   protected void countyValidation(String county)
   {
      if (county == null)
      {
         JOptionPane.showMessageDialog(null, "Cancel button selected, exiting the process");
         System.exit(0);//exiting if cancel selected
      }//if

      String [] countyValidation = county.split(" ");

      if(county.isEmpty() || (countyValidation.length > 1))
      {
         JOptionPane.showMessageDialog(null, "County must be one word, please try again");
         memCounty = JOptionPane.showInputDialog("Please enter the county of your address: ");
         countyValidation(memCounty);
      }//if
   }//streetValidation method

   protected void codeValidation(String pCode)
   {
      if (pCode == null)
      {
         JOptionPane.showMessageDialog(null, "Cancel button selected, exiting the process");
         System.exit(0);
      }
      String [] postCodeValidation = pCode.split(" ");
      if(pCode.isEmpty() || (postCodeValidation.length != 2))
      {
         JOptionPane.showMessageDialog(null, "Post Code must two blocks separated by a space, please try again");
         memPostCode = JOptionPane.showInputDialog("Please enter your post code: ");
         countyValidation(memPostCode);
      }//if
   }//codeValidation method to check post code is 2 separate parts split by a space.

   protected void passwordValidation(String pw)
   {
      if (pw == null)
      {
         JOptionPane.showMessageDialog(null, "Cancel button selected, exiting the process");
         System.exit(0);//exiting if cancel selected
      }//if
      if(pw.isEmpty())
      {
         JOptionPane.showMessageDialog(null, "Entry was blank, please try again");
         memPassword = JOptionPane.showInputDialog("Please create a password for your account: ");
         passwordValidation(memPassword);
      }//if
   }//streetValidation method

   protected void setFirstName(String DonFirstName) {
      memFirstName = DonFirstName;
   }//setName

   protected String getFirstName() {
      return memFirstName;
   }//getName

   protected void setSurname(String DonSurname) {
      memSurname = DonSurname;
   }//setSurname

   protected String getSurname() {
      return memSurname;
   }//getSurname

   protected void setHouseNumber(int houseNum) {
      memHouseNum = houseNum;
   }//setAddress

   protected int getHouseNumber() {
      return memHouseNum;
   }//getAddress

   protected void setStreet(String street) {
      memStreet = street;
   }//setStreet

   protected String getStreet() {
      return memStreet;
   }//getStreet

   protected void setCounty(String county) {
      memCounty = county;
   }//setCounty

   protected String getCounty() {
      return memCounty;
   }//getCounty

   protected String getPostCode() {
      return memPostCode;
   }//getPostCode

   protected void setPostCode(String postCode)
   {
      memPostCode = postCode;
   }//setPostCode

   protected void setEmail(String email) {
      memEmail = email;
   }//setEmail

   protected String getEmail() {
      return memEmail;
   }//getEmail

   protected void setMemPassword(String pw) {
      memPassword = pw;
   }//setPassword

   protected String getPassword() {
      return memPassword;
   }//getPassword

   private int numberofDonors()
   {
      return noOfDonors;
   }

   public String toString()
   {
      return "=============================================================" + "\n" +
            "Account details for: " + memFirstName + " " + memSurname + "\n" +
            "Email address:" + memEmail + "\n" +
            "First name: " + memFirstName + "\n" +
             "Surname: " + memSurname + "\n" +
            "Account Number: " + df.format(donorNumber) + "\n" +
             "Address: " + memHouseNum  + " " + memStreet + ", " + memCounty + ", " + memPostCode + "\n"
            + "============================================================" + "\n";
   }//toString
}//class

