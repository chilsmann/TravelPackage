package TravelPackage;
public abstract class CharConversion{

   public int charToInt(char col){
      int seat;
      switch(col){
         case 'A': seat = 0;
            break;
         case 'B': seat = 1;
            break;
         case 'C': seat = 2;
            break;
         case 'D': seat = 3;
            break;
         case 'E': seat = 4;
            break;
         case 'F': seat = 5;
            break;
         case 'G': seat = 6;
            break;
         case 'H': seat = 7;
            break;
         case 'I': seat = 8;
            break;
         case 'J': seat = 9;
            break;
         default: seat = 10;
            break;
      }
      return seat;
   }
   
   
   public char intToChar(int col){
      char seat;
      switch(col){
         case 0: seat = 'A';
            break;
         case 1: seat = 'B';
            break;
         case 2: seat = 'C';
            break;
         case 3: seat = 'D';
            break;
         case 4: seat = 'E';
            break;
         case 5: seat = 'F';
            break;
         case 6: seat = 'G';
            break;
         case 7: seat = 'H';
            break;
         case 8: seat = 'I';
            break;
         case 9: seat = 'J';
            break;
         default: seat = 'N';
            break;
      }
      return seat;
   }
   
   }