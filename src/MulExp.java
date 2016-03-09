/**
 * A representation of the multiplication lerp expression.
 *
 * @author Arthur Nunes-Harwitt
 */
public class MulExp extends BinaryExp {

    /**
     * Construct a multiplication expression.
     *
     * @param exp1 the Expression that is the first operand of the
     * multiplication expression
     * @param exp2 the Expression that is the second operand of the
     * multiplication expression
     */
    public MulExp(Expression exp1, Expression exp2){
        // TODO
    }

    @Override
    public Triple<ANFVarExp, ANFOp, Expression> extract(){
        // TODO
        return null; // TODO replace
    }

    @Override
    public String toString(){
        return "(* " + super.toString() + ")";
    }
}
