import java.awt.*;
import javax.swing.*;
import java.awt.event.* ;

public class GUISudoku extends JFrame implements ActionListener {
    
    private JButton back;
    private JButton solve;
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
        back = new JButton("Exit Game");
        back.setMinimumSize(new Dimension(45,30));
        back.addActionListener(this);
        solve = new JButton("Solve Game");
        solve.setMinimumSize(new Dimension(45,30));
        solve.addActionListener(this);
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
        if (e.getSource() == back){
            this.setVisible(false);
        }
        else if (e.getSource() == solve){
            solver.label();
            board.removeListeners();
            repaint();
        }

    }
}


