public class Group {

    private Space[] spaces;
    int total;
    private String operator;

    public Group(int t, String op, int s){
        total = t;
        spaces = new Space[s];
        operator = op;
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
    
    public String getOp(){
        return operator;
    }

    public int getTotal(){
        return total;
    }
    
}