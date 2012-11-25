public class Total {

    //Class for testing implementations
    
    public static void main(String[] args){
        
        if (args.length == 0){
            System.out.println("run w file plz");
            System.exit(1);
        }
        
        Game g = new Soduku(9,args[0]);
        
        Rule r = new SodukuRules(g);
        Solver s = new Solver(g);
        g.printBoardTerm();
        
        
        System.out.println();
        System.out.println();
        
        
        s.label();
        g.printBoardTerm();
        
        
    }


}