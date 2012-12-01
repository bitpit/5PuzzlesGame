public class Page472 implements Game {


    private Page472Space[][] grids; //the spaces
    private String name; //the name of the game: soduku (because i only learned how to spell later)
    int[] dimensions;
    public Group[] groups;
    private String[] keys = {"0","-","A","B","C","D"};
        
    
    public Page472 (String fn){
        
        FileLoader fl = new FileLoader(fn);
        fl.stringChecker();
        
        dimensions = fl.getDimensions();
        name = "Page472";
        grids = new Page472Space[dimensions[0]][dimensions[1]];
        for (int i = 0; i < dimensions[0]; i++){
            for (int j = 0; j<dimensions[1];j++){
                grids[i][j] = new Page472Space(dimensions[0],i,j);
                grids[i][j].setValue(0);
            }
        }
        
        groups = fl.loadPage472(this);
        
    }//loads the file fn onto a d by d board
    
    
    public String getName(){
        return name;
    }
    

    public boolean finished(){
        for (int i = 0; i < dimensions[0]; i++){
            for (int j = 0; j<dimensions[0]; j++){
                if (grids[i][j].getValue() == 0)
                    return false;
            }
            
        }
        return true;
    }
   
       
    public Space nextUnsolved(){
        for (int i = 0; i < dimensions[0];i++){
            for (int j = 0; j<dimensions[1];j++){
                if (grids[i][j].labeled==false) return grids[i][j];
            }
        }
        return grids[dimensions[0]-1][dimensions[1]-1];
    }//gives the next unsolved spot
    
    
    public Space getSpaceAt(int x, int y){
        return grids[x][y];
    }
        
    
    public void setSpaceAt(int x, int y, int val){
        grids[x][y].setValue(val);
    }
   
       
    public int[] getDimensions(){//of the board
        return dimensions;
    }
    
    
    public Group[] getGroups(){
        return groups;
    }
    
    
    public void printBoardTerm(){
        System.out.println();
        
        for (int i = 0; i < dimensions[0]; i++){
            
            for (int j = 0; j < dimensions[1]; j++){
                
                int valer = grids[i][j].getValue();
                
                System.out.printf("%3s",keys[valer]);
            }
            System.out.println();
            
        }

    }
    
    
    
}