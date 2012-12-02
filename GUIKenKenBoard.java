import java.awt.*;
import javax.swing.*;
import java.awt.event.* ;
import javax.swing.JFrame;

public class GUIKenKenBoard extends JPanel implements ActionListener {


    private Game g;
    private JPanel[][] spaces;
    private GUISquareSpace space;
    private int dim;
       
    
    public GUIKenKenBoard(int dim, Game game, JFrame frame){
                       
        setLayout(null);
        spaces = new JPanel[dim][dim];
             
        for (int i = 0; i < spaces.length; i++){
            for (int j = 0; j < spaces[i].length; j++){
                
                JPanel p = new JPanel(new GridLayout(dim/3,dim/3));
                p.setBorder(BorderFactory.createLineBorder(Color.black));
                for (int k = 0; k < dim/3; k++){
                    for (int l = 0; l < dim/3; l++){
                        GUISquareSpace spacey = new GUISquareSpace(((k+1)+(i*(dim/3)))-1,((l+1)+(j*(dim/3))-1),50);
                        int[] loc = spacey.getDims();
                        spacey.setSpace(game.getSpaceAt(loc[0],loc[1]));
                        p.add(spacey);
                    }
                }
                //p.setPreferredSize(new Dimension(dim*3,dim*3));
                spaces[i][j] = p;
                add(spaces[i][j]);
            }
        }
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    
    
    public void actionPerformed(ActionEvent e){
        System.out.println("nothing");
    }
    
    
    public void removeListeners(){
        
        for (JPanel[] panel : spaces){
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