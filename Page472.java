public class Page472 implements Game {


    private Page472Space[][] grids; //the spaces
    private String name; //the name of the game: soduku (because i only learned how to spell later)
    int[] dimensions;
    public Group[] groups;
    
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
        System.out.println();
        
                
        for (int i = 0; i < groups.length/2; i++){
            Space s = groups[i].getSpace(0);
            System.out.println("Group "+i+" at Space "+s.getX()+", "+s.getY()+" constraints:");
            System.out.println("    -Constraints Top: "+groups[i].getLeft()[0]+groups[i].getLeft()[1]);
            System.out.println("    -Constraints Bottom: "+groups[i].getRight()[0]+groups[i].getRight()[1]);
        }
        
        System.out.println();
        System.out.println();
        
        for (int i = 6; i < groups.length; i++){
            Space s = groups[i].getSpace(0);
            System.out.println("Group at Space "+s.getX()+", "+s.getY()+" constraints:");
            System.out.println("    -Constraints Left: "+groups[i].getLeft()[0]+groups[i].getLeft()[1]);
            System.out.println("    -Constraints Right: "+groups[i].getRight()[0]+groups[i].getRight()[1]);
        }
    }
    
    
}