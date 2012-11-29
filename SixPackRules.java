public class SixPackRules implements Rule {

    
    private Game game;
    
    
    public SixPackRules(Game g){
        game = g;
    }
    
   
    public boolean shape(Space s){
        
        Group g = s.getGroup();
        int total = 0;
        
        for (int i = 0; i < g.getSpaces().length; i++){
            total += g.getSpace(i).getValue();
        }
        
        boolean spaces = someSpacesEmpty(s);
        
        if (spaces)
            if (total <= 25)
                return true;
        else if (total == 25)
                return true;
        return false;
    }
    
    
    public boolean constraints(Space s){
        System.out.println(shape(s)+" shape s.");
        System.out.println(shapeCharConflict(s)+" shapeCharConflict s.");
        System.out.println("s is at "+s.getX()+", "+s.getY());
        if (shape(s) && shapeCharConflict(s)) return true;
        else return false;
    }
    
    
    public boolean allConstraints(){
        Group[] groups = game.getGroups();
        for (Group g : groups){
            if (!shapeCharConflict(g.getSpace(0)) ||
                !shape(g.getSpace(0)))
                return false;
        }
        return true;
    }
    
    
    private boolean shapeCharConflict(Space s){
        
        Group g = s.getGroup();
        
        for (int i = 0; i < g.getSpaces().length; i++){
            for (int j = 0; j < g.getSpaces().length; j++){
                if (i!=j){
                    int a, b;
                    a = g.getSpace(i).getValue();
                    b = g.getSpace(j).getValue();
                    if (a>0 && b>0 && a == b)
                        return false;
                }
                
            }
        }
        return true;
    }
    
    
    private boolean someSpacesEmpty(Space s){
        
        Group g = s.getGroup();
        
        for (int i = 0; i < g.getSpaces().length; i++){
            Space es = g.getSpace(i);
            if (es.getValue() == 0)
                return true;
        }
        return false;
    }
    
    
    public boolean row(Space s){
        return false;
    }
    
    
    public boolean column(Space s){
        return false;
    }
    
}