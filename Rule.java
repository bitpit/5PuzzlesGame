public interface Rule {

    boolean row(Space s);
    boolean column(Space s);
    boolean shape(Space s);
    boolean constraints(Space s);
    boolean allConstraints();

}