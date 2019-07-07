package TravelPackage;
import java.util.ArrayList;

public class Flight{
   private ArrayList<FlightSection> classList = new ArrayList();
   private String orig;
   private String dest;
   private int year;
   private int month;
   private int day;
   private int price;
   private String id;
   
   public Flight(String orig, String dest, int year, int month, int day, String id, int price){
      this.orig = orig;
      this.dest = dest;
      this.year = year;
      this.month = month;
      this.day = day;
      this.id = id;
      this.price = price;
   }//end constructor
   
   public void addSection(SeatClass s, int row, int col){
      FlightSection fs = new FlightSection(s, row, col);
      classList.add(fs);
   }//end addSection
   
   public ArrayList<FlightSection> getSectionList(){
      return this.classList;
   }
   
   public void setPrice(int pr){
      this.price = pr;
      System.out.println("Changed price to " + this.price );
   }
   
   public int getPrice(){
      return this.price;
   }
   
   public String getFID(){
      return this.id;
   }//getfid
   
   public String getOrig(){
      return this.orig;
   }
   
   public String getDest(){
      return this.dest;
   }
   
   public String toString(){
      String statment = "Flight Origin: " + this.orig + ", Destination: "+ this.dest+", Year: " +this.year+ ", Month: " + this.month+", Day: "+this.day+" Flight ID: "+this.id+".";
      for(int x = 0; x < this.classList.size(); x++){
         statment = statment+ this.classList.get(x).toString();
         }
         return statment;
   }
      
}//end class