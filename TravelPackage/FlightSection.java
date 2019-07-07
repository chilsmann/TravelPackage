package TravelPackage;
public class FlightSection{
   private SeatClass seatClass;
   private Seat [][] totalSeats;
   private int row;
   private int col;
   
   public FlightSection(SeatClass seatClass, int row, int col){
      this.seatClass = seatClass;
      this.totalSeats = new Seat[row][col];
      this.row = row;
      this.col = col;
      for(int x = 0; x < row; x++){
         for(int y = 0; y < col; y++){
            this.totalSeats[x][y] = new Seat( x,  y);
            }
            }
   }//end constructor
   
   public void addSeats(int row, int col){
      if(row < 100 || row > 0 || col < 10 || col > 0)
         this.totalSeats = new Seat[row][col];
      else
         System.out.println("Rows cannot be more than 100 or less than 0. Cols can not be more than 10 or less than 0, please change.");
   }//end add Seats
   
   public SeatClass getSeatClass(){
      return this.seatClass;
   }//end getseatclass
   
   public boolean hasAvailableSeats(){
      //boolean flag;
      for(int x = 0; x < row; x++){
         for(int y = 0; y < col; y++){
            if(this.totalSeats[x][y].isFilled() == false)
               System.out.println("Seat Available!");
               return true;
            }
            }

      return false;
   }//end check
   
   public void fillSeat(int row, int col){
      this.totalSeats[row][col].fill();
   }
   
   public String toString(){
      String stat =  " Flight Section: " + this.seatClass + " has these seats taken and available: ";
      for(int x = 0; x < this.row; x++){
         for(int y = 0; y < this.col; y++){
            stat = stat + this.totalSeats[x][y].toString();
            }
      }
         return stat;
   }
}//end class