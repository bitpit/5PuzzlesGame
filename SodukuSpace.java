public class SodukuSpace implements Space {
    
    private int value;
    private int x;
    private int y;
    private int[] possiblities;
    boolean labeled;
    
    
    public SodukuSpace (int dimensions, int ecks, int why) {
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
        return null;
    }
    
    public void reset(){
        value = 0;
    }
    
    public void setGroup(Group g){
        Group group = g;
    }

}