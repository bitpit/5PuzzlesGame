import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.NumberFormatException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GUIMenuListener implements ActionListener {
    
    private Space space;
    private JFrame top;
    
    public GUIMenuListener(Space s, JFrame frame){
        space = s;
        top = frame;
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