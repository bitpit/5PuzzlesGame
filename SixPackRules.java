public class SixPackRules implements Rule {

    
    private Game game;
    
    
    public SixPackRules(Game g){
        game = g;
    }
    
   
    public boolean shape(Space s){
        
        return false;
    }
    
    
    private boolean shapeR(Group g){
              
        
        int total = 0;
        
        for (int i = 0; i < g.getSpaces().length; i++){
            total += g.getSpace(i).getValue();
        }
        
        boolean spaces = someSpacesEmpty(g);
                
        if (spaces){
            if (total >= 25)
                return false;
            else
                return true;
        }
        else if (!spaces && total == 25)
            return true;
        return false;
    }

    
    public boolean constraints(Space s){
        Group[] group = getIGroups(s);
        for (int i = 0; i < group.length; i++){
            if (!(shapeR(group[i]) && shapeCharConflict(group[i]))) 
                return false;
        }
        return true;
    }
    
    
    public boolean allConstraints(){
        Group[] groups = game.getGroups();
        for (Group g : groups){
            if (!shapeR(g) ||
                !shapeCharConflict(g))
                return false;
        }
        return true;
    }
    
    
    private boolean shapeCharConflict(Group g){
        
        for (int i = 0; i < g.getSpaces().length; i++){
            for (int j = 0; j < g.getSpaces().length; j++){
                if (i!=j){
                    int a, b;
                    a = g.getSpace(i).getValue();
                    b = g.getSpace(j).getValue();
                    Space ay = g.getSpace(i);
                    Space bee = g.getSpace(j);
                    if (a>0 && b>0 && a == b)
                        return false;
                }
            }
            
        }
        
        return true;
    }
    
    
    private boolean someSpacesEmpty(Group g){
        
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
    
    
    private Group[] getIGroups(Space s){
        
        Group[] allGroups = game.getGroups();
        int counter = 0;
        for (Group g : allGroups){
            if (g.getSpacesList().contains(s))
                counter++;
        }
        Group[] retGroup = new Group[counter];
        counter = 0;
        for (Group g : allGroups){
            if (g.getSpacesList().contains(s)){
                retGroup[counter] = g;
                counter++;
            }
        }
        
        return retGroup;
    }
    
}