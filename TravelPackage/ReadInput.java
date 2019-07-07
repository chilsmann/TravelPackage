package TravelPackage;
import java.util.*;
public class ReadInput{
   public ReadInput(){   
   }
   public void readingInputFile(Scanner fin, SystemManager res){
      String airport = null, airline = null, flightcode;
      String temp = "hi", orig, dest;
      char bracket, sectionCode, layout;
      int count = 0, year = 0, day = 0, month = 0, hours = 0, minutes = 0, seatPrice = 0, row = 0;
      //fin.useDelimiter(", ");
      //PRIME READ
      airport = fin.next();
      airport = airport.substring(1, 4);
      res.createAirport(airport);
      //READ REST OF AIRPORTS
         while(airport.charAt(airport.length() - 1) != ']'){
         airport = fin.next();
         if(airport.charAt(airport.length() - 1) == ']'){
            temp = airport.substring(0,3);
            res.createAirport(temp);
         }//end if
         else{
         airport = airport.substring(0, 3);//Get rid of White Space
         res.createAirport(airport);
         }//end else
      }//end Airport while
      
      //Read in Arilines
      temp = fin.next();
      while(temp.charAt(temp.length() -1) != '}'){
      if(temp.charAt(0) == '{'){
      airline = temp.substring(1,5);
      }
      else
         airline = temp.substring(0,4);
      res.createAirline(airline);
      while(temp.charAt(temp.length() -2) != ']'){
      if(count < 1)
         flightcode = temp.substring(6,9);
      else
         flightcode = temp.substring(5,8);
      if(temp.length() > 14){
      year = Integer.parseInt(temp.substring(10,14));
      }
      else if(temp.length()== 14)
         year = Integer.parseInt(temp.substring(9,13));
      else{
         year = Integer.parseInt(temp.substring(4,8));
         }
      temp = fin.next();
      temp = temp.substring(0,temp.length() -1);
      month = Integer.parseInt(temp);
      temp =fin.next();
      temp = temp.substring(0,temp.length() -1);
      day = Integer.parseInt(temp);
      temp =fin.next();
      temp = temp.substring(0,temp.length() -1);
      hours = Integer.parseInt(temp);
      
      temp = fin.next();
      minutes = Integer.parseInt(temp.substring(0,2));
      orig = temp.substring(3,6);
      dest = temp.substring(7, 10);
      sectionCode = temp.charAt(11);
      seatPrice = Integer.parseInt(temp.substring(13,16));
      layout = temp.charAt(17);
      int cols = numOfCols(layout);
      row = Integer.parseInt(temp.substring(19,20));
      
       
      res.createFlight(airline, orig, dest, year, month, day,flightcode, seatPrice);
      res.createSection(airline,flightcode, row, cols, SeatClass.economy);
      
      sectionCode = temp.charAt(21);
      seatPrice = Integer.parseInt(temp.substring(23,26));
      layout = temp.charAt(27);
      cols = numOfCols(layout);
      row = Integer.parseInt(temp.substring(29,30));
      
      res.createSection(airline,flightcode, row, cols, SeatClass.first);
      
      temp = fin.next();
      }
      count = 1;
      temp = fin.next();
      
     }//end first while
     
     fin.close();
   }//end readingInputFile
   
   public int numOfCols(char ch){
      if(ch == 'S')
         return 3;
      else if(ch =='M')
         return 4;
      else
         return 10;
   }
}//end class