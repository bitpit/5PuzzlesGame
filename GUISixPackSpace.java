import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISixPackSpace extends JButton implements ActionListener {
    
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
        
        this.addActionListener(this);
        
        //setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(50,50));
    }
    
    
    public int getDigit() { 
        return digit; 
    }
    
    
    public void setDigit(int num) { 
        digit = num; 
    }
    
    
    public void paintComponent(Graphics g){
        
        g.setColor(Color.black);
        
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
    
    
    public void actionPerformed(ActionEvent e){
        System.out.println(x+", "+y);
    }
    
}
