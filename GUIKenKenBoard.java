import java.awt.*;
import javax.swing.*;
import java.awt.event.* ;
import javax.swing.JFrame;

public class GUIKenKenBoard extends JPanel implements ActionListener {


    private Game g;
    private JButton[][] spaces;
    private GUISquareSpace space;
    private int dim;
    private int spaceSize = 50;
       
    
    public GUIKenKenBoard(Game game){
                       
        dim = game.getDimensions()[0];
        
        setLayout(new GridLayout(dim,dim));
        spaces = new JButton[dim][dim];
        
             
        for (int i = 0; i < spaces.length; i++){
            for (int j = 0; j < spaces[i].length; j++){
                
                boolean special;
                Space otherSpace = game.getSpaceAt(i,j);
                if (otherSpace.getGroup().getSpace(0) == otherSpace)
                    special = true;
                else
                    special = false;
                
                GUISquareSpace spacey = new GUISquareSpace(i,j,spaceSize,special);
                int[] loc = spacey.getDims();
                spacey.setSpace(game.getSpaceAt(loc[0],loc[1]));
                spaces[i][j] = spacey;
                add(spacey);
                
            }
        }
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(spaceSize*spaces.length,spaceSize*spaces[0].length));
        setMaximumSize(new Dimension(spaceSize*spaces.length,spaceSize*spaces[0].length));
    }
    
    
    public void actionPerformed(ActionEvent e){
        System.out.println("nothing");
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
        //ActionListener[] listeners = 
        
    }
    
}