package DonationManager;

import javax.swing.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static DonationManager.Charity.*;
import static DonationManager.Interface.*;

/**
 * Created by Jonathan Joffroy on 27/11/2021
 * Comments: Issue with gift aid total not adding up correctly.
 **/
public class DonationsBox {
   static DecimalFormat df = new DecimalFormat("£0");

   private final String charityName;
   private int donationAmount;
   private boolean oneOffDonation = true;
   private boolean isGiftAid = true;
   private final String frequency;
   private final String giftAidSelection;
   static String anotherDonation = "yes";

   private static int giftAidTotal = 0;
   private static int total = 0;
   //variable declaration

   private static final ArrayList<DonationsBox> donations = new ArrayList<DonationsBox>();
   //Array creation

   public DonationsBox(String charity, int amount, boolean oneOff, boolean giftAid) {
      charityName = charity;
      donationAmount = amount;
      if (oneOffDonation == true) {
         frequency = "One off donation.";
      } else {
         frequency = "Monthly payment.";
      }
      if (giftAid == true) {
         giftAidSelection = "Gift Aid selected.";
      } else {
         giftAidSelection = "No gift aid.";
      }
      isGiftAid = giftAid;
      oneOffDonation = oneOff;
   }//Donations Box constructor

   public static void showMenu() {
      int result;
      String[] options = {"Log a donation", "See all donations", "Return to Main Menu"};
      result = JOptionPane.showOptionDialog(null,
            "Welcome to the Donation Centre. Please select from the following options.",
            "Donation Management System",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            null);

      if (result == 0) {
         makeDonations();
      }//if for making donations

      if (result == 1) {
         showDonations();
         showMenu();
      }//if for showing all donations

      if (result == 2) {
         startMenu();
      }//if for returning to main menu
   }//showMenu method

   public static void makeDonations() {
      int response;
      boolean oneOff = true;
      boolean isGiftAid = true;

      Object charityChoice;

      oneOff = payOptionMenu();
      isGiftAid = giftAidOption();

      charityChoice = JOptionPane.showInputDialog(
            null,
            "Select the charity of your choice",
            "Choose Charity",
            JOptionPane.QUESTION_MESSAGE,
            null,
            charities,
            null);

      JOptionPane.showMessageDialog(null, "Your chosen charity: " + charityChoice);

      String[] amountOptions = {"5", "10", "20", "50", "100"};

      int getAmount = Integer.parseInt((String) JOptionPane.showInputDialog(
            null,
            "Select the amount you wish to donate",
            "Choose Amount",
            JOptionPane.QUESTION_MESSAGE,
            null,
            amountOptions,
            amountOptions[4]));

      JOptionPane.showMessageDialog(null, "Your chosen amount is: " + getAmount);

      int index = 0;
      DonationsBox db1 = new DonationsBox(charityChoice.toString(), getAmount, oneOff, isGiftAid);
      donations.add(index, db1);
      //add to gift aid total if gift aid is selected here. Gift aid held outside of the methods.

      if (donations.get(index).isGiftAid == true) {
         donations.get(index).donationAmount = donations.get(index).donationAmount + (donations.get(index).donationAmount / 10);
         giftAidTotal = giftAidTotal + (donations.get(index).donationAmount / 10);
      }

      total = total + donations.get(index).donationAmount;

      index++;

      JOptionPane JOPtionPane = null;
      response = JOptionPane.showConfirmDialog(null, "Do you wish to donate again?",
            " Select an Option", JOptionPane.YES_OPTION);

      if (response == 0) {
         makeDonations();
      }//log another donation

      if (response == 1) {
         JOptionPane.showMessageDialog(null, "Thank you for your donation(s), now returning to donations menu", "Goodbye",
               JOptionPane.INFORMATION_MESSAGE);
         showMenu();
      }//return to menu

   }//charityOptionMenu

   protected static boolean payOptionMenu() {
      boolean oneOff = true;

      String[] payChoice = {"One off payment", "Monthly payment"};

      String getPayChoice;

      getPayChoice = (String) JOptionPane.showInputDialog(
            null,
            "Please select which payment type you prefer",
            "Payment Choice",
            JOptionPane.QUESTION_MESSAGE,
            null,
            payChoice,
            payChoice[1]);

      oneOff = getPayChoice == "One off payment";

      return oneOff;
   }//payOptionMenu

   protected static boolean giftAidOption() {
      boolean isGiftAid = true;

      int input = JOptionPane.showConfirmDialog(null,
            "Do you wish to Add Gift Aid (10% added to your donation, free of charge to you.)");

      if (input == 0) {
         isGiftAid = true;
         return isGiftAid;
      } else {
         isGiftAid = false;
         return isGiftAid;
      }

   }//gift Aid Option

   public static void showDonations() {
      JOptionPane.showMessageDialog(null, donations.toString());

      JOptionPane.showMessageDialog(null, "Your donations total is: " + df.format(total) + "\n"
            + "Your gift aid additional contributions add up to " + df.format(giftAidTotal));

   }//showDonations Method

   public String toString() {
      return "=========================" + "\n" +
            "Chosen Charity: " + charityName + "\n" +
            "Donation amount: " + df.format(donationAmount) + "\n" +
            "Donation Frequency: " + frequency + "\n" +
            "Gift Aid Selection: " + giftAidSelection + "\n" +
            "==========================";
   }//toString

}//class
