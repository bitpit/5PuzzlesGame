public class Page472 implements Game {


    private KenKenSpace[][] grids; //the spaces
    private String name; //the name of the game: soduku (because i only learned how to spell later)
    int[] dimensions;
    public Group[] groups;
    
    public Page472 (String fn){
        
        FileLoader fl = new FileLoader(fn);
        fl.stringChecker();
        
        dimensions = fl.getDimensions();
        name = "Page472";
        grids = new KenKenSpace[dimensions[0]][dimensions[1]];
        for (int i = 0; i < dimensions[0]; i++){
            for (int j = 0; j<dimensions[1];j++){
                grids[i][j] = new KenKenSpace(dimensions[0],i,j);
                grids[i][j].setValue(0);
            }
        }
        
        groups = fl.loadPage472(this);
        
    }//loads the file fn onto a d by d board
    
    
    public String getName(){
        return name;
    }
    

    public boolean finished(){
        return true;
    }
   
       
    public Space nextUnsolved(){
        return getSpaceAt(0,0);
    }
    
    
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
        System.out.println("da board");
    }
    
    
}