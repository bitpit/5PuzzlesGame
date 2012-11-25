public interface Game {
    
    String getName();
    boolean finished();
    void printBoardTerm();
    Space nextUnsolved();
    Space getSpaceAt(int x, int y);
    
       
}