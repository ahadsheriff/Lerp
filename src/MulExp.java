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
        super(exp1, exp2);
    }

    @Override
    public Triple<ANFVarExp, ANFOp, Expression> extract(){
        if(getExp1()instanceof Holder && getExp2()instanceof Holder){
            ANFVarExp express = new ANFVarExp();
            Holder hole = new Holder(express);

            return new Triple(express, new ANFMulOp(((Holder) getExp1()).getVar(), ((Holder) getExp2()).getVar()),hole);
        }

        else if (!(getExp1()instanceof Holder)) {
            Triple<ANFVarExp, ANFOp, Expression> extractor = getExp1().extract();
            return new Triple(extractor.first(), extractor.second(), new MulExp(getExp2(), extractor.third()));
        }

        else if (!(getExp2()instanceof Holder)) {
            Triple<ANFVarExp, ANFOp, Expression> extractor = getExp2().extract();
            return new Triple(extractor.first(), extractor.second(), new MulExp(getExp2(), extractor.third()));
        }

        else {
            return null;
        }
    }

    @Override
    public String toString(){
        return "(* " + super.toString() + ")";
    }
}
