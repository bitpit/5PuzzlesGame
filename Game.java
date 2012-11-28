public interface Game {
    
    String getName();
    boolean finished();
    void printBoardTerm();
    Space nextUnsolved();
    Space getSpaceAt(int x, int y);
    void setSpaceAt(int x, int y, int val);
    Group[] getGroup();
    int[] getDimensions();
    
       
}