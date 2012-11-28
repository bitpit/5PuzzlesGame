public class Total {

    //Class for testing implementations
    
    public static void main(String[] args){
        
        if (args.length == 0){
            System.out.println("run w file plz");
            System.exit(1);
        }
        
        
        Game g = new KenKen(args[0]);
                
        Solver s = new Solver(g);
        s.label();
        
        System.out.println();
        g.printBoardTerm();
        System.out.println();
        
        
    }


}