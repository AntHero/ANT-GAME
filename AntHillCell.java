package antgame;


public class AntHillCell extends ClearCell{
    
    Color color;
    
    //take ant parameter out bc you have to id ants from left to right after anthill placed
    public AntHillCell(int x, int y, int food, Color color) {
       super(x, y, food);
       this.position = new Position (x, y);	//idk
       this.ant = ant;
       this.color = ant.getColor();
       instance = this;
    }
    

}
