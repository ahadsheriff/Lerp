/**
 * An abstract class to characterize the common data associated with
 * ANF unary operators.
 *
 * @author Arthur Nunes-Harwitt
 */
public abstract class ANFUnOp implements ANFOp {

    private ANFVarExp x;

    public ANFUnOp(){} // TODO eliminate this line after implementing subclasses
    
    /**
     * Initialize the operand.  This constructor can only be
     * invoked by a sub-class.
     *
     * @param x the ANFVarExp that is the operand of the unary operation
     */
    public ANFUnOp(ANFVarExp x){
        // TODO
    }

    /**
     * A selector for getting the operand from a unary operation.
     *
     * @return the ANFVarExp that is the operand of the unary operation
     */
    public ANFVarExp getX(){
        // TODO
        return null; // TODO replace
    }

    @Override
    public abstract void compile(int dest, Machine m);

    @Override
    public String toString(){
        return this.x.toString();
    }
    
}
