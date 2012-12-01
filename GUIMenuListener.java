import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.NumberFormatException;
import javax.swing.JFrame;


public class GUIMenuListener implements ActionListener {
    
    Space space;
    JFrame board;
    
    public GUIMenuListener(Space s){
        space = s;
    }
    
    
    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();
        
        int i;
        
        try {
            i = Integer.parseInt(action);
        }
        catch (NumberFormatException excep){
            i = 0;
        }
        space.setValue(i);
    }
}