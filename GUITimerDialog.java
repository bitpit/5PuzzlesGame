import java.awt.*;
import javax.swing.*;
import java.awt.event.* ;
import javax.swing.Timer;

public class GUITimerDialog extends JFrame implements ActionListener {

    private JButton timer;
    private JButton dismiss;
    private int time;
    private Timer timey;
    private Solver solver;
    
    public void init(Solver g){
        
        Container pane = this.getContentPane();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        pane.setLayout(new FlowLayout());
        
        solver = g;
        
        int delay = 1000;
        timey = new Timer(delay,this);
        time = 0;
        timer = new JButton((time/60)+":"+(time%60));
        timer.setMinimumSize(new Dimension(45,30));
        dismiss = new JButton("Close Window");
        dismiss.setMinimumSize(new Dimension(45,30));
        dismiss.addActionListener(this);
     
        setTitle("Solving, Please Wait..");
        pane.add(Box.createHorizontalStrut(10));
        pane.add(timer);
        pane.add(dismiss);
        pane.add(Box.createVerticalGlue());

        
        timey.start();
    }

    public void actionPerformed(ActionEvent e){
        Object sorce = e.getSource();
        if (sorce == dismiss){
            this.setVisible(false);
        }
        else if (sorce == timey){
            if (solver.rules.allConstraints() &&
                solver.getLabelled())
                timey.stop();
            else
                bump();
        }
    }
    
    public void bump(){
        time++;
        timer.setText((time/60)+":"+(time%60));
    }
    
}