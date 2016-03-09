/**
 * An abstract class to characterize the common data and methods
 * associated with binary expressions.
 *
 * @author Arthur Nunes-Harwitt
 */
public abstract class BinaryExp implements Expression {

    private Expression exp1, exp2;

    public BinaryExp(){} // TODO eliminate this line after implementing subclasses
    
    /**
     * Initialize the two operands.  This constructor can only be
     * invoked by a sub-class.
     *
     * @param exp1 the Expression that is the first operand of the
     * binary expression
     * @param exp2 the Expression that is the second operand of the
     * binary expression
     */
    public BinaryExp(Expression exp1, Expression exp2){
        // TODO
    }

    /**
     * A selector for getting an operand from a binary expression.
     *
     * @return the Expression that is the first operand of the binary expression
     */
    public Expression getExp1(){
        // TODO
        return null; // TODO replace
    }

    /**
     * A selector for getting an operand from a binary expression.
     *
     * @return the Expression that is the second operand of the binary expression
     */
    public Expression getExp2(){
        // TODO
        return null; // TODO replace
    }

    @Override
    public ANFExp toANF(){
        // TODO
        return null; // TODO replace
    }

    @Override
    public abstract Triple<ANFVarExp, ANFOp, Expression> extract();

    @Override
    public String toString(){
        return this.exp1 + " " + this.exp2;
    }
}
