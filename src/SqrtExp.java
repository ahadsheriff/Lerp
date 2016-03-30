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
        super(exp);
    }

    @Override
    public Triple<ANFVarExp, ANFOp, Expression> extract(){
        if(getExp()instanceof Holder){
            ANFVarExp express = new ANFVarExp();
            Holder hole = new Holder(express);

            return new Triple(express, new ANFSqrtOp((ANFVarExp)getExp().toANF()), hole);
        }
        else {
            return null;
        }
    }

    @Override
    public String toString(){
        return "(sqrt " + super.toString() + ")";
    }
}
