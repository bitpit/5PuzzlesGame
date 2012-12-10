import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUIPage472Space extends JButton {
    
    private int x, y;
    private Space space;
    private int digit = 0;
    private Font f = new Font("Verdana",Font.PLAIN, 25);;
    private GUILettersMenu listen;
    private boolean special;
    private Font groupDisplay = new Font("Verdana",Font.PLAIN,12);
    private Color color;
    private String[] spacePossibilities;
    public String[] specialInfo;
    private ImageIcon arrow;
                      
    
    public GUIPage472Space(int x, int y, int dims, boolean special, String[] sP){
        super();
        
        this.special = special;
        this.x = x;
        this.y = y;
        spacePossibilities = sP;
        
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(dims,dims));
    }
    
  
    public GUIPage472Space(int x, int y, int dims, boolean special, String[] sP, int fullDim, boolean noBorder){
        this(x,y,dims,special,sP);
        if (noBorder){
            listen = null;
            setBorder(null);
        }
        
        if (x == 0){//left
            arrow = new ImageIcon("arrows/down.png");
        }
        else if (x == fullDim-1){//right
            arrow = new ImageIcon("arrows/up.png");
        }
        else if (y == 0){//top
            arrow = new ImageIcon("arrows/right.png");
        }
        else { //bottom
            arrow = new ImageIcon("arrows/left.png");
        }
        
        digit = fullDim;
    }
    
    
    public void paintComponent(Graphics g){
        if (space != null){
            digit = space.getValue();
            
            if (digit > 1){
                g.setColor(Color.black);
                g.setFont(f);
                g.drawString(spacePossibilities[digit-1],19,40);
            }
        }
        else if (specialInfo != null) {
            g.setColor(Color.black);
            g.setFont(groupDisplay);
            g.drawString(specialInfo[0]+" "+specialInfo[1],6,20);
            
            if (x == 0){//left
                arrow.paintIcon(this,g,32,10); 
            }
            else if (x == digit-1){//right
                arrow.paintIcon(this,g,30,4);
            }
            else if (y == 0){//top
                arrow.paintIcon(this,g,10,28);
            }
            else { //bottom
                arrow.paintIcon(this,g,4,28);
            }
        }
        
        repaint();
    }
    
    
    public void setSpace(Space s){
        space = s;
        digit = space.getValue();
        if (space.getValue()<1)
            listen = new GUILettersMenu(this,space);
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
    
    
    
}
