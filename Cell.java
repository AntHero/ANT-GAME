package antgame;

public class Cell {
  
    Position position;
    Cell instance;
    
    public Position getPosition() {
        return position;
    }
    
   public Cell getCellType(){
	   return instance;
   }
   
   public boolean getIsRocky(){
	   return instance.getClass().equals(RockyCell.class);
   }
    
  
}
