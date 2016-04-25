package antgame;


public class AntHillCell extends ClearCell{
    
    Color color;
    
    public AntHillCell(int x, int y, int food, Ant ant, Color color) {
       super(x, y, food);
       this.ant = ant;
       this.color = ant.getColor();
       instance = this;
    }
    

}
