import java.awt.*;
import javax.swing.*;
import java.awt.event.* ;

public class Puzzles extends JFrame implements ActionListener {
    
    private JButton soduku;
    private GUISudoku sod;

	public void init() {

		Container contentPane = this.getContentPane();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        FlowLayout lay = new FlowLayout();
        lay.setAlignment(FlowLayout.CENTER);
        lay.setHgap(20);
		
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
       
        JPanel space = new JPanel(null);
        space.setSize(new Dimension(20,20));
        

		JLabel title = new JLabel("Puzzles");
		title.setFont(new Font("Verdana",Font.PLAIN,42));
        
        JLabel blank = new JLabel("  ");
        blank.setFont(new Font("Verdana",Font.PLAIN,56));
        
        soduku = new JButton("Sudoku");
        soduku.addActionListener(this);

        contentPane.add(title);
        contentPane.add(Box.createRigidArea(new Dimension(40, 0)));
        contentPane.add(soduku,BorderLayout.CENTER);
    }
    
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == soduku){
            sod = new GUISudoku();
            sod.parentHandoff(this);
            sod.init();
            sod.pack();
            sod.setSize(new Dimension(600,600));
            sod.setVisible(true);
        }
        else
            System.out.println("something happaned");
    }

}


