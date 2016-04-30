package antgame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class WorldParser {

    private int numOfRocks = 0;
    private int numOfAntHills = 0;
    private int blobOffood = 0;
    private int redX = 0;
    private int redY = 0;
    private int blackX = 0;
    private int blackY = 0;

    public static void main(String[] args) {
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println(args[0] + " does not exist.");
            return;
        }
        if (!(file.isFile() && file.canRead())) {
            System.out.println(file.getName() + " cannot be read from.");
            return;
        }
        try {
            WorldParser parse = new WorldParser();

            parse.processMap(args[0]);
        } catch (IOException e) {
        }
    }

    /*the method below takes a file of the ant game map and converts it to an
     array of cells. then it calls the cheker to test that the map is 
     syntactically correct before returning the map.*/
    public Cell[][] processMap(String fileName) throws FileNotFoundException, IOException {
        File file = new File(fileName);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String current;
        int i = 0;
        int x = 0;
        int y = 0;

        try {
            x = Integer.parseInt(current = reader.readLine());
            y = Integer.parseInt(current = reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("First two line in the map file must be integers.");
            return null;//exits method without returning a map.
        } finally {
            //System.out.println(x);//debugging
            //System.out.println(y);//debugging
            Cell[][] map = new Cell[x][y];

            while ((current = reader.readLine()) != null) {
                String s = current.replaceAll("\\s+", "");//Trims the string of white space
                for (int j = 0; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (c == '#') {
                        map[i][j] = new RockyCell(i, j);
                        numOfRocks++;
                    } else if (c == '.') {
                        map[i][j] = new ClearCell(i, j, 0);
                    } else if (c == '+') {
                        map[i][j] = new AntHillCell(i, j, 0, Color.RED);
                        if (redX == 0) {//saves the co-ordinates for the first anhill cell.
                            redX = i;
                            redY = j;
                        }
                    } else if (c == '-') {
                        map[i][j] = new AntHillCell(i, j, 0, Color.BLACK);
                        if (blackX == 0) {//saves the co-ordinates for the first anhill cell.
                            blackX = i;
                            blackY = j;
                        }
                    } else if (Character.isDigit(c)) {
                        map[i][j] = new ClearCell(i, j, c);
                    } else {
                        System.out.println("Unidentified charecter used. ");
                        System.out.println("Please provide a correct map. ");
                        return null;//exits method without returning a map.
                    }
                    //System.out.print(c);//debugging
                }
                i++;
                //System.out.println("");//debugging
            }
            if (this.checker(map, x, y) == false) {
                System.out.println("The map is syntactically incorroct.");
                System.out.println("Please provide a correct map. ");
                return null;//exits method without returning a map.
            }
            System.out.println("success!");//debugging           
            return map;

        }
    }

    //the method below checks if the map is syntactically correct for contests
    public boolean checker(Cell[][] map, int x, int y) {
        boolean pass = true;

        for (int i = 0; i < y; i++) {//checks if the map is surounded by rocks
            pass = pass & (map[0][i] instanceof RockyCell);//north cells
            pass = pass & (map[x - 1][i] instanceof RockyCell);//south cells
            pass = pass & (map[i][0] instanceof RockyCell);//west cells
            pass = pass & (map[i][y - 1] instanceof RockyCell);//east cells             
        }

        pass = pass & ((numOfRocks - 14) == ((x * 2) + (y * 2) - 4));// checks the number of remaining rocks.
        //System.out.println(numOfRocks);//debugging
        //pass = pass & anhillchecker(map);
        //checks the number of food blobs
        //checks the food blob 5*5
        return pass;
    }
    
    public boolean anhillchecker(Cell[][] map){// method does not work yet!
        boolean pass = true;
        if (redX == 0 || redY == 0 || blackX == 0 || blackY == 0) {//checks there is two anthills
            pass = false;
            System.out.println("the map has to have two anthills ");
            return pass;
        } else {//checks the orientation of anthills
            int offset = 8;//number of cells to check in the y axis;
            int k = redY;
            boolean backward = false;
            boolean backward2 = false;
            for (int i = redX; i < redX + 13; i++) {
                if (map[i][k] instanceof ClearCell && map[i][k].getClass() != AntHillCell.class) {//to -do always enters
                    for (int j = k + 1; j < k + offset; j++) {
                        pass = pass && (map[i][j] instanceof AntHillCell);
                        //System.out.println(pass);
                    }
                } else {
                    for (int j = k; j > k + offset - 1; j++) {
                        pass = pass && (map[i][j] instanceof AntHillCell);
                        System.out.println(pass);
                    }
                    pass = pass && (map[i][k + offset] instanceof ClearCell);

                }
                if (backward) {
                    offset--;
                } else {

                    offset++;
                    if (offset == 14) {
                        backward = true;
                    }
                }
                //System.out.println(k);
                //System.out.println(offset);
                if (backward2){
                    k++;
                }else{
                k--;
                if(k ==redY -7){
                    backward2= true;
                }
                }
            }
        }
        return pass;
    }
}
