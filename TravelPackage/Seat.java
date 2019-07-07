package TravelPackage;
public class Seat extends CharConversion{
   private boolean filled;
   private int row;
   private char col;
  
   public Seat(int row, int col){
      this.row = row;
      this.filled = false;
      this.col = intToChar(col);
   }//end constructor
   
   public void fill(){
      if(this.filled == false)
         this.filled = true;
      else
         System.out.println("This seat has already been filled!");
      
   }
   
   public boolean isFilled(){
      return this.filled;
   }
   
   public String toString(){
      if(this.filled == true)
         return  " Seat: "+this.row+this.col+ " is filled. ";
      else
         return  " Seat: "+this.row+this.col+ " is not filled. ";
   }
}//end class