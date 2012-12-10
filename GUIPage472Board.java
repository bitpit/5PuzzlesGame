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
    private Group[] groups;

       
    
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
                    spacey = new GUIPage472Space(i,j,spaceSize,false,true);
                }
                else{
                    spacey = new GUIPage472Space(i,j,spaceSize,false);
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
    
    
}