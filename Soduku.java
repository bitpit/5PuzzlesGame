import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.FileReader;
import java.util.Scanner;

public class Soduku implements Game {

    private SodukuSpace[][] grids;
    private String name;
    int dimensions;
    
    public Soduku (int d){
        
        dimensions = d;
        name = "Soduku";
        grids = new SodukuSpace[dimensions][dimensions];
        for (int i = 0; i < dimensions; i++){
            for (int j = 0; j<dimensions;j++){
                grids[i][j] = new SodukuSpace(dimensions);
            }
        }
        
    }
    
    public Soduku (int d, String fn){
        this(d);
        loadFile(fn);
    }
    
    

    
    public String getName(){
        return name;
    }
    
    public Space nextUnsolved(){
        for (int i = 0; i < dimensions;i++){
            for (int j = 0; j<dimensions;j++){
                if (grids[i][j].getValue()==0) return grids[i][j];
            }
        }
        return null;
    }
    
    
    public boolean finished(){
        for (int i = 0; i < dimensions;i++){
            for (int j = 0; j<dimensions;j++){
                if (grids[i][j].getValue()==0)
                    return false;
            }
        }
        return true;
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
    

}