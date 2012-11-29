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
        else if (str[1].substring(0,4).equals("page")){
            g = new Page472(args[0]);
            Solver s = new Solver(g);
        }
        else {
            g = new Soduku(args[0]);
            g.printBoardTerm();
            System.out.println();
        }   
            
        //if (!str[1].substring(0,4).equals("page")){
        
        Solver s = new Solver(g);
        System.out.println(s.label()+" label success");
        System.out.println();
        g.printBoardTerm();
            
    }
}