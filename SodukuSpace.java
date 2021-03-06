public class SodukuSpace implements Space {
    
    private int value;
    private int x;
    private int y;
    private Group group;
    private int[] possiblities;
    public boolean labeled;
        
    
    public SodukuSpace (int dimensions, int ecks, int why) {
        labeled = false;
        value = 0;
        x = ecks;
        y = why;
        possiblities = new int[dimensions];
        for (int i =0; i < dimensions; i++)
            possiblities[i] = 1+i;
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
        value = possiblities[value];
    }
    
    
    public int getValue(){
        return value;
    }
    
    
    public void setValue(int v){
        value = v;
    }
    
    
    public boolean morePossibilities(){
        if (value == possiblities.length)
            return false;
        return true;
    }
    
    
    public Group getGroup(){
        return group;
    }
    
    
    public void reset(){
        value = 0;
    }
    
    
    public void setGroup(Group g){
        group = g;
    }
    
    
    public void setRow(Group g){
        
    }
    
    
    public void setColumn(Group g){
        
    }
    
    
    public Group getRow(){
        return null;
    }
    
    
    public Group getColumn(){
        return null;
    }
    
    
    public void setLabeled(){
        labeled = true;
    }
    
    
}