import java.util.HashMap;
public class Page472Rules implements Rule  {
    
    private Game game;
    private int dimensions;
    private String[] keys = {"-","0","A","B","C","D"};
    private HashMap<String, Integer> doors;

    
    public Page472Rules(Game g){
        game = g;
        dimensions = g.getDimensions()[0];
        doors = new HashMap<String, Integer>();
        for (int i = 2; i < keys.length; i++){
            doors.put(keys[i],i);
        }
    }
    

    public boolean row(Space s){
        
        int tracky1 = 0;
        int y = s.getY();
        
        for (int i = 0; i<dimensions; i++){
            Space q = game.getSpaceAt(i,y);
            if (q.getValue() == s.getValue() && (q.getValue() > 1)){
                if (i != s.getX())
                    return false;
            }
            else if (q.getValue() > 0 && q.getValue() < 2)
                tracky1++;
        }
        
        if (tracky1>dimensions/3)
            return false;
        return true;
        
    }
    
    
    public boolean column(Space s){
        
        int tracky1 = 0;
        int x = s.getX();
        
        int[] tracker = new int[dimensions];
        
        for (int i = 0; i < dimensions; i++){
            Space q = game.getSpaceAt(x,i);
            /*for (int j : tracker){
                if (j == q.getValue() && j > 1)
                    return false;
                tracker[i] = q.getValue();
            }*/
            if (q.getValue() == s.getValue() && (q.getValue() > 1)){
                if (i != s.getY())
                    return false;
            }
            else if (q.getValue() > 0 && q.getValue() < 2)
                tracky1++;
        }
        if (tracky1>dimensions/3)
            return false;
        
        return true;
    }
    
    
    public boolean rowShape(Space s){
                
        Group row = s.getRow();
        String[] right = row.getRight();
        String[] left = row.getLeft();
        
        if (left[0] == null && right[0] != null){//only track from right
            if (totalShapeChecker(row, right, s, true, false))
                return true;
        }
        
        else if (left[0] != null && right[0]==null){//only track from left
            if (totalShapeChecker(row,left, s, false, false))
                return true;
        }
        else {  //track from both
            if (totalShapeChecker(row,left,s,false,false) &&
                (totalShapeChecker(row, right, s, true, false))){
                return true;
            }
                
        }
        return false;
    }
    
    
    public boolean columnShape(Space s){
       
        
        Group column = s.getColumn();
        String[] bottom = column.getRight();
        String[] top = column.getLeft();
        
        if (top[0] != null && bottom[0] == null){//only track from right
            if (totalShapeChecker(column, top, s, false, true))
                return true;
        }
        
        else if (top[0] == null && bottom[0]!=null){//only track from left
            if (totalShapeChecker(column,bottom, s, true, true))
                return true;
        }
        else {//track from both
            if (totalShapeChecker(column, top, s, false, true) &&
                (totalShapeChecker(column,bottom, s, true, true)))
                return true;
        }
        
        return false;
    }
    
    
    private boolean totalShapeChecker(Group group, String[] rulez, 
                                      Space s, boolean fromBottom, boolean column){
        
        if (rulez[1] != null){
            int rulezInt = Integer.parseInt(rulez[1]);
            int letterCount = countLetters(column, s);
            
            if (fromBottom){//starting from right or from bottom
                if (letterCount < 4){
                    return true;
                }
                else if (letterCount == 4){
                    Space q;
                    q = getNthLetter(rulezInt, s, column, fromBottom);
                    if (keys[q.getValue()].equals(rulez[0]))
                        return true;
                }
            }
            
            else {//starting from left or from top
                for (int i = 0; i < game.getDimensions()[0]; i++){
                    if (countLetters(column,s) >= rulezInt){
                        Space q;
                        q = getNthLetter(rulezInt, s, column, fromBottom);
                        if (keys[q.getValue()].equals(rulez[0]))
                            return true;
                    }
                    else if (countLetters(column,s) < rulezInt)
                        return true;
                }
            }
            return false;
        }
        return true;
    }
    
    
    
    
    private Space getNthLetter(int n, Space s, boolean column, boolean fromBottom){
        int tracky = 0;
        Space q;
     
        if (!fromBottom){
            for (int i = 0; i < game.getDimensions()[0]; i++){
                if (!column)
                    q = game.getSpaceAt(s.getX(),i);
                else
                    q = game.getSpaceAt(i,s.getY());
                if (q.getValue() >= 2)
                    tracky++;
                if (tracky == n)
                    return q;
            }
        }
        else {
            for (int i = game.getDimensions()[0]-1; i > -1; i --){
                if (!column)
                    q = game.getSpaceAt(s.getX(),i);
                else
                    q = game.getSpaceAt(i,s.getY());
                if (q.getValue() >= 2)
                    tracky++;
                if (tracky == n)
                    return q;
            }
        }
        return null;
    }
    
    
    private int countLetters(boolean column, Space s){
        int numbero = 0;
        for (int i = game.getDimensions()[0]-1; i > -1; i --){
            Space q;
            if (!column)
                q = game.getSpaceAt(s.getX(),i);
            else
                q = game.getSpaceAt(i,s.getY());
            if (q.getValue() >= 2)
                numbero++;
        }       
        return numbero;
    }
    
    
    public boolean shape(Space s){
        if (columnShape(s) && rowShape(s))
            return true;
        return false;
    }
        
    
    public boolean constraints(Space s){
        
        if (row(s) && column(s) && shape(s))
            return true;
        return false;
    }        
    
    
    public boolean allConstraints(){
        
        Group[] g = game.getGroups();
        
        for (int i = 0; i < g.length; i++){
            if (!shape(g[i].getSpace(0)))
                return false;
        }
        
        return true;
    }
    
    
}