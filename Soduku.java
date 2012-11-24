import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.FileReader;
import java.util.Scanner;

public class Soduku extends Game {

    private Space[][] grids;
    private String name;
    int dimensions;
    
    public Soduku (int d){
        
        dimensions = d;
        name = "Soduku";
        grids = new Space[dimensions][dimensions];
        for (int i = 0; i < dimensions; i++){
            for (int j = 0; j<dimensions;j++){
                grids[i][j] = new Space(dimensions);
            }
        }
        
    }
    
    public Soduku (int d, String fn){
        this(d);
        loadFile(fn);
    }
    
    
    public void printBoardTerm(){
        
        System.out.println();
        
        for (int i = 0; i < dimensions; i++){
            
            for (int j = 0; j < dimensions; j++){
                
                int valer = grids[i][j].getValue();
                
                if (valer != 0)
                    System.out.printf("%3d", grids[i][j].getValue());
                else
                    System.out.printf("%3s","-");
                    
                if (j/2.0==1.0 || j/5.0==1.0 || j/8.0 == 1.0)
                    System.out.print(" ");
                
            }
            
            if (i/2.0==1.0 || i/5.0==1.0 || i/8.0 == 1.0)
                System.out.println();
            System.out.println();
            
        }
        
    }
    
    public static void main(String[] args){
        
        Soduku s = new Soduku(9,"testSoduku");
        
        s.printBoardTerm();
    }
    
    
    public void loadFile(String fn){
        
        Scanner s = null;
       
        try {
            s = new Scanner(new FileReader(fn));
        }
        
        catch (FileNotFoundException e){
            System.out.println(e);
            System.exit(1);
        }
           
        s.useDelimiter(",");
        
        int r, c;
        
        while (s.hasNext()){
            
            r = s.nextInt();
            c = s.nextInt();
            grids[r][c].setValue(s.nextInt());
            s.nextLine();
            
        }
    }

}