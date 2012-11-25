public interface Rule {

    boolean row();

    boolean column();

    boolean shape();
    
    boolean constraints(Space s);
    boolean allConstraints();

}