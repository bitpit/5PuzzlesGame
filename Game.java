public interface Game {
    
    /*
     Very shortly, a game is comprised of an array of spaces and
     methods that let you access information about the game, most
     importantly those spaces. I think the method names are all 
     descriptive enough to stand on their own other than that.
     */
    
    String getName();
    boolean finished();
    void printBoardTerm();
    Space nextUnsolved();
    Space getSpaceAt(int x, int y);
    void setSpaceAt(int x, int y, int val);
    Group[] getGroups();
    int[] getDimensions();//of the board
    
       
}