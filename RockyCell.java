package antgame;
/**
 * This class represents a rocky cell in the simulation
 * @author Arco
 * @author Abdulrahman
 */
public class RockyCell extends Cell {
        /**
         * The constructor of RockyCell
         * @param x The 'X' coordinate of the cell
         * @param y The 'Y' coordinate of the cell
         */
    public RockyCell(int x, int y){
        this.position = new Position(x,y);
        instance = this;
    }
}
