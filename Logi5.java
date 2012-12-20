public class Logi5 implements Game { //A sudoku game board
    
    private SodukuSpace[][] grids; //the spaces
    private String name; //the name of the game: soduku (because i only learned how to spell later)
    int[] dimensions;
    public Group[] groups;
    boolean changed = false;
    private boolean fin = false;
        
    
    public Logi5 (String fn){
        FileLoader fl = new FileLoader(fn);
        fl.stringChecker();
        
        dimensions = fl.getDimensions();
        name = "Logi5";
        grids = new SodukuSpace[dimensions[0]][dimensions[1]];
        for (int i = 0; i < dimensions[0]; i++){
            for (int j = 0; j<dimensions[1];j++){
                grids[i][j] = new SodukuSpace(dimensions[0],i,j);
                grids[i][j].setValue(0);
            }
        }
        
        groups = fl.load(this);
        
    }//loads the file fn onto a d by d board
    
    
    public void reset(){
        for (int i = 0; i < grids.length; i++){
            for (int j = 0; j < grids.length; j++){
                if (!grids[i][j].labeled){
                    grids[i][j].setValue(0);
                }
            }
        }
    }
    
    
    public String getName(){
        return name;
    }//gives the game name
    
    
    public Space nextUnsolved(){
        for (int i = 0; i < dimensions[0];i++){
            for (int j = 0; j<dimensions[1];j++){
                if (grids[i][j].getValue()==0) return grids[i][j];
            }
        }
        return null;
    }//gives the next unsolved spot
    
    
    public boolean finished(){
        if (!fin){
            for (int i = 0; i < dimensions[0]; i++){
                for (int j = 0; j<dimensions[0]; j++){
                    if (grids[i][j].getValue() == 0)
                        return false;
                }
                
            }
        }
        else if (fin)
            return false;
        else
            fin = true;
        return true;
    }
    
    
    public Space getSpaceAt(int x, int y){
        return grids[x][y];
    }//gets the space at a particular place
    
    
    public void setSpaceAt(int x, int y, int val){
        grids[x][y].setValue(val);
    }
    
    
    public Group[] getGroups(){
        return groups;
    }
    
    
    public int[] getDimensions(){
        return dimensions;
    }
    
    
    public void printBoarddTerm(){
        
        System.out.println();
        
        for (int i = 0; i < groups.length; i++){
            
            System.out.println("Group "+(i+1)+": "+groups[i].length()+" elts "+groups[i].getOp()+" to "+groups[i].getTotal());
            
            for (int j = 0; j < groups[i].length(); j++){
                
                Space s = groups[i].getSpace(j);
                System.out.println("   Space ("+s.getX()+", "+s.getY()+") of Group "+(i+1));
                
                
            }
            
        }
        
    }//boardDebugger*/
    
    
    public void printBoardTerm(){
        
        System.out.println();
        
        for (int i = 0; i < dimensions[0]; i++){
            
            for (int j = 0; j < dimensions[1]; j++){
                
                int valer = grids[i][j].getValue();
                
                if (valer != 0)
                    System.out.printf("%3d", grids[i][j].getValue());
                else
                    System.out.printf("%3s","0");
                
                
            }
            
            System.out.println();
            
        }
        
    }//printBoardReal*/
    
    
}