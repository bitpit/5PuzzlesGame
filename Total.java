public class Total {


    public static void main(String[] args){
        
        Game g = new Soduku(9,"testSoduku");
        Rule r = new SodukuRules(g);
        g.printBoardTerm();
        
    }


}