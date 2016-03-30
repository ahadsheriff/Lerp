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
        super(exp1, exp2);
    }

    @Override
    public Triple<ANFVarExp, ANFOp, Expression> extract(){
        if(getExp1()instanceof Holder && getExp2()instanceof Holder){
            ANFVarExp express = new ANFVarExp();
            Holder hole = new Holder(express);

            //TODO
            // Replacing ANFVarExp cast with Holder throws an error
            return new Triple(express, new ANFSubOp((ANFVarExp) getExp1().toANF(), (ANFVarExp) getExp2().toANF()),hole);
        }

        else if (!(getExp1()instanceof Holder)) {
            Triple<ANFVarExp, ANFOp, Expression> extractor = getExp1().extract();
            return new Triple(extractor.first(), extractor.second(), new SubExp(getExp2(), extractor.third()));
        }

        else if (!(getExp2()instanceof Holder)) {
            Triple<ANFVarExp, ANFOp, Expression> extractor = getExp2().extract();
            return new Triple(extractor.first(), extractor.second(), new SubExp(getExp2(), extractor.third()));
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
