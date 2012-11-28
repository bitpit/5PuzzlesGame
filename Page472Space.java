public class Page472Space extends KenKenSpace implements Space {

    private int value;
    private int x;
    private int y;
    private int[] possiblities;
    private int resetVal;
    public Group row;
    public Group column;
    public boolean labeled;
    
    
    public Page472Space (int dimensions, int ecks, int why) {
        
        labeled = false;
        value = 0;
        resetVal = value;
        x = ecks;
        y = why;
        possiblities = new int[dimensions];
        
        for (int i = 0; i < dimensions; i++)
            possiblities[i] = 1+i;
        
    }
    
    
    public Group getGroup(){
        return column;
    }
    
    
    public int getX(){
        return x;
    }
    
    
    public int getY(){
        return y;
    }
    
        
    public void setGroup(Group g){
        column = g;
    }
    
    
    public Group getRow(){
        return row;
    }
    
    
    public Group getColumn(){
        return column;
    }
    
    
    public void setRow(Group g){
        row = g;
    }
    
    
    public void setColumn(Group g){
        column = g;
    }
    
}