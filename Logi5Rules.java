public class Logi5Rules implements Rule  {
    
    private Game game;
    private int dimensions;
    
    public Logi5Rules(Game g){
        game = g;
        dimensions = g.getDimensions()[0];
    }
    

    public boolean row(Space s){
        
        int y = s.getY();
        
        for (int i = 0; i<dimensions; i++){
            if (game.getSpaceAt(i,y).getValue() == s.getValue()){
                if (i != s.getX())
                    return false;
            }
        }
        
        return true;
        
    }
    
    
    public boolean column(Space s){
        
        int x = s.getX();
        
        for (int i = 0; i < dimensions; i++){
            if (game.getSpaceAt(x,i).getValue() == s.getValue()){
                if (i != s.getY())
                    return false;
            }
        }
        
        return true;
    }
    
    
    public boolean shape(Space s){
        
        Group g = s.getGroup();
        Space[] spaces = g.getSpaces();
        
        for (int i = 0; i < spaces.length; i++){
            if ((spaces[i].getValue() == s.getValue()) &&
                (s.getX() != spaces[i].getX() && 
                 s.getY() != spaces[i].getY()))
                return false;
        }
        
        
        if (g.anyEmpty())
            return true;
        
        return true;
    }
        
    
    public boolean constraints(Space s){
        
        if (shape(s) && row(s) && column(s))
            return true;
        return false;
    }
    
    
    public boolean allConstraints(){
        
        /*Group[] g = game.getGroups();
        
        for (int i = 0; i < g.length; i++){
            if (!shape(g[i].getSpace(0)))
                return false;
        }
        
        for (int i = 0; i < game.getDimensions()[0]; i++){
            if (!row(game.getSpaceAt(i,0)) || !column(game.getSpaceAt(0,i)))
                return false;
        }
        
        return true;*/
        
        for (int i = 0; i < game.getDimensions()[0]; i++){
            if (!constraints(game.getSpaceAt(i,0)) ||
                !constraints(game.getSpaceAt(0,i)))
                return false;
        }
        return true;
    }

}