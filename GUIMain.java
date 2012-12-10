import java.awt.*;
import javax.swing.*;
import java.awt.event.* ;

public class GUIMain extends JFrame implements ActionListener {
    
    private JButton page472;
    private JButton kenken6x6;
    private JButton kenken4x4;
    private JButton kenken3;
    private JButton soduku2;
    private JButton soduku1;
    private GUIGame sod;

	
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
        kenken4x4 = new JButton("KenKen 4x4");
        kenken6x6 = new JButton("KenKen 6x6");
        kenken3 = new JButton("Kenken 9x9");
        soduku1.addActionListener(this);
        soduku2.addActionListener(this);
        kenken4x4.addActionListener(this);
        kenken6x6.addActionListener(this);
        kenken3.addActionListener(this);
        
        page472 = new JButton("Page 472");
        page472.addActionListener(this);

        contentPane.add(title);
        contentPane.add(Box.createRigidArea(new Dimension(40, 0)));
        contentPane.add(soduku1,BorderLayout.CENTER);
        contentPane.add(soduku2,BorderLayout.CENTER);
        contentPane.add(kenken4x4,BorderLayout.CENTER);
        contentPane.add(kenken6x6,BorderLayout.CENTER);
        contentPane.add(kenken3,BorderLayout.CENTER);
        contentPane.add(page472,BorderLayout.CENTER);
    }
    
    
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if (source == soduku1 || source == soduku2){
            sod = new GUIGame();
            if (source == soduku1)
                sod.init(new Soduku("boards/Soduku1"));
            else if (source == soduku2)
                sod.init(new Soduku("boards/Soduku2"));
            sod.pack();
            sod.setSize(new Dimension(600,600));
            sod.setVisible(true);
        }
        else if (source == kenken4x4 || source == kenken6x6 || source == kenken3){
            Game g;
            sod = new GUIKenKen();
            if (source == kenken4x4){
                g = new KenKen("boards/kenken1");
                sod.init(g);
            }
            else if (source == kenken3){
                g = new KenKen("boards/kenken3");
                sod.init(g);
            }
            else {
                g = new KenKen("boards/kenken2");
                sod.init(g);
            }
            sod.pack();
            int size = g.getDimensions()[0]*50;
            sod.setSize(new Dimension(size+150,size+150));
            sod.setVisible(true);
        }
        else if (source == page472){
            sod = new GUIPage472();
            Game g = new Page472("boards/page1");
            sod.init(g);
            sod.pack();
            int size = g.getDimensions()[0]*50;
            sod.setSize(new Dimension(size+250,size+250));
            sod.setVisible(true);
        }
    }

}


