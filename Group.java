import java.util.ArrayList;
public class Group {

    private Space[] spaces;
    int total;
    private String operator;
    public int groupIDX;
    

    public Group(int t, String op, int s, int idx){
        total = t;
        spaces = new Space[s];
        operator = op;
        groupIDX = idx;
    }
    
    public Group(int numOfSpaces, int idx, int total){
        spaces = new Space[numOfSpaces];
        groupIDX = idx;
    }
    
    
    public Group(){
        total = 0;
    }
    
    
    public Group(int totes, int noOfSpaces){
        total = totes;
        spaces = new Space[noOfSpaces];
    }
    
    
    public void addSpace(Space s){
        for (int i = 0; i<spaces.length; i++){
            if (spaces[i]==null){
                spaces[i]=s;
                return;
            }
        }
    }
    
    
    public int length(){
        return spaces.length;
    }
    
    
    public Space getSpace(int s){
        return spaces[s];
    }
    
    
    public Space[] getSpaces(){
        return spaces;
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
    
    
    public ArrayList<Space> getSpacesList(){
        return null;
    }
}