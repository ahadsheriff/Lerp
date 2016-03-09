/**
 * An abstract class to characterize the common data associated with
 * ANF binary operators.
 *
 * @author Arthur Nunes-Harwitt
 */
public abstract class ANFBinOp implements ANFOp {

    private ANFVarExp x1;
    private ANFVarExp x2;

    public ANFBinOp(){} // TODO eliminate this line after implementing subclasses
    
    /**
     * Initialize the two operands.  This constructor can only be
     * invoked by a sub-class.
     *
     * @param x1 the ANFVarExp that is the first operand of the binary
     * operation
     * @param x2 the ANFVarExp that is the second operand of the
     * binary operation
     */
    public ANFBinOp(ANFVarExp x1, ANFVarExp x2){
        // TODO
    }

    /**
     * A selector for getting an operand from a binary operation.
     *
     * @return the ANFVarExp that is the first operand of the binary operation
     */
    public ANFVarExp getX1(){
        // TODO
        return null; // TODO replace
    }

    /**
     * A selector for getting an operand from a binary operation.
     *
     * @return the ANFVarExp that is the second operand of the binary operation
     */
    public ANFVarExp getX2(){
        // TODO
        return null; // TODO replace
    }

    @Override
    public abstract void compile(int dest, Machine m);

    @Override
    public String toString(){
        return this.x1 + " " + this.x2;
    }

}
