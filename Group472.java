public class Group472 extends Group {
    
    
    private String[] left;//left 0 for letter and 1 for number
    private String[] right;//right is same as left
    private Space[] spaces;
    
    
    public Group472(int numberOfSpaces){
        super();
        spaces = new Space[numberOfSpaces];
        left = new String[2];
        right = new String[2];
    }
    

    public String[] getLeft(){
        return left;
    }
    
    
    public String[] getRight(){
        return right;
    }
    
    public void addSpace(Space s){
        for (int i = 0; i<spaces.length; i++){
            if (spaces[i]==null){
                spaces[i]=s;
                return;
            }
        }
    }
    
    
    public void setLeft(String l, String n){
        left[0] = l;
        left[1] = n;
    }
    
    
    public void setRight(String l, String n){
        right[0]=l;
        right[1]=n;
    }
    
}