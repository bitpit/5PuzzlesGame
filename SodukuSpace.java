public class SodukuSpace implements Space {
    
    private int value;
    private int[] possiblities;
    
    
    public SodukuSpace (int dimensions) {
        value = 0;
        possiblities = new int[dimensions];
        for (int i =0; i < dimensions; i++)
            possiblities[i] = 1+i;
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

}