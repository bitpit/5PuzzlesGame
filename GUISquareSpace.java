import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISquareSpace extends JButton {
    
    private int x, y;
    private int digit = 0;
    private Space space;
    private JLabel lab;
    private Font f = new Font("Verdana",Font.PLAIN, 25);;
    boolean canBeChanged = true;
    private int dimensions;
    private GUINumbersMenu listen;
    private boolean special;
    private Color black = new Color(0,0,0);
    private Font groupDisplay = new Font("Verdana",Font.PLAIN,11);
                
    
    public GUISquareSpace(int x, int y, int dims, boolean special){
        super();
        
        this.special = special;
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
            g.setColor(new Color(218,218,218));
            g.fillRect(0,0,50,50);
        }
        
        if (digit>0){
            g.setColor(black);
            g.setFont(f);
            g.drawString(""+digit,17,40);
        }
        if (special){
            g.setColor(black);
            g.setFont(groupDisplay);
            Group group = space.getGroup();
            String op = group.getOp();
            if (op.equals("*"))
                op = "X";
            g.drawString(""+group.getTotal()+" "+op,3,12);
            
        }
    }
    
    
    public void setSpace(Space s){
        space = s;
        digit = s.getValue();
        if (digit>0)
            canBeChanged = false;
        else {
            listen = new GUINumbersMenu(this,space);
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
