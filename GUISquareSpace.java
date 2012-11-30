import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISquareSpace extends JButton implements ActionListener {
    
    int digit; //the number it would display
    int x, y; //the x,y position on the grid
    JLabel lab;
    Font f;
    
    GUISquareSpace(int x, int y, int dims) {
        super();
        
        this.x = x;
        this.y = y;
        
        f = new Font("Verdana",Font.PLAIN, 25);
        digit = 0;
        
        this.addActionListener(this);
        
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(dims,dims));
    }
    
    
    public int getDigit() { 
        return digit; 
    }
    
    
    public void setDigit(int num) { 
        digit = num; 
    }
    
    
    public void paintComponent(Graphics g){
        if (digit>0){
            g.setFont(f);
            g.drawString(""+digit,15,30);
        }
    }
    
    
    public void actionPerformed(ActionEvent e){
        System.out.println(x+", "+y);
    }
}
