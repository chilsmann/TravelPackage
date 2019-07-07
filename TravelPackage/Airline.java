package TravelPackage;
import java.util.*;


public class Airline{
   private ArrayList<Flight> flightList;
   private String name;
   
   public Airline(String n){
      this.flightList = new ArrayList();
      if( n.length() < 6)
         this.name = n;
      else
         System.out.println(n +" Not a valid name!");
   }//end constructor
   
   public String getName(){
      return this.name;
   }
   
   public void addFlight(Flight flight){
      flightList.add(flight);
   }
   
   public ArrayList<Flight> getFlightList(){
      return this.flightList;
   }
   
   public String toString(){
      String s = "Airline: " + this.name+" and these Flights: ";
      for(int x = 0; x < flightList.size(); x++)
         s = s + flightList.get(x).toString();
      return s;
   }
   
}//end class