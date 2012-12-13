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
        else {/*if (action.equals("Z")){
            space.setValue(1);
        }
        else if (action.equals("A")){
            space.setValue(2);
        }
        else if (action.equals("B")){
            space.setValue(3);
        }
        else if (action.equals("C")){
            space.setValue(4);
        }
        else{
            space.setValue(5);
        }*/
            for (int i = 65; i < space.getPossibilities()+64; i++){
                char c = (char)i;
                if (action.equals(String.valueOf(c)))
                    space.setValue(i-63);
            }
        }

    }
}