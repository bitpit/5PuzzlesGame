import java.awt.*;
import javax.swing.*;
import java.awt.event.* ;
import javax.swing.JFrame;
import java.util.ArrayList;

public class GUIPage472Board extends JPanel {


    private Game game;
    private JButton[][] spaces;
    private GUIPage472Space space;
    private int dim;
    private int spaceSize = 50;
    private String[] spacePossibilities = {"Z","A","B","C","D"};
           
    
    public GUIPage472Board(Game game){
                       
        this.game = game;
        dim = game.getDimensions()[0];
        
        setLayout(new GridLayout(dim+2,dim+2));
        spaces = new JButton[dim+2][dim+2];
        
        Color col = new Color(0,0,0,0);
        Color black = new Color(155,155,0);
             
        for (int i = 0; i < spaces.length; i++){
            for (int j = 0; j < spaces[i].length; j++){
                
                GUIPage472Space spacey;
                
                if (i == 0 || j == 0 || i == spaces.length-1 || j == spaces.length-1){
                    spacey = new GUIPage472Space(i,j,spaceSize,true, spacePossibilities, spaces.length, true);
                }
                else{
                    spacey = new GUIPage472Space(i,j,spaceSize,false, spacePossibilities);
                }
                
                int[] loc = spacey.getDims();
                
                if (i > 0 && i < spaces.length-1 && j > 0 &&
                      j < spaces.length-1)
                    spacey.setSpace(game.getSpaceAt(loc[0]-1,loc[1]-1));
                
                spacey.setColor(col);
                spaces[i][j] = spacey;
                add(spacey);
                
            }
        }
        setPreferredSize(new Dimension(spaceSize*spaces.length,spaceSize*spaces.length));
        setMaximumSize(new Dimension(spaceSize*spaces.length,spaceSize*spaces[0].length));
        
        
    }
        
   
    public void removeListeners(){
        
        for (JButton[] panel : spaces){
            for (int i = 0; i < panel.length; i++){
                Component[] camps = panel[i].getComponents();
                Component comp = null;
                for (int j = 0; j < camps.length; j++){
                    comp = camps[j];
                    if (comp instanceof JButton){
                        JButton jb = (JButton)(camps[j]);
                        ActionListener[] lastnrs = jb.getActionListeners();
                        for (int k = 0; k < lastnrs.length; k++){
                            jb.removeActionListener(lastnrs[k]);
                        }
                    }
                }
            }
        }
    }
    
    
    public void setUpGroups(){
        Group[] groups = game.getGroups();//first half is column stuff, second half is row stuff
        Group current;
        
        GUIPage472Space crammy;
        
        for (int i = 0; i < groups.length/2; i++){//column
            current = groups[i];
            if (current.getLeft()[0] != null){
                crammy = (GUIPage472Space)(spaces[0][i+1]);
                crammy.specialInfo = current.getLeft();
            }
            if (current.getRight()[0] != null){
                crammy = (GUIPage472Space)(spaces[spaces.length-1][i+1]);
                crammy.specialInfo = current.getRight();
            }
        }
        
        int mod = groups.length/2;
        
        for (int i = groups.length/2; i < groups.length; i++){
            current = groups[i];
            if (current.getLeft()[0] != null){
                crammy = (GUIPage472Space)(spaces[(i%mod)+1][0]);
                crammy.specialInfo = current.getLeft();
            }
            if (current.getRight()[0] != null){
                crammy = (GUIPage472Space)(spaces[(i%mod)+1][spaces.length-1]);
                crammy.specialInfo = current.getRight();
            }
        }
    }
    
    
    public void convertForCheck(boolean toOne){
        for (int i = 0; i < game.getDimensions()[0]; i++){
            for (int j = 0; j < game.getDimensions()[1]; j++){
                Space s = game.getSpaceAt(i,j);
                if (toOne){
                    if (s.getValue() == 0)
                        s.setValue(1);
                }
                else {
                    if (s.getValue() == 1)
                        s.setValue(0);
                }
            }
        }
    }
    
}