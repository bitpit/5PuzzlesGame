import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.NumberFormatException;


public class GUILettersMenuListener implements ActionListener {
    
    private Space space;
    private boolean forLogi;
    
    
    public GUILettersMenuListener(Space s){
        space = s;
    }
    
    public GUILettersMenuListener(Space s, boolean logi){
        space = s;
        forLogi = true;
    }
    
    
    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();
    
        if (action.equals("")){
            space.setValue(0);
        }
        else {
            if (!forLogi){
                for (int i = 65; i < space.getPossibilities()+64; i++){
                    char c = (char)i;
                    if (action.equals(String.valueOf(c)))
                        space.setValue(i-63);
                }
            }
            else {
                for (int i = 65; i < space.getPossibilities()+65; i++){
                    char c = (char)i;
                    if (action.equals(String.valueOf(c)))
                        space.setValue(i-64);
                }
            }
        }

    }
}