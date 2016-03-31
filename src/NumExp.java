/**
 * A representation of a number lerp expression.
 *
 * @author Arthur Nunes-Harwitt
 */
public class NumExp implements Expression {

    private double num;

    /**
     * Construct a number expression.
     *
     * @param num the double that is the number
     */
    public NumExp(double num){
        this.num = num;
    }

    @Override
    public ANFExp toANF(){
        ANFVarExp exe = new ANFVarExp();

        return new ANFLetExp(exe, new ANFConstOp(num), exe);

    }

    @Override
    public Triple<ANFVarExp, ANFOp, Expression> extract(){
        ANFVarExp vary = new ANFVarExp();
        return new Triple<>(vary, new ANFConstOp(num), new Holder(vary));
    }

    @Override
    public String toString(){
        return ""+this.num;
    }
}
