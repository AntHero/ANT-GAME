package antgame;


public class AntHillCell extends ClearCell{
    
    Color color;
    static int id = 0;
    //take ant parameter out bc you have to id ants from left to right after anthill placed
//    public AntHillCell(int x, int y, int food, Ant ant, Color color)
    public AntHillCell(int x, int y, int food, Color color) {
       super(x, y, food);
       this.ant = new Ant(id, color);
       id++;
       this.color = ant.getColor();
       instance = this;// not quite sure i understand this
    }
    

    public Color getColor(){
    	return color;
    }
}
