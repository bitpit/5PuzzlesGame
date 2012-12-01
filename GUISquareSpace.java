import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class GUISquareSpace extends JButton {
    
    private int x, y;
    private int digit = 0;
    private Space space;
    private JLabel lab;
    private Font f = new Font("Verdana",Font.PLAIN, 25);;
    boolean canBeChanged = true;
    private int dimensions;
    public Solver saul;
    private JFrame top;
    private GUINumbersMenu listen;
                
    
    public GUISquareSpace(int x, int y, int dims, Solver solv, JFrame frame) {
        super();
        
        top = frame;
        saul = solv;
        dimensions = dims;
        this.x = x;
        this.y = y;
        
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
        digit = space.getValue();
        
        if (!canBeChanged){
            g.setColor(new Color(222,222,222));
            g.fillRect(0,0,50,50);
        }
        
        if (digit>0){
            g.setColor(new Color(0,0,0));
            g.setFont(f);
            g.drawString(""+digit,15,30);
        }
    }
    
    
    public void setSpace(Space s){
        space = s;
        digit = s.getValue();
        if (digit>0)
            canBeChanged = false;
        else {
            listen = new GUINumbersMenu(this,space,saul,top);
        }
    }
    
    
    public Space getSpace(){
        return space;
    }
    
    
    public int[] getDims(){
        int[] ret = new int[2];
        ret[0] = this.x;
        ret[1] = this.y;
        return ret;
    }
    
    
}
