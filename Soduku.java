public class Soduku implements Game { //A sudoku game board
    
    private SodukuSpace[][] grids; //the spaces
    private String name; //the name of the game: soduku (because i only learned how to spell later)
    int[] dimensions;
    Group[] groups;
    private boolean fin = false;
        
    
    public Soduku (String fn){
        FileLoader fl = new FileLoader(fn);
        fl.stringChecker();
        
        dimensions = fl.getDimensions();
        name = "Soduku";
        grids = new SodukuSpace[dimensions[0]][dimensions[1]];
        for (int i = 0; i < dimensions[0]; i++){
            for (int j = 0; j<dimensions[1];j++){
                grids[i][j] = new SodukuSpace(dimensions[0],i,j);
            }
        }
        
        fl.load(this);
        
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
        if (!fin){
            for (int i = 0; i < dimensions[0];i++){
                for (int j = 0; j<dimensions[1];j++){
                    if (grids[i][j].getValue()==0){
                        return false;
                    }
                }
            }
        }
        else if (fin)
            return false;
        else
            fin = true;
        return true;
    }//sees if its finished yet
    
    
    public Space getSpaceAt(int x, int y){
        return grids[x][y];
    }//gets the space at a particular place
    
    
    public void setSpaceAt(int x, int y, int val){
        grids[x][y].setValue(val);
    }
    
    
    public Group[] getGroups(){
        return groups;
    }
    
    
    public void printBoardTerm(){
        
        System.out.println();
        
        for (int i = 0; i < dimensions[0]; i++){
            
            for (int j = 0; j < dimensions[1]; j++){
                
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
    
    
    public int[] getDimensions(){
        return dimensions;
    }
    
    
    public void reset(){
        for (int i = 0; i < grids.length; i ++){
            for (int j = 0; j < grids[i].length; j++){
                if (!grids[i][j].labeled)
                    grids[i][j].setValue(0);
            }
        }
        
    }
    
    
}