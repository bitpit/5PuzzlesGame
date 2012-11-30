import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame {



	public static void main(String[] args) {

	    GUIMain thisOne = new GUIMain();
		thisOne.init();
		
		thisOne.pack();
		thisOne.setVisible(true);
		thisOne.setSize(new Dimension(300,300));
	}
}
