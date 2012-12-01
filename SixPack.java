public class SixPack implements Game {

    
    private SixPackSpace[][] grids; //the spaces
    private String name; //the name of the game: soduku (because i only learned how to spell later)
    int[] dimensions;
    public Group[] groups;
    private boolean fin = false;
        
    
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
        groups = fl.load(this);
    }


    public String getName(){
        return name;
    }
    
    
    public boolean finished(){
        if (!fin){
            for (int i = 0; i < grids.length; i++){
                for (int j = 0; j < grids[i].length; j++){
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
    
    
    public void printBoardTerm(){
        
        for (int i = 0; i < grids.length; i++){
            StringBuffer s = new StringBuffer();
            for (int j = 0; j < grids[i].length; j++){
                s.append(""+grids[i][j].getValue()+" ");
            }
            s.append("\n");
            String p = s.toString();
            if (i%7==0 || i%4==0 || i%3 == 0)
                System.out.printf("%14s",p);
            else if (i == 1 || i == 6)
                System.out.printf("%16s",p);
            else if (i== 2 || i == 5)
                System.out.printf("%18s",p);
        }
        System.out.println();
    }
    
        
    public Group[] getGroups(){
        
        return groups;
        
    }
    
    
    public int[] getDimensions(){
        
        return dimensions;
        
    }
    
    
    
}