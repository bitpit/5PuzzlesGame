public class KenKenSpace implements Space {
    
    private int value;
    private int x;
    private int y;
    private int[] possiblities;
    private int resetVal;
    public Group group;
    public boolean labeled;
    
    public KenKenSpace (int dimensions, int ecks, int why) {
        System.out.println(dimensions);
        
        labeled = false;
        value = dimensions;
        resetVal = value;
        x = ecks;
        y = why;
        possiblities = new int[dimensions];
        
        for (int i = dimensions-1; i > -1; i--)
            possiblities[i] = 1+i;
        System.out.println(possiblities[0]);
    }
    
    public static void main(String[] args){
        
        KenKenSpace s = new KenKenSpace(4,0,0);
        for (int i = 0; i < 20; i++){
            System.out.println(s.getValue());
            s.nextPossibility();
        }
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        for (int i = 3; i > -1; i--)
            System.out.println(i+" gets "+(i+1));
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
        if (morePossibilitiesInternal()){
            value = possiblities[value-2];
        }
        else reset();
    }
    
    
    public int getValue(){
        return value;
    }
    
    
    public void setValue(int v){
        value = v;
    }
    
    
    public boolean morePossibilitiesInternal(){
        if (value-2 < 0)
            return false;
        return true;
    }
    
    public boolean morePossibilities(){
        if (value == 1)
            return false;
        return true;
    }
    
    public Group getGroup(){
        return group;
    }
    
    
    public void reset(){
        labeled = false;
        value = resetVal;
    }
    
    public void setGroup(Group g){
        group = g;
    }

}