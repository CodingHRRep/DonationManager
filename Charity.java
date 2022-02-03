package DonationManager;

/**
 * Created by Jonathan Joffroy on 27/11/2021
 */
public class Charity
{
   private final String charityName;
   private final String charityType;
   private final String charityLocation;

   public Charity(String name, String type, String loc)
   {
      charityName = name;
      charityType = type;
      charityLocation = loc;
   }//charity Constructor

   static Charity c1 = new Charity("Children in Need", "Children's", "UK");
   static Charity c2 = new Charity("UNICEF", "Children's", "Worldwide");
   static Charity c3 = new Charity("Cancer Research", "Health", "UK");
   static Charity c4 = new Charity("RSPCA", "Animal", "UK");
   static Charity c5 = new Charity("RSPCC", "Children's", "UK");
   static Charity c6 = new Charity("SightSavers", "Health", "UK");
   static Charity c7 = new Charity("Great Ormond Street", "Children's/Health", "UK");
   static Charity c8 = new Charity("Doctors without Borders", "Health", "Worldwide");

   static Charity [] charities = {c1, c2, c3, c4, c5, c6, c7, c8};
   //creating charity array

   public String toString()
   {
      return charityName;
   }//toString


}//class 

