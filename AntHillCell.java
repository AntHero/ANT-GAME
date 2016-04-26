package antgame;


public class AntHillCell extends ClearCell{
    
    Color color;
    static int id = 0;
    //take ant parameter out bc you have to id ants from left to right after anthill placed
    public AntHillCell(int x, int y, int food, Color color) {
       super(x, y, food);
       //this.position = new Position (x, y);	//this already happend in the call to the super constructer.
       this.ant = new Ant(id, color);
       id++;
       this.color = ant.getColor();
       instance = this;// not quite sure i understand this
    }
    

}
