import java.awt.*;
import javax.swing.*;

public class Puzzles extends JFrame {



	public static void main(String[] args) {

	    GUIMain thisOne = new GUIMain();
		thisOne.init();
		
		thisOne.pack();
		thisOne.setVisible(true);
		thisOne.setSize(new Dimension(thisOne.getWidth()+13,thisOne.getHeight()+20));
	}
}
