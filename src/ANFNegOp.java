/**
 * A representation of the negation operation for ANF-expressions.
 *
 * @author Arthur Nunes-Harwitt
 */
public class ANFNegOp extends ANFUnOp {

    /**
     * Construct an ANF negation operation.
     *
     * @param x the ANFVarExp that is the operand of the negation
     * operation
     */
    public ANFNegOp(ANFVarExp x){
        // TODO
    }

    @Override
    public void compile(int dest, Machine m){
        // TODO
    }

    @Override
    public String toString(){
        return "(- " + super.toString() + ")";
    }
    
}
