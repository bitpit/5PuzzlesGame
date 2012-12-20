import java.awt.*;
import javax.swing.*;
import java.awt.event.* ;

public class GUISixPack extends GUIGame implements ActionListener {
    
    private JButton back;
    private JButton solve;
    private JButton check;
    private JFrame parent;
    private GUISixPackBoard board;
    private Game game;
    private Solver solver;
    public boolean autoSolved = false;
        
    
    public void init(Game game) {

		Container contentPane = this.getContentPane();

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane.setLayout(new FlowLayout());
        
        this.game = game;
        
        		
        JLabel title = new JLabel(game.getName());
        title.setFont(new Font("Verdana",Font.PLAIN,18));
        
        board = new GUISixPackBoard(game);
        
        
        JPanel buttons = new JPanel(new FlowLayout());
        
        check = new JButton("Check Solution");
        check.setMinimumSize(new Dimension(45,30));
        check.addActionListener(this);
        back = new JButton("Exit Game");
        back.setMinimumSize(new Dimension(45,30));
        back.addActionListener(this);
        solve = new JButton("Solve Game");
        solve.setMinimumSize(new Dimension(45,30));
        solve.addActionListener(this);
        buttons.add(check);
        buttons.add(back);
        buttons.add(solve);

        contentPane.add(Box.createHorizontalStrut(10));
        contentPane.add(board);
        contentPane.add(Box.createVerticalGlue());
        contentPane.add(buttons);
        
        this.setPreferredSize(new Dimension(430,540));
        
        		
	}

    
    public void actionPerformed(ActionEvent e){
        Object sorce  = e.getSource();
        
        if (sorce == back){
            this.setVisible(false);
        }
        else if (sorce == solve){
            solver = new Solver(game);
            game.reset();
            solver.label();
            autoSolved = true;
            repaint();
            solve.removeActionListener(this);
        }
        else if (sorce == check && !autoSolved){
            if (!game.finished()){
                JOptionPane.showMessageDialog(this,
                                              "I don't think you've finished yet...",
                                              "Oops",
                                              JOptionPane.ERROR_MESSAGE);
            }
            else {
                if (solver.rules.allConstraints()){
                    JOptionPane.showMessageDialog(this,
                                                  "You Solved It!",
                                                  "Congratulations!",
                                                  JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(this,
                                                  "Something looks wrong...",
                                                  "Sorry...!",
                                                  JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}


