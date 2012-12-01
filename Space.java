public interface Space {

  
    boolean morePossibilities();
    void nextPossibility();
    int getX();
    int getY();
    int getValue();
    void reset();
    void setGroup(Group g);
    Group getGroup();
    boolean labeled = false;
    void setRow(Group g);
    void setColumn(Group g);
    Group getRow();
    Group getColumn();
    void setValue(int val);
        
}
