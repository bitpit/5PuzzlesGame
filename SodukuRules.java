public class SodukuRules implements Rule {
    
    private Game soduku;
    
    public SodukuRules(Game s){
        soduku = s;
    }

    public boolean row(){
        
        return true;
        
    }
    
    public boolean column(){
        return true;
    }
    
    
    public boolean shape(){
        
        return true;
    }
    
    
    public boolean constraints(Space s){
        
        if (row() && column() && shape())
            return true;
        return false;
    }
    
    public boolean allConstraints(){
        return true;
    }

}