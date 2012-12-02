import java.awt.*;
import javax.swing.*;
import java.awt.event.* ;

public class GUISudoku extends JFrame implements ActionListener {
    
    private JButton back;
    private JButton solve;
    private JButton check;
    private JFrame parent;
    private GUISudokuBoard board;
    private Game game;
    private Solver solver;
    private GUISquareSpace[][] spaces;
    
    
    public void init() {

		Container contentPane = this.getContentPane();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        		
        JLabel title = new JLabel("Sudoku");
        title.setFont(new Font("Verdana",Font.PLAIN,18));
        
        board = new GUISudokuBoard(9,solver,game,this);
        board.setPreferredSize(new Dimension(450,450));
        board.setMaximumSize(new Dimension(450,450));
		        
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
    
    
    public void checkConstraints(){
        System.out.println("check constraints");
    }
    
    
    public void parentHandoff(JFrame j){
        parent = j;
    }
    
    
    public void setGame(String fn){
        game = new Soduku(fn);
        solver = new Solver(game);
    }
    
    
    public void actionPerformed(ActionEvent e){
        Object sorce  = e.getSource();
        if (sorce == back){
            this.setVisible(false);
        }
        else if (sorce == solve){
            solver.label();
            board.removeListeners();
            repaint();
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


