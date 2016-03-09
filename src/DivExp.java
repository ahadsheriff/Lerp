/**
 * A representation of the division lerp expression.
 *
 * @author Arthur Nunes-Harwitt
 */
public class DivExp extends BinaryExp {

    /**
     * Construct an division expression.
     *
     * @param exp1 the Expression that is the first operand of the
     * division expression
     * @param exp2 the Expression that is the second operand of the
     * division expression
     */
    public DivExp(Expression exp1, Expression exp2){
        // TODO
    }

    @Override
    public Triple<ANFVarExp, ANFOp, Expression> extract(){
        // TODO
        return null; // TODO replace
    }

    @Override
    public String toString(){
        return "(/ " + super.toString() + ")";
    }
}
