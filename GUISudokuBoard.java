import java.awt.*;
import javax.swing.*;
import java.awt.event.* ;

public class GUISudokuBoard extends JPanel implements ActionListener {

//150 size for individual squares
    private Game g;
    private JPanel[][] spaces;
    private GUISquareSpace space;
    private int dim;
    
    public GUISudokuBoard(int dim){
        
        setLayout(new GridLayout(dim/3,dim/3));
        spaces = new JPanel[dim/3][dim/3];
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < spaces.length; i++){
            for (int j = 0; j < spaces[i].length; j++){
                
                JPanel p = new JPanel(new GridLayout(dim/3,dim/3));
                p.setBorder(BorderFactory.createLineBorder(Color.black));
                for (int k = 0; k < dim; k++){
                    p.add(new GUISquareSpace(x%dim,y%dim,50));
                    x+=1;
                    y+=1;
                }
                p.setPreferredSize(new Dimension(dim*3,dim*3));
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