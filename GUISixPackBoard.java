import java.awt.*;
import javax.swing.*;
import java.awt.event.* ;
import javax.swing.JFrame;

public class GUISixPackBoard extends JPanel {


    private Game g;
    private JPanel[][] spaces;
    private int dim;
        
    
    public GUISixPackBoard(Game game){
        
        this.setLayout(new GridLayout(8,9));
        
        int x,y;
        x = 0;
        y = 0;
        
        GUISixPackSpace fuk;
        
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 9; j++){
                if (((i == 0 || i == 7) && (j > 2 && j < 6)) ||
                    ((i == 1 || i == 6) && (j > 1 && j < 7)) ||
                    (( i == 2 || i == 5) && (j > 0 && j< 8)) ||
                    (( i == 3 || i == 4))){
                    fuk = new GUISixPackSpace(x,y,game.getSpaceAt(x,y));
                    this.add(fuk);
                    y++;
                }
                    
                else {
                    JPanel pane = new JPanel();
                    pane.setBackground(Color.white);
                    this.add(pane);
                }
            }
            x++;
            y = 0;
        }
        
        this.setPreferredSize(new Dimension(50*9,50*9+50));
                        
    }
   
    
    public void paintComponent(Graphics g){
        
        g.setColor(Color.white);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        
        g.setColor(Color.black);
        
        int y;
        
        y = 57;
        
        for (int i = 0; i < 7; i++){
            g.fillOval(220,y,11,11);
            y += 62;
        }
        
        y = 119;
        
        for (int i = 0; i < 5; i++){
            g.fillOval(170,y,11,11);
            g.fillOval(270,y,11,11);
            y += 62;
            
        }
        
        y = 181;
        
        for (int i = 0; i < 3; i++){
            g.fillOval(120,y,11,11);
            g.fillOval(320,y,11,11);
            y += 62;
        }
        
        g.fillOval(70,243,11,11);
        g.fillOval(370,243,11,11);
        
        
        repaint();
    }
    
}