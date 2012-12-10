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
        possiblities = new int[dimensions-1];
        
        for (int i = 0; i < dimensions-1; i++)
            possiblities[i] = 1+i;
    }
    
    
    public Group getGroup(){
        return column;
    }
    
    
    public int getValue(){
        return value;
    }
    
    
    public int getX(){
        return x;
    }
    
    
    public int getY(){
        return y;
    }
    
    
    public int getPossibilities(){
        return possiblities.length;
    }
    
    
    public void nextPossibility(){
        labeled = true;
        if (morePossibilities()){
            value = possiblities[value];
        }
        else reset();
    }
    
        
    public void setGroup(Group g){
        column = g;
    }
    
    
    public boolean morePossibilities(){
        if (value == possiblities.length)
            return false;
        return true;
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
    
    
    public void reset(){
        labeled = false;
        value = 0;
    }
    
    public void setValue(int v){
        value = v;
    }
    
}