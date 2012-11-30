import java.awt.*;
import javax.swing.*;
import java.awt.event.* ;

public class Puzzles extends JFrame implements ActionListener {
    
    private JButton soduku;

	public void init() {

		Container contentPane = this.getContentPane();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlowLayout lay = new FlowLayout();
        lay.setAlignment(FlowLayout.CENTER);
        lay.setHgap(20);
		//contentPane.setLayout(lay);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        //contentPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		

		JLabel title = new JLabel("Puzzles");
		title.setFont(new Font("Verdana",Font.PLAIN,42));
        
        JLabel blank = new JLabel("  ");
        blank.setFont(new Font("Verdana",Font.PLAIN,56));
        
        soduku = new JButton("Sudoku");
        soduku.addActionListener(this);

        contentPane.add(Box.createRigidArea(new Dimension(40, 120)));
        contentPane.add(Box.createRigidArea(new Dimension(40, 0)));
		contentPane.add(title);
        //contentPane.add(blank);
        contentPane.add(Box.createRigidArea(new Dimension(0, 120)));
        contentPane.add(Box.createRigidArea(new Dimension(40, 0)));
        contentPane.add(soduku,BorderLayout.CENTER);
		
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
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == soduku)
            System.out.println("sudoku");
        else
            System.out.println("something happaned");
    }

}


