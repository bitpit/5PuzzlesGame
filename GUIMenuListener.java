import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.NumberFormatException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GUIMenuListener implements ActionListener {
    
    private Space space;
    private Solver saul;
    private JFrame top;
    
    public GUIMenuListener(Space s, Solver sol, JFrame frame){
        space = s;
        saul = sol;
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
        if (saul.game.finished()){
            if (saul.rules.allConstraints())
                JOptionPane.showMessageDialog(top,
                                              "You Won!",
                                              "Congratulations!",
                                              JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(top,
                                              "You Lost. Try again!",
                                              "Sorry...",
                                              JOptionPane.ERROR_MESSAGE);
            top.setVisible(false);
        }
    }
}