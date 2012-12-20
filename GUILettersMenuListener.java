import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.NumberFormatException;


public class GUILettersMenuListener implements ActionListener {
    
    private Space space;
    
    
    public GUILettersMenuListener(Space s){
        space = s;
    }
    
    
    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();
    
        if (action.equals("")){
            space.setValue(0);
        }
        else {
            for (int i = 65; i < space.getPossibilities()+64; i++){
                char c = (char)i;
                if (action.equals(String.valueOf(c)))
                    space.setValue(i-63);
            }
        }

    }
}