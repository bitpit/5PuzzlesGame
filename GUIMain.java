import java.awt.*;
import javax.swing.*;
import java.awt.event.* ;

public class GUIMain extends JFrame implements ActionListener {
    
    private JButton soduku2;
    private JButton soduku1;
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
        
        soduku1 = new JButton("Sudoku #1");
        soduku2 = new JButton("Sudoku #2");
        soduku1.addActionListener(this);
        soduku2.addActionListener(this);

        contentPane.add(title);
        contentPane.add(Box.createRigidArea(new Dimension(40, 0)));
        contentPane.add(soduku1,BorderLayout.CENTER);
        contentPane.add(soduku2,BorderLayout.CENTER);
    }
    
    
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if (source == soduku1 || source == soduku2){
            sod = new GUISudoku();
            sod.parentHandoff(this);
            sod.init();
            sod.pack();
            sod.setSize(new Dimension(600,600));
            if (source == soduku1)
                sod.setGame("boards/Soduku1");
            else if (source == soduku2)
                sod.setGame("boards/Soduku2");
            sod.setVisible(true);
        }
    }

}


