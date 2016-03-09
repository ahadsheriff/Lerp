/**
 * A representation of the square root lerp expression.
 *
 * @author Arthur Nunes-Harwitt
 */
public class SqrtExp extends UnaryExp {

    /**
     * Construct a square root expression.
     *
     * @param exp the Expression that is the first operand of the
     * square root expression
     */
    public SqrtExp(Expression exp){
        // TODO
    }

    @Override
    public Triple<ANFVarExp, ANFOp, Expression> extract(){
        // TODO
        return null; // TODO replace
    }

    @Override
    public String toString(){
        return "(sqrt " + super.toString() + ")";
    }
}
