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
        
        if (tracky1>2)
            return false;
        return true;
        
    }
    
    
    public boolean column(Space s){
        
        int tracky1 = 0;
        int x = s.getX();
        
        for (int i = 0; i < dimensions; i++){
            Space q = game.getSpaceAt(x,i);
            if (q.getValue() == s.getValue() && (q.getValue() > 1)){
                if (i != s.getY())
                    return false;
            }
            else if (q.getValue() > 0 && q.getValue() < 2)
                tracky1++;
        }
        if (tracky1>2)
            return false;
        
        return true;
    }
    
    
    private boolean rowShapeFromRight(Group row, String[] right, int trackFRight, Space s, boolean column){
        int tracker = 0;
        int pos = Integer.parseInt(right[1]);
        
        int blanksBefore = emptysCount(s, column, false);
        
        for (int i = trackFRight; i > -1; i--){
            Space q;
            if (!column)
                q = game.getSpaceAt(s.getX(),i);
            else
                q = game.getSpaceAt(i,s.getY());
            if (q.getValue() >= 2)
                tracker++;
            if (keys[q.getValue()].equalsIgnoreCase(right[0]) &&
                tracker != pos && blanksBefore < pos){
                return false;
            }
        }
        
        return true;
    }
    
     
    private boolean rowShapeFromLeft(Group row, String[] left, int trackFLeft, Space s, boolean column){
        
        int tracker = 0;
        int pos = Integer.parseInt(left[1]);
        
        int blanksBefore = emptysCount(s, column, true);
        
        for (int i = 0; i < dimensions; i++){
            Space q;
            if (!column)
                q = game.getSpaceAt(s.getX(),i);
            else
                q = game.getSpaceAt(i,s.getY());
            if (q.getValue() >= 2)
                tracker++;
            if (keys[q.getValue()].equalsIgnoreCase(left[0]) &&
                tracker == pos){
                return true;
            }
        }
        return false;
    }
    
    private int emptysCount(Space s, boolean column, boolean front){
        
        boolean firstLetter = false;
        int blanksBefore = 0;
        
        if (front){
            for (int i = 0; i < dimensions; i++){
                Space q;
                if (!column) 
                    q = game.getSpaceAt(s.getX(),i);
                else
                    q = game.getSpaceAt(i,s.getY());
                if (q.getValue() <= 1 && !firstLetter)
                    blanksBefore++;
                else if (q.getValue() > 1)
                    firstLetter = true;
            }
        }
        else
            for (int i = dimensions-1; i > -1; i--){
                Space q;
                if (!column) 
                    q = game.getSpaceAt(s.getX(),i);
                else
                    q = game.getSpaceAt(i,s.getY());
                if (q.getValue() <= 1 && !firstLetter)
                    blanksBefore++;
                else if (q.getValue() > 1)
                    firstLetter = true;
            }
        return blanksBefore;
    }
    
    
    public boolean rowShape(Space s){
                
        Group row = s.getRow();
        String[] right = row.getRight();
        String[] left = row.getLeft();
        
        int trackFLeft = 0;
        int trackFRight = dimensions-1;
        
        if (left[0] == null && right[0] != null){//only track from right
            if (rowShapeFromRight(row, right, trackFRight, s, false))
                return true;
        }
        
        else if (left[0] != null && right[0]==null){//only track from left
            if (rowShapeFromLeft(row,left,trackFLeft, s, false))
                return true;
        }
        else {  //track from both
            if (rowShapeFromLeft(row,left,trackFLeft,s,false) &&
                (rowShapeFromRight(row, right, trackFRight, s,false))){
                return true;
            }
                
        }
        return false;
    }
    
    
    public boolean columnShape(Space s){
       
        
        Group column = s.getColumn();
        String[] bottom = column.getRight();
        String[] top = column.getLeft();
        
        int trackFTop = 0;
        int trackFBottom = dimensions-1;
        
        if (top[0] != null && bottom[0] == null){//only track from right
            if (rowShapeFromLeft(column, top, trackFTop, s, true))
                return true;
        }
        
        else if (top[0] == null && bottom[0]!=null){//only track from left
            if (rowShapeFromRight(column,bottom,trackFBottom, s, true))
                return true;
        }
        else {//track from both
            if (rowShapeFromLeft(column, top, trackFTop, s, true) &&
                (rowShapeFromRight(column,bottom,trackFBottom, s, true)))
                return true;
        }
        
        return false;
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
    
    
    private boolean anyEmpty(Space s, boolean row){
        for (int i = 0; i < dimensions; i++){
            Space qbert;
            if (row)
                qbert = game.getSpaceAt(i,s.getY());
            else
                qbert = game.getSpaceAt(s.getX(),i);
            if (qbert.getValue() == 0)
                return true;
        }
        return false;
    }
    
    
    private boolean allEmpty(Space s, boolean row){
        for (int i = 0; i < dimensions; i++){
            Space qbert;
            if (row)
                qbert = game.getSpaceAt(i,s.getY());
            else
                qbert = game.getSpaceAt(s.getX(),i);
            if (qbert.getValue() != 0)
                return false;
        }
        return true;
    }

}