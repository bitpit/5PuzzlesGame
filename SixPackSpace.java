public class SixPackSpace implements Space {

    private int value;
    private int x;
    private int y;
    private int[] possiblities;
    private int resetVal;
    public Group group;
    public boolean labeled;
    
    
    public SixPackSpace(int ecks, int why){
        labeled = false;
        x = ecks;
        y = why;
        value = 0;
        resetVal = value;
        possiblities = new int[15];
        for (int i = 0; i < possiblities.length; i++){
            possiblities[i] = i+1;
        }
    }
    
    
    public SixPackSpace(int ecks, int why, int val){
        this(ecks,why);
        value = val;
    }
    
    
    public Group getGroup(){
        return group;
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
        group = g;
    }
    
    
    public boolean morePossibilities(){
        if (value == possiblities.length)
            return false;
        return true;
    }
    
    
    public void reset(){
        labeled = false;
        value = 0;
    }
    
    
    public Group getRow(){
        return group;
    }
    
    
    public Group getColumn(){
        return group;
    }
    
    
    public void setRow(Group g){
        group = g;
    }
    
    
    public void setColumn(Group g){
        group = g;
    }

    
}