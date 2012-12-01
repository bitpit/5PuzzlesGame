import java.awt.*;
import javax.swing.*;
import java.awt.event.* ;

public class GUISudokuBoard extends JPanel implements ActionListener {


    private Game g;
    private JPanel[][] spaces;
    private GUISquareSpace space;
    private int dim;
    private Game game;
    
    
    public GUISudokuBoard(int dim, Game g){
        game = g;
                
        setLayout(new GridLayout(dim/3,dim/3));
        spaces = new JPanel[dim/3][dim/3];
             
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

}