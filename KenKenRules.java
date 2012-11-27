public class KenKenRules implements Rule {
    
    private Game kenken;
    
    public KenKenRules(Game g){
        kenken = g;
    }
    

    public boolean row(Space s){
        
        return true;
        
    }
    
    
    public boolean column(Space s){
        
        return true;
    }
    
    
    public boolean shape(Space s){
        
        Group g = s.getGroup();
        String op = g.getOp();
        Space[] spaces = g.getSpaces();
        
        int cumulative = spaces[1].getValue();
                
        System.out.println(op);
        System.out.println(spaces.length);
        System.out.println(spaces[0].getValue()+" * "+spaces[1].getValue());
        
        if (op.equals("*")){
            for (int i = 1; i<spaces.length;i++){
                int n = spaces[i].getValue();
                cumulative*=spaces[i].getValue();
                
            }
        }
        else if (op.equals("+")){
            for (Space q : g.getSpaces()){
                int n = q.getValue();
                n+=cumulative;
            }
        }
        
        else if (op.equals("-")){
            for (Space q : g.getSpaces()){
                int n = q.getValue();
                n-=cumulative;
            }
        }
        else if (op.equals("/")){
            for (Space q : g.getSpaces()){
                if (q.getValue()!=0){
                    int n = q.getValue();
                    n/=cumulative;
                }
            }
        }
        else cumulative = 1;
        
        System.out.println("cumulative "+cumulative+" @ ("+s.getX()+", "+s.getY()+")");
        
        if (cumulative == g.getTotal())
            return true;
        else
            return false;
    }
    
    
    public boolean constraints(Space s){
        
        if (shape(s))
            return true;
        return false;
    }
    
    
    public boolean allConstraints(){
        
        Group[] g = kenken.getGroup();
        
        for (int i = 0; i < g.length; i++){
            if (!shape(g[i].getSpace(0)))
                return false;
        }
        
        return true;
    }

}