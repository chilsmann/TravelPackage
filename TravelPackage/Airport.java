package TravelPackage;
public class Airport {
   private String name;
   
   public Airport(String n){
      if( n.length() == 3)
         this.name = n;
      else
         System.out.println( n +" Not a valid name!");
   }
   
   
   public void setName(String n){
      if( n.length() == 2)
         this.name = n;
      else
         System.out.println("Not a valid name!");
   }
   
   public String getName(){
      return name;
   }//end get method
   
   public String toString(){
      return "Airport: " + this.name+ " ";
   }
   
}//end class