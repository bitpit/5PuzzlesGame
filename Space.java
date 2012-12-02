public interface Space {

  
    boolean morePossibilities();
    void nextPossibility();
    int getX();
    int getY();
    int getValue();
    void reset();
    void setGroup(Group g);
    Group getGroup();
    void setRow(Group g);
    void setColumn(Group g);
    Group getRow();
    Group getColumn();
    void setValue(int val);
    int getPossibilities();
    void setLabeled();
}
