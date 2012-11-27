public class KenKen implements Game { //A sudoku game board

    private KenKenSpace[][] grids; //the spaces
    private String name; //the name of the game: soduku (because i only learned how to spell later)
    int[] dimensions;
    private Group[] group;
  
    public KenKen (String fn){
        
        FileLoader fl = new FileLoader(fn);
        fl.stringChecker();
        
        dimensions = fl.getDimensions();
        name = "KenKen";
        grids = new KenKenSpace[dimensions[0]][dimensions[1]];
        for (int i = 0; i < dimensions[0]; i++){
            for (int j = 0; j<dimensions[1];j++){
                grids[i][j] = new KenKenSpace(dimensions[0],i,j);
            }
        }
        
        group = fl.loadKenKen(this);
        
    }//loads the file fn onto a d by d board
    
    
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
        for (int i = 0; i < dimensions[0];i++){
            for (int j = 0; j<dimensions[1];j++){
                if (grids[i][j].getValue()==0)
                    return false;
            }
        }
        return true;
    }//sees if its finished yet
    
    
    public Space getSpaceAt(int x, int y){
        return grids[x][y];
    }//gets the space at a particular place
    
   
    public void setSpaceAt(int x, int y, int val){
        grids[x][y].setValue(val);
    }
    
    
    
    public void printBoardTerm(){
        
        System.out.println();
        
        for (int i = 0; i < group.length; i++){
            
            System.out.println("Group "+(i+1)+": "+group[i].length()+" elts "+group[i].getOp()+" to "+group[i].getTotal());
            
            for (int j = 0; j < group[i].length(); j++){
                
                Space s = group[i].getSpace(j);
                System.out.println("   Space ("+s.getX()+", "+s.getY()+") of Group "+i);
                
                
            }
                
        }
        
    }
    
}