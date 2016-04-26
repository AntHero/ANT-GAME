package antgame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class WorldParser {

    private int id = 0;
    private int numOfRocks = 0;
    private int numOfAntHills = 0;
    private int blobOffood = 0;
    
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
            e.printStackTrace();
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
                        map[i][j] = new RockyCell(i, j);numOfRocks++;
                    } else if (c == '.') {
                        map[i][j] = new ClearCell(i, j, 0);
                    } else if (c == '+') {
                        map[i][j] = new AntHillCell(i, j, 0, Color.RED);
                        id++;
                    } else if (c == '-') {
                        map[i][j] = new AntHillCell(i, j, 0, Color.BLACK);
                        id++;
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
            if (this.checker(map,x,y)== false){
                System.out.println("The map is syntactically incorroct.");
                System.out.println("Please provide a correct map. ");
                return null;//exits method without returning a map.
            }
            //System.out.println("success!");//debugging           
            return map;

        }
    }
    //the method below checks if the map is syntactically correct for contests
    public boolean checker(Cell[][] map, int x,int y){
        boolean pass = true;
        
        for(int i=0; i< y; i++){//checks if the map is surounded by rocks
            pass = pass & (map[0][i] instanceof RockyCell);//north cells
            pass = pass & (map[x-1][i] instanceof RockyCell);//south cells
            pass = pass & (map[i][0] instanceof RockyCell);//west cells
            pass = pass & (map[i][y-1] instanceof RockyCell);//east cells             
        }
        
        pass = pass & ((numOfRocks - 14) == ((x*2)+(y*2)));// checks the number of remaining rocks.
        //System.out.println(numOfRocks);
        //TO-DO
        //checks the number of anthills
        //checks the orientation of anthills
        //checks the number of food blobs
        //checks the food blob 5*5
        
        return pass;
    }
    
}
