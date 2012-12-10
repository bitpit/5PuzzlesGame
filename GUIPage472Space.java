import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIPage472Space extends JButton {
    
    private int x, y;
    private Space space;
    private int digit = 0;
    private Font f = new Font("Verdana",Font.PLAIN, 25);;
    boolean canBeChanged = true;
    private int dimensions;
    private GUILettersMenu listen;
    private boolean special;
    private Font groupDisplay = new Font("Verdana",Font.PLAIN,11);
    private Color color;
    private String[] spacePossibilities = {"Z","A","B","C","D"};
                    
    
    public GUIPage472Space(int x, int y, int dims, boolean special){
        super();
        
        this.special = special;
        dimensions = dims;
        this.x = x;
        this.y = y;
        
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(dims,dims));
    }
    
  
    public GUIPage472Space(int x, int y, int dims, boolean special, boolean noBorder){
        this(x,y,dims,special);
        if (noBorder){
            listen = null;
            setBorder(null);
        }
    }
    
    
    public void paintComponent(Graphics g){
        if (space != null){
            digit = space.getValue();
            
            System.out.println(digit);
            if (digit > 0){
                g.setColor(Color.black);
                g.setFont(f);
                g.drawString(spacePossibilities[digit-1],17,40);
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
