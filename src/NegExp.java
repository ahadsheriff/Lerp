/**
 * A representation of the negation lerp expression.
 *
 * @author Arthur Nunes-Harwitt
 */
public class NegExp extends UnaryExp {

    /**
     * Construct a negation expression.
     *
     * @param exp the Expression that is the first operand of the
     * negation expression
     */
    public NegExp(Expression exp){
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
