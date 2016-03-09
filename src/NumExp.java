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
        // TODO
    }

    @Override
    public ANFExp toANF(){
        // TODO
        return null; // TODO replace
    }

    @Override
    public Triple<ANFVarExp, ANFOp, Expression> extract(){
        // TODO
        return null; // TODO replace
    }

    @Override
    public String toString(){
        return ""+this.num;
    }
}
