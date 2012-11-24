public class Space {
    
    private int value;
    private int[] possiblities;
    
    
    public Space (int dimensions) {
     
        value = 0;
        possiblities = new int[dimensions];
    }
    
    public int getPossibilities(){
        return possiblities.length;
    }
    
    public int getValue(){
        return value;
    }
    
    public void setValue(int v){
        value = v;
    }
    
    public static void main(String[] args){

        //For testing
        Space p = new Space(9);
        System.out.println(""+p.getValue()+" cur val");
        System.out.println(""+p.getPossibilities()+" no of possibliities");
    }

}