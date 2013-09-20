import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class GUIKenKen extends GUIGame implements ActionListener {

    private JButton back;
    private JButton solve;
    private JButton check;
    private GUIKenKenBoard board;
    private Game game;
    private Solver solver;
    private GUITimerDialog timer;
        
    
    public void init(Game game) {
        
		Container contentPane = this.getContentPane();
        
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        
        this.game = game;
        solver = new Solver(game);
        
        
        JLabel title = new JLabel(game.getName());
        title.setFont(new Font("Verdana",Font.PLAIN,18));
        
        board = new GUIKenKenBoard(game);
        board.setUpGroups();
                
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
        
        
	}
    
    
    public void actionPerformed(ActionEvent e){
        Object sorce  = e.getSource();
        if (sorce == back){
            this.setVisible(false);
        }
        else if (sorce == solve){
            game.reset();
            if (game.getDimensions()[0]>8){
                timer = new GUITimerDialog();
                timer.init(solver);
                timer.pack();
                timer.setVisible(true);
                
            }
            solver.start();
            board.removeListeners();
            repaint();
            solve.removeActionListener(this);
            check.removeActionListener(this);
        }
        else if (sorce == check){
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
                    board.removeListeners();
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