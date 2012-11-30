import javax.swing.*;
import java.awt.*;

public class GUISquareSpace extends JPanel {
    
    int digit; //the number it would display
    int x, y; //the x,y position on the grid
    
    GUISquareSpace(int x, int y, int dims) {
        super();
        
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
    
    
}
