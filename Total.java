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
        }
        else if (str[1].substring(0,4).equals("sixp")){
            g = new SixPack(args[0]);
        }
        else {
            g = new Soduku(args[0]);
            System.out.println();
        }   
            
        //if (!str[1].substring(0,4).equals("page")){
        System.out.println();
        g.printBoardTerm();
        System.out.println();
        Solver s = new Solver(g);
        Thread t = new Thread(s);
        System.out.println(s.label());
        t.run();
        System.out.println();
        g.printBoardTerm();
        System.out.println();
            
    }
}