public class KenKenSpace implements Space {
    
    private int value;
    private int x;
    private int y;
    private int[] possiblities;
    private int resetVal;
    public Group group;
    public boolean labeled;
        
    
    public KenKenSpace (int dimensions, int ecks, int why) {
               
        labeled = false;
        value = 0;
        resetVal = value;
        x = ecks;
        y = why;
        possiblities = new int[dimensions];
        
        for (int i = 0; i < dimensions; i++)
            possiblities[i] = 1+i;
        
    }
    
    
    public KenKenSpace(){
        value = 0;
    }
    
    
    public static void main(String[] args){
        
        KenKenSpace s = new KenKenSpace(4,0,0);
        for (int i = 0; i < 20; i++){
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
        if (morePossibilities()){
            value = possiblities[value];
        }
        else reset();
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
        labeled = false;
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
    
    
}