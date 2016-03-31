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
        super(exp);
    }

    @Override
    public Triple<ANFVarExp, ANFOp, Expression> extract(){

        if(getExp()instanceof Holder){
            ANFVarExp express = new ANFVarExp();
            Holder hole = new Holder(express);

            return new Triple(express, new ANFNegOp(((Holder) getExp()).getVar()), hole);
        }
        else {
            return null;
        }
    }

    @Override
    public String toString(){
        return "(- " + super.toString() + ")";
    }
}
