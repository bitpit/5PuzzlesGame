import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISixPackSpace extends JButton {
    
    private int x, y;
    private int digit = 0;
    private Space space;
    private Font f = new Font("Verdana",Font.PLAIN, 20);;
    private GUINumbersMenu listen;
    private Color black = new Color(0,0,0);
    private Font groupDisplay = new Font("Verdana",Font.PLAIN,11);
    private Color color;
    private Polygon triangle;
                    
    
    public GUISixPackSpace(int x, int y, Space s){
        super();
        
        this.x = x;
        this.y = y;
        this.space = s;
        
        if (s.getValue() == 0)
            listen = new GUINumbersMenu(this,s);
        
        setPreferredSize(new Dimension(50,50));
    }
    
    
    public int getDigit() { 
        return digit; 
    }
    
    
    public void setDigit(int num) { 
        digit = num; 
    }
    
    
    public void paintComponent(Graphics g){
   
        if (triangle == null){
            
            int[] xEs, yEs;
            xEs = new int[4];
            yEs = new int[4];
            
            int width = this.getWidth();
            int height = this.getHeight()-1;
            
            if ((x > 3 && ((y+1)%2 == 0) ||
                 (x <= 3 && ((y+1)%2 == 1)))){
                
                xEs[0] = width/2;
                yEs[0] = 0;
                
                xEs[1] = width;
                yEs[1] = height;
                
                xEs[2] = 0;
                yEs[2] = height;
                
                xEs[3] = width/2;
                yEs[3] = 0;
            }
            
            else {
                
                xEs[0] = width/2;
                yEs[0] = height;
                
                xEs[1] = 0;
                yEs[1] = 0;
                
                xEs[2] = width;
                yEs[2] = 0;
                
                xEs[3] = width/2;
                yEs[3] = height;
            
            }
            
            triangle = new Polygon(xEs,yEs,4);
        }
        
        g.setColor(Color.white);
        g.fillPolygon(triangle);
        g.setColor(Color.black);
        g.drawPolygon(triangle);
        
        digit = space.getValue();
        if (digit > 0){
            g.setFont(f);
            if ((x > 3 && ((y+1)%2 == 0) ||
                 (x <= 3 && ((y+1)%2 == 1))))
                g.drawString(""+digit,19,41);
            else
                g.drawString(""+digit,19,32);
        }
    }
    

}
