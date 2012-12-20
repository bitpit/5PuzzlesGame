import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUILogi5Space extends JButton {
    
    private int x, y;
    private int digit = 0;
    private Space space;
    private Font f = new Font("Verdana",Font.PLAIN, 25);;
    private int dimensions;
    private GUILettersMenu listen;
    private Color color;
                    
    
    public GUILogi5Space(int x, int y, int dims){
        super();
        
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
        
        Group group;
        if (space != null){
            digit = space.getValue();
            group = space.getGroup();
        }
        else
            group = null;
        
        if (group != null){
            g.setColor(color);
            g.fillRect(0,0,50,50);
        }

        
        if (digit>0){
            char c = (char)(digit+64);
            g.setColor(Color.black);
            g.setFont(f);
            g.drawString(String.valueOf(c),17,40);
            //g.drawString(""+digit,17,40);
        }
        repaint();
    }
    
    
    public void setSpace(Space s){
        space = s;
        digit = s.getValue();
        if (digit<1)
            listen = new GUILettersMenu(this,space,true);
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
    
    
    public void setColor(Color c){
        this.color = c;
    }
    
    
    public Color getColor(){
        return color;
    }
    
    
}
