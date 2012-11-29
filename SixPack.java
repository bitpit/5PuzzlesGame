public class SixPack implements Game {

    
    private SixPackSpace[][] grids; //the spaces
    private String name; //the name of the game: soduku (because i only learned how to spell later)
    int[] dimensions;
    public Group[] groups;
    
    
    public SixPack(String fn){

        FileLoader fl = new FileLoader(fn);
        fl.stringChecker();
        
        name = "SixPack";
        grids = new SixPackSpace[8][];
        
        boolean increasing = true;
        int sizer = 3;
        
        for (int i = 0; i < grids.length; i++){
            grids[i] = new SixPackSpace[sizer];
            
            for (int j = 0; j < grids[i].length; j++){
                grids[i][j] = new SixPackSpace(i,j);
            }
            
            if (!increasing){
                sizer -= 2;
            }
            else {
                if (sizer+2 < 10)
                    sizer += 2;
                else
                    increasing = false;
            }
        }
                
    }


    public String getName(){
        return name;
    }
    
    
    public boolean finished(){
        for (int i = 0; i < grids.length; i++){
            for (int j = 0; j < grids[i].length; j++){
                if (grids[i][j].getValue() == 0)
                    return false;
            }
        }
        return true;
    }
    
    
    public void printBoardTerm(){
        System.out.println("da board");
    
    }
    
    
    public Space nextUnsolved(){
        
        for (int i = 0; i < grids.length; i++){
            for (int j = 0; j < grids[i].length; j++){
                if (grids[i][j].getValue() == 0)
                    return grids[i][j];
            }
        }
        return null;
    }
    
    
    public Space getSpaceAt(int x, int y){
        return grids[x][y];
    }
    
    
    public void setSpaceAt(int x, int y, int val){
        grids[x][y] = new SixPackSpace(x,y,val);
        
    }
    
    
    public Group[] getGroups(){
        
        return groups;
        
    }
    
    
    public int[] getDimensions(){
        
        return dimensions;
        
    }
        
    
}