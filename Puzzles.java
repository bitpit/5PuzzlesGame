import java.awt.*;
import javax.swing.*;


public class Puzzles extends JFrame {

	public void init() {

		Container contentPane = this.getContentPane();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane.setLayout(new FlowLayout());

		

		JLabel title = new JLabel("Puzzles");
		title.setFont(new Font("Verdana",Font.PLAIN,42));

		contentPane.add(title);
		
		/*
		Font labelFont = label11.getFont();
		String labelText = label11.getText();
		
		int stringWidth = label11.getFontMetrics(labelFont)
		    .stringWidth(labelText);
		
		int componentWidth = label11.getWidth();
		
		// Find out how much the font can grow in width.
		double widthRatio = (double)componentWidth / (double)stringWidth;
		
		int newFontSize = (int)(labelFont.getSize() * widthRatio);
		int componentHeight = label11.getHeight();
		
		// Pick a new font size so it will not be larger than the height of label.
		int fontSizeToUse = Math.min(newFontSize, componentHeight);
		
		// Set the label's font size to the newly determined size.
		label11.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
		contentPane.add(label11);
		
		//

		JTextField timeField = new JTextField(20);
		contentPane.add(timeField);

		JButton jb = new JButton("update time");
		this.getContentPane().add(jb);

		ClockPanel cp = new ClockPanel(timeField);
		contentPane.add(cp);
		jb.addActionListener(cp);

		ClockAnimateThread cat = new ClockAnimateThread(cp,3000);
		cat.run();
		*/
	}

}


