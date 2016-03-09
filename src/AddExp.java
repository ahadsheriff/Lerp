/**
 * A representation of the addition lerp expression.
 *
 * @author Arthur Nunes-Harwitt
 */
public class AddExp extends BinaryExp {

    /**
     * Construct an addition expression.
     *
     * @param exp1 the Expression that is the first operand of the
     * addition expression
     * @param exp2 the Expression that is the second operand of the
     * addition expression
     */
    public AddExp(Expression exp1, Expression exp2){
        // TODO
    }

    @Override
    public Triple<ANFVarExp, ANFOp, Expression> extract(){
        // TODO
        return null; // TODO replace
    }

    @Override
    public String toString(){
        return "(+ " + super.toString() + ")";
    }
}
