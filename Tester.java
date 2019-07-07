import TravelPackage.*;
import java.io.*;
import java.util.*;
public class Tester{
   public static void main(String [] args)throws Exception {
		SystemManager res = new SystemManager();
      String again;
      boolean flag = false;
      //open input file
      File fin = res.openInputFile();
      Scanner inf = new Scanner(fin);
      Scanner kb = new Scanner(System.in);
      //read in file
      ReadInput read = new ReadInput();
      read.readingInputFile(inf, res);
      //close file
      //fin.close();
      int choice;
      
      
      while(flag ==false){
      choice = menu();
      executeChoice(choice, res);
      System.out.println("Would you like to see the menu again? y/n: ");
      again = kb.next();
      
      if(again.equals("y") || again.equals("Y")){
         flag = false;
         }
      else
         flag = true;
         
      }//end while
      
      
   }//end main
   
   public static int menu(){
      int choice;
      Scanner kb = new Scanner(System.in);
      System.out.println("1.) Change a price associated with seats");
      System.out.println("2.) Find avaible seats associated with a flight ");
      System.out.println("3.) Change the seat class price for an origin and destination for a given flight ");
      System.out.println("4.) Book a seat on a specific flight ");
      System.out.println("5.) Book a seat on a flight given only a seeting preference ");
      System.out.println("6.) Display deatails ");
      System.out.println("7.) Store information about the airport in a specified file ");
      choice = kb.nextInt();
      //kb.flush();
      return choice;
   }
   
   public static void executeChoice(int choice, SystemManager res)throws Exception{
      String orig;
      String dest, fc, sc;
      String airline;
      int row;
      char col;
      int price;
      Scanner kb = new Scanner(System.in);
      switch(choice){
         case 1: System.out.print("Which flight would you like to change? Enter ORIGIN: ");
                     orig = kb.next();
                 System.out.print("Which flight would you like to change? Enter DESTINATION: ");
                     dest = kb.next();
                 System.out.print("What do you want to be the new price? Enter PRICE(int): ");
                     price = kb.nextInt();
                     
                 res.findFlights(orig, dest, price);
            break;
         case 2: System.out.println("please enter an ORIGIN:");
                  orig = kb.next();
                 System.out.println("Please enter a DESTINATION: ");
                  dest = kb.next();
                 res.findAvailableFlights(orig, dest);
            break;
         case 3: System.out.print("Which flight would you like to change? Enter ORIGIN: ");
                     orig = kb.next();
                 System.out.print("Which flight would you like to change? Enter DESTINATION: ");
                     dest = kb.next();
                 System.out.print("What do you want to be the new price? Enter PRICE(int): ");
                     price = kb.nextInt();
                     
                 res.findFlights(orig, dest, price);
            break;
         case 4: System.out.println("Please enter an airline: ");
                  airline = kb.next();
                  System.out.println("Please enter a flight code: ");
                  fc = kb.next();
                  System.out.println("Please enter seat row (int): ");
                  row = kb.nextInt();
                  System.out.println("Please enter a seat colum(letter): ");
                  col = kb.next().charAt(0);
                  System.out.println("What seat class would you like? F = first, B = busniess and E = economy: ");
                  sc = kb.next();
                  if(sc == "F")
                     res.bookSeat(airline,fc, SeatClass.first, row, col);
                  else if(sc == "B")
                     res.bookSeat(airline,fc, SeatClass.business, row, col);
                  else
                     res.bookSeat(airline,fc, SeatClass.economy, row, col);
                     
                  System.out.println("You have booked your seat!");
            break;
         case 5: System.out.print("Which flight would you like to change? Enter ORIGIN: ");
                     orig = kb.next();
                 System.out.print("Which flight would you like to change? Enter DESTINATION: ");
                     dest = kb.next();
                 System.out.println("Window or Aisle seat? W/A: ");
                  String sp = kb.next();
                  
                  res.seatPref(orig,dest,sp);
            break;
         case 6: res.displaySystemDetails();;
            break;
         case 7: res.writeToOutput();;
            break;
            }

   }//end execute choice
}//end tester