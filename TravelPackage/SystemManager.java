package TravelPackage;
import java.util.*;
import java.io.*;
public class SystemManager extends CharConversion {
   private ArrayList<Airport> airports;
   private ArrayList<Airline> airlines;
   
   public SystemManager() {
      this.airports = new ArrayList();
      this.airlines = new ArrayList();
   }//end constructor
   
   public void createAirport(String name){
      Airport nextAirport = new Airport(name);
      boolean flag = duplicateAirport(nextAirport);
      if(flag == false && nextAirport.getName() != null){
      airports.add(nextAirport);
      }
      else
         System.out.println("Did not create "+ name + " an airport: INVAILD NAME!");
   }//end createAirport
   
   public void createAirline(String name){
      Airline nextAirline = new Airline(name);
      boolean flag = duplicateAirline(nextAirline);
      if(flag == false && nextAirline.getName() != null)
         airlines.add(nextAirline);
      else
         System.out.println("Did not create " + name +" an Airline: INVALID NAME!");
   }//end createAirline
   
   public void createFlight(String name, String orig, String dest, int year, int month, int day, String id, int price){
      Airline temp = checkAirline(name);
      Airport origTemp = checkAirport(orig);
      Airport destTemp = checkAirport(dest);
      if(month > 12 || day > 30 || month < 1 || day < 1)
         System.out.println("Invalid dates, please enter an appropriate date");
      else if(temp == null || orig.equals(dest))
         System.out.println("Not a valid Airline or Airport, please check your parameters");
      else{
      Flight nextFlight = new Flight(orig, dest, year, month, day, id, price);
      temp.addFlight(nextFlight);
      }//end else
   }//end createFlight
   
   public void createSection(String air, String fID, int rows, int cols, SeatClass s){
      Airline temp = checkAirline(air);
      boolean flag = false;
      if(temp == null)
         System.out.println("Please check your Airline parameters!");
      
      else{
         Flight curFlight = findFlight(fID, temp);
         if(curFlight == null)
            System.out.println("Please Check Flight ID.");
         ArrayList<FlightSection> myList = curFlight.getSectionList();
         for(int i = 0; i < myList.size(); i++){
            if(s.equals(myList.get(i).getSeatClass())){
               System.out.println("Only one Seat Class per type");
               flag = true;
               }
         }//end for
         if(flag == false)
            curFlight.addSection(s, rows, cols);
      }//end else
   }//end createSection
   
   public void bookSeat(String air, String fl, SeatClass s, int row, char col){
       Airline temp = checkAirline(air);
      boolean flag = false;
      if(temp == null)
         System.out.println("Please check your Airline parameters!");
      else{
         Flight curFlight = findFlight(fl, temp);
         if(curFlight == null)
            System.out.println("Please Check Flight ID.");
         else{
         int seat = charToInt(col);
         ArrayList<FlightSection> myList = curFlight.getSectionList();
         FlightSection tempSeatClass = null;
         for(int i = 0; i < myList.size(); i++){
            if(s.equals(myList.get(i).getSeatClass())){
               tempSeatClass = myList.get(i);
               flag = true;
               }
               
         }//end for
         if(flag == true)
            tempSeatClass.fillSeat(row, seat);
         }//end else
      }//end else
   }//end bookSeat
   
   public void displaySystemDetails(){
      for(int x = 0; x < airports.size(); x++){
         System.out.println(airports.get(x));
      }//end first for
      for(int y = 0; y < airlines.size(); y++){
         System.out.println(airlines.get(y));
      }//end last for
   }//end display
   
   public File openInputFile(){
      File inf = new File("input.txt");
      return inf;
   }
   
   public void readInInput(File inf)throws FileNotFoundException{
      Scanner fin = new Scanner(inf);
   }//end readIn
   
   
   public void writeToOutput()throws FileNotFoundException{
      try{
       PrintStream fout = new PrintStream("output.txt");

      for(int x = 0; x < airports.size(); x++){
         fout.println(airports.get(x));
      }//end first for
      for(int y = 0; y < airlines.size(); y++){
         fout.println(airlines.get(y));
      }//end last for
      
      fout.close();
      }
      catch (FileNotFoundException ex){
         System.out.println("Error in output");
      }
   }//end write to output

   
   public Flight findFlight(String fID, Airline air){
      ArrayList<Flight> myList = air.getFlightList();
      for(int i = 0; i < myList.size(); i++){
         if(fID.equals(myList.get(i).getFID()))
            return myList.get(i);
         }
            return null;
   }//end find
   
   public boolean duplicateAirport(Airport duplicate){
      if(airports.isEmpty() || duplicate.getName() == null)
         return false;
      else{
         for(int i = 0; i < airports.size(); i++){
         Airport that = airports.get(i);
         if(duplicate.getName().equals(that.getName()))
            return true;
         }
         return false;
     }//end else
   }//end checkairport
   
   public boolean duplicateAirline(Airline duplicate){
   if(airlines.isEmpty() || duplicate.getName() == null)
         return false;
      else{
         for(int i = 0; i < airlines.size(); i++){
         Airline that = airlines.get(i);
         if(duplicate.getName().equals(that.getName()))
            return true;
         }
         return false;
       }//end else
   }//end 
   
   public Airport checkAirport(String n){
      for(int i = 0; i < airports.size(); i++){
         if(n.equals(airports.get(i).getName()))
            return airports.get(i);
         }
            return null;
         
   }//end check
   
   public Airline checkAirline(String n){
      for(int i = 0; i < airlines.size(); i++){
         if(n.equals(airlines.get(i).getName()))
            return airlines.get(i);
         }
            return null;
         
   }//end check
   
   public void findFlights(String orig, String dest, int newPrice){
      ArrayList<Flight> myList;
      Flight temp = null;
      for(int x = 0; x < airlines.size(); x++){
         myList = airlines.get(x).getFlightList();
         for(int i = 0; i < myList.size(); i++){
            temp = myList.get(i);
            ArrayList<FlightSection> fList = temp.getSectionList();
            for(int y = 0; y < fList.size(); y++){
            if(temp.getOrig().equals(orig) && temp.getDest().equals(dest) == true)
               temp.setPrice(newPrice); 
             }//end for
         }//end for
      }//end for
   }//end find

   
   public void findAvailableFlights(String orig, String dest){
      ArrayList<Flight> myList;
      Flight temp = null;
      for(int x = 0; x < airlines.size(); x++){
         myList = airlines.get(x).getFlightList();
         for(int i = 0; i < myList.size(); i++){
            temp = myList.get(i);
            ArrayList<FlightSection> fList = temp.getSectionList();
            for(int y = 0; y < fList.size(); y++){
            if(temp.getOrig().equals(orig) && temp.getDest().equals(dest) && fList.get(y).hasAvailableSeats() == true)
               System.out.println(temp); 
             }//end for
         }//end for
      }//end for
   }//end find
   
   public void seatPref(String orig, String dest, String sp){
      ArrayList<Flight> myList;
      Flight temp = null;
      for(int x = 0; x < airlines.size(); x++){
         myList = airlines.get(x).getFlightList();
         for(int i = 0; i < myList.size(); i++){
            temp = myList.get(i);
            ArrayList<FlightSection> fList = temp.getSectionList();
            for(int y = 0; y < fList.size(); y++){
            if(temp.getOrig().equals(orig) && temp.getDest().equals(dest) == true)
                  System.out.println("This option is still under development.");
                
             }//end for
         }//end for
      }//end for
   }//end find
   
}//end class