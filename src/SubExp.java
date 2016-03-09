/**
 * A representation of the subtraction lerp expression.
 *
 * @author Arthur Nunes-Harwitt
 */
public class SubExp extends BinaryExp {

    /**
     * Construct a subtraction expression.
     *
     * @param exp1 the Expression that is the first operand of the
     * subtraction expression
     * @param exp2 the Expression that is the second operand of the
     * subtraction expression
     */
    public SubExp(Expression exp1, Expression exp2){
        // TODO
    }

    @Override
    public Triple<ANFVarExp, ANFOp, Expression> extract(){
        // TODO
        return null; // TODO replace
    }

    @Override
    public String toString(){
        return "(- " + super.toString() + ")";
    }
}
