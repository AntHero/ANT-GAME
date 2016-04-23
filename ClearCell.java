package antgame;


public class ClearCell extends Cell {

    Position position;
    Ant ant;
    boolean hasAnt;
    int food;
    //TO-DO implement type marker.
    boolean redMarker;
    boolean blackMarker;

    public ClearCell(int x, int y, int food) {
        this.hasAnt = false;
        this.food = food;
        this.position = new Position(x, y);
    }

    public void antMoved() {
        this.ant = null;
        hasAnt = false;
    }

    public void move(Ant ant) {
        this.ant = ant;
        hasAnt = true;
    }
    
    public void setFoodUp() {
        this.food = this.food + 1;
    }
    
    public void setFoodDown() {
        this.food = this.food - 1;
    }

    public void setRedMarker(boolean redMarker) {
        this.redMarker = redMarker;
    }

    public void setBlackMarker(boolean blackMarker) {
        this.blackMarker = blackMarker;
    }

    public Ant getAnt() {
        return ant;
    }

    public boolean hasAnt() {
        return hasAnt;
    }

    public int getFood() {
        return food;
    }

    public boolean hasRedMarker() {
        return redMarker;
    }

    public boolean hasBlackMarker() {
        return blackMarker;
    }
    public boolean some_ant_at(Position p){
    	return
    }

}
