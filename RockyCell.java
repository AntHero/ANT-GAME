package antgame;

public class RockyCell extends Cell {
        
    public RockyCell(int x, int y){
        this.position = new Position(x,y);
        instance = this;
    }
    
//    public Class cellType(){
//    	return RockyCell.class;
//    }
    
}
