package antgame;


public class ClearCell extends Cell {

    Position position;
    Ant ant;
    boolean hasAnt;		//this might be unneeded as they it can be implemented later with just ant
    int food;
    //TO-DO implement type marker.
    int redMarker = -1;
    int blackMarker = -1;

    public ClearCell(int x, int y, int food) {
        this.hasAnt = false;
        this.food = food;
        this.position = new Position(x, y);
        instance = this;
    }

    public void antMoved() {
        this.ant = null;
        hasAnt = false;
    }

    public void move(Ant ant) {
        this.ant = ant;
        hasAnt = true;
    }
    
    //changed it from + to - because picking food up takes food off the cell
    public void pickFoodUp() {
        this.food = this.food - 1;
    }
    
    public void setFoodDown() {
        this.food = this.food + 1;
    }
    
    public void setFood(int i){
    	this.food = i;
    }

    public void setRedMarker(int redMarker) {
        this.redMarker = redMarker;
    }

    public void setBlackMarker(int blackMarker) {
        this.blackMarker = blackMarker;
    }
    
    public boolean hasRedMarker() {
        return redMarker != -1;
    }

    public boolean hasBlackMarker() {
        return blackMarker != -1;
    }
    
    public void removeRedMarker(){
    	redMarker = -1;
    }

    public void removeBlackMarker(){
    	blackMarker = -1;
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
    
    public void setAntExist(){
    	if(this.ant!=null){
    		throw new UnsupportedOperationException();
    	}
    	this.hasAnt = true;
    }
    
    public void removeAntExist(){
    	this.hasAnt = false;
    }
    
    public void setAnt(Ant ant){
    	this.ant=ant;
    }
    
    public void removeAnt(){
    	this.ant = null;
    }
    
    

}
