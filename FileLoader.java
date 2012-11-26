import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.FileReader;
import java.util.Scanner;

public class FileLoader {
    
    
    private Scanner s;
    private String strong;
    private Scanner kbd = new Scanner(System.in);
    
    
    public FileLoader(String fn){
        
        strong = fn;
        
        try {
            s = new Scanner(new FileReader(fn));
        }
        
        catch (FileNotFoundException e){
            s = null;
        }
         
        
        
    }
    
    
    private void reFile(){
        
        try {
            s = new Scanner(new FileReader(strong));
        }
        
        catch (FileNotFoundException e){
            s = null;
        }
        
    }//gets a file with the string name
    
    
    public void stringChecker(){
        
        while (s == null){
            System.out.println("Please enter valid file name or kill program and run again");
            System.out.print("without specifying a file name at all: ");
            String s = kbd.nextLine();
            reFile();
            
        }
        
    }
    
    
    private void loadSoduku(Game g){
        
        s.useDelimiter(",");
        
        int r, c;
        
        while (s.hasNext()){
            
            r = s.nextInt();
            c = s.nextInt();
            g.setSpaceAt(r,c,s.nextInt());
            s.nextLine();
            
        }
        
    }
    
    
    public boolean loadToGame(Game g){
        
        if (g.getName().equals("Soduku")){ 
            loadSoduku(g);
            return true;
        }
        
        return false;
        
    }
    
    public int[] getDimensions(){
        if (s.hasNext()){
            String t = s.nextLine();
            int[] r = new int[t.length()/2];
            
            for (int i = 0;  i< (t.length()/2); i++){
                r[i] = Integer.parseInt(t.substring(i*2,(i*2+1)));
            }
    
            return r;
        }
        
        else return null;
    }
    
}
   