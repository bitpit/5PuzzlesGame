public interface Space {

    boolean morePossibilities();
    void nextPossibility();
    int getX();
    int getY();
    int getValue();
    void reset();
}