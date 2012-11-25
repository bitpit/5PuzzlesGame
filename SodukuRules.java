public class SodukuRules implements Rule {
    
    private Game soduku;
    
    public SodukuRules(Game g){
        soduku = g;
    }
    

    public boolean row(Space s){
        
        int y = s.getY();
        
        for (int i = 0; i<9; i++){
            if (soduku.getSpaceAt(i,y).getValue() == s.getValue()){
                if (i != s.getX())
                    return false;
            }
        }
        
        return true;
        
    }
    
    
    public boolean column(Space s){
        
        int x = s.getX();
                
        for (int i = 0; i < 9; i++){
            if (soduku.getSpaceAt(x,i).getValue() == s.getValue()){
                if (i != s.getY())
                    return false;
            }
        }
                
        return true;
    }
    
    
    public boolean shape(Space s){
        
        int x = (s.getX()/3)*3;
        int y = (s.getY()/3)*3;
        
        for (int i = x; i < x+3; i++){
            for (int j = y; j<y+3; j++)
                if (i!=s.getX() && j!=s.getY() && (soduku.getSpaceAt(i,j).getValue() == s.getValue())){
                    return false;
                }
        }
                
        
        return true;
    }
    
    
    public boolean constraints(Space s){
        
        if (shape(s) && row(s) && column(s))
            return true;
        return false;
    }
    
    
    public boolean allConstraints(){
        
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                if (!shape(soduku.getSpaceAt((i*3),(j*3))))
                    return false;
            }
        }
        
        for (int i = 0; i<9; i++){
            if (!column(soduku.getSpaceAt(i,0)))
                return false;
            else if (!row(soduku.getSpaceAt(0,i)))
                return false;
        }
        
        
        return true;
    }

}