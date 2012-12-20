import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class GUILettersMenu extends GUINumbersMenu implements ActionListener {
    
	private JButton myButton;
	JPopupMenu  menu;
    private GUILettersMenuListener listen;
        
	
    public GUILettersMenu(JButton clicker, Space s) {
        super();
		myButton = clicker;
		
        menu = new JPopupMenu("");
        
        listen = new GUILettersMenuListener(s);
        
        JMenuItem blank = new JMenuItem("");
        menu.add(blank);
        blank.addActionListener(listen);
        
        
        for (int i = 65; i < s.getPossibilities()+64; i++){
            char c = (char)i;
            JMenuItem item = new JMenuItem(String.valueOf(c));
            menu.add(item);
            item.addActionListener(listen);
        }
       
        
        clicker.addActionListener(this);
        
    }
    
    
	public void actionPerformed(ActionEvent e) {
		
		menu.show(myButton,myButton.getWidth()/2,myButton.getHeight()/2);
	}
    
    
}
