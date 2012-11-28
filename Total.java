public class Total {

    //Class for testing implementations
    
    public static void main(String[] args){
        
        if (args.length == 0){
            System.out.println("run w file plz");
            System.exit(1);
        }
        
        Game g;
        
        String[] str = args[0].split("/");
        
        if (str[1].substring(0,5).equals("kenke"))
            g = new KenKen(args[0]);
        else {
            g = new Soduku(args[0]);
            g.printBoardTerm();
            System.out.println();
        }   
                        
        Solver s = new Solver(g);
        s.label();
        
        System.out.println();
        g.printBoardTerm();
        System.out.println();
        
        
    }


}