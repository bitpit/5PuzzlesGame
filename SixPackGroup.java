import java.util.ArrayList;
public class SixPackGroup extends Group {

    private ArrayList<Space> spaces;
    int total;
    private String operator;

    public SixPackGroup(int t, String op, int s){
        total = t;
        spaces = new ArrayList<Space>();
        operator = op;
    }
    
        
    public SixPackGroup(int totes, int noOfSpaces){
        total = totes;
        spaces = new ArrayList<Space>();
    }
    
    
    public void addSpace(Space s){
        spaces.add(s);
    }
    
    
    public int length(){
        return spaces.size();
    }
    
    
    public Space getSpace(int s){
        return spaces.get(s);
    }
    
    
    public Space[] getSpaces(){
        Space[] spa = new Space[spaces.size()];
        for (int i = 0; i < spa.length; i++)
            spa[i] = spaces.get(i);
        return spa;
    }
    
    
    public String getOp(){
        return operator;
    }
    

    public int getTotal(){
        return total;
    }
    
    
    public boolean anyEmpty(){
        for (Space s : spaces){
            if (s.getValue() == 0){
                return true;
            }
        }
        return false;
    }
    
    
    public void setLeft(String a, String b){
        
    }
    

    public void setRight(String a, String b){
    
    }
    
    
    public String[] getLeft(){
        return null;
    }
    
    
    public String[] getRight(){
        return null;
    }
    
}