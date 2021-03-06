import java.awt.*;
import javax.swing.*;
import java.awt.event.* ;
import javax.swing.JFrame;
import java.util.ArrayList;

public class GUILogi5Board extends JPanel {


    private Game game;
    private JButton[][] spaces;
    private GUILogi5Space space;
    private int dim;
    private int spaceSize = 50;
    private Color color;
    private Color[] possibleColors;
    private Group[] groups;

       
    public GUILogi5Board(Game game){
                       
        this.game = game;
        dim = game.getDimensions()[0];
        
        setLayout(new GridLayout(dim,dim));
        spaces = new JButton[dim][dim];
        
             
        for (int i = 0; i < spaces.length; i++){
            for (int j = 0; j < spaces[i].length; j++){
                
                Space otherSpace = game.getSpaceAt(i,j);
                
                GUILogi5Space spacey = new GUILogi5Space(i,j,spaceSize);
                int[] loc = spacey.getDims();
                spacey.setSpace(game.getSpaceAt(loc[0],loc[1]));
                spaces[i][j] = spacey;
                add(spacey);
                
            }
        }
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(spaceSize*spaces.length,spaceSize*spaces[0].length));
        setMaximumSize(new Dimension(spaceSize*spaces.length,spaceSize*spaces[0].length));
        
        
        int num = 255;
        Color[] colors = new Color[6];
        for (int i = 0; i < colors.length; i++){
            colors[i] = new Color(num,num,num,220);
            num -= 30;
        }
        
        possibleColors = colors;
    
    }
    
    
    public void setUpGroups(){
        
        this.groups = game.getGroups();
        Color[] groupToColor = new Color[groups.length];
        for (int i = 0; i < groupToColor.length; i++){
            groupToColor[i] = possibleColors[i%possibleColors.length];
        }
         
        
        for (int i = 0; i < groupToColor.length; i++){
            Group[] conflictingGroups;
            conflictingGroups = conflicting(i, groupToColor);
            
            int noOfTimes = 0;
            
            while (conflictingGroups.length != 0){
                int offset;
                if (noOfTimes > 5)
                    offset = 3;
                else
                    offset = 2;
                
                groupToColor[conflictingGroups[0].groupIDX] = possibleColors[(conflictingGroups[0].groupIDX+offset)%possibleColors.length];   
                conflictingGroups = conflicting(i, groupToColor);
                noOfTimes++;
            }
        }
        
        
        for (int i = 0; i < groups.length; i++){
            Space[] groupSpaces = groups[i].getSpaces();
            for (int j = 0; j < groupSpaces.length; j++){
                Space current = groupSpaces[j];
                GUILogi5Space currentSpace = (GUILogi5Space)(spaces[current.getX()][current.getY()]);
                currentSpace.setColor(groupToColor[i]);
            }
        }
        
    }
    
    
    private Group[] conflicting(int ish, Color[] groupToColor){
        ArrayList<Group> touchers = new ArrayList<Group>();
        Group g = groups[ish];
        Space[] gSpaces = g.getSpaces();
        for (int i = 0; i < gSpaces.length; i++){
            Space current = gSpaces[i];
            for (int k = -1; k < 2; k++){
                int curSX = current.getX();
                int curSY = current.getY();
                curSX += k;
                curSY += k;
                if (curSX < 0){
                    curSX = 0;
                }
                if (curSX > spaces.length-1){
                    curSX = spaces.length-1;
                }
                if (curSY < 0){
                    curSY = 0;
                }
                if (curSY > spaces.length-1){
                    curSY = spaces.length-1;
                }
                Space[] comparison = new Space[2];
                comparison[0] = game.getSpaceAt(curSX, current.getY());
                comparison[1] = game.getSpaceAt(current.getX(), curSY);
                int mod = groupToColor.length;
                for (int j = 0; j < comparison.length; j++){
                    if ((comparison[j].getGroup().groupIDX != g.groupIDX) && 
                        groupToColor[comparison[j].getGroup().groupIDX%mod] == groupToColor[current.getGroup().groupIDX%mod] &&
                        !touchers.contains(comparison[j].getGroup())){
                        touchers.add(comparison[j].getGroup());
                    }
                }
            }
        }
        return touchers.toArray(new Group[touchers.size()]);
    }
        
   
    public void removeListeners(){
        
        for (JButton[] panel : spaces){
            for (int i = 0; i < panel.length; i++){
                Component[] camps = panel[i].getComponents();
                Component comp = null;
                for (int j = 0; j < camps.length; j++){
                    comp = camps[j];
                    if (comp instanceof JButton){
                        JButton jb = (JButton)(camps[j]);
                        ActionListener[] lastnrs = jb.getActionListeners();
                        for (int k = 0; k < lastnrs.length; k++){
                            jb.removeActionListener(lastnrs[k]);
                        }
                    }
                }
            }
        }
    }
    
    
}