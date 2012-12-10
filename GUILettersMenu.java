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
        
        //JMenuItem zee = new JMenuItem("Z");
        JMenuItem ay = new JMenuItem("A");
        JMenuItem be = new JMenuItem("B");
        JMenuItem see = new JMenuItem("C");
        JMenuItem dee = new JMenuItem("D");
        
//        menu.add(zee);
  //      zee.addActionListener(listen);
        menu.add(ay);
        ay.addActionListener(listen);
        menu.add(be);
        be.addActionListener(listen);
        menu.add(see);
        see.addActionListener(listen);
        menu.add(dee);
        dee.addActionListener(listen);
        
        clicker.addActionListener(this);
        
    }
    
    
	public void actionPerformed(ActionEvent e) {
		
		menu.show(myButton,myButton.getWidth()/2,myButton.getHeight()/2);
	}
    
    
}
