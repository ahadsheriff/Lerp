import jdk.nashorn.internal.parser.TokenType;

/**
 * A class that contains the static methods to parse lerp expressions.
 * 
 * @author Arthur Nunes-Harwitt
 */

public class Parser {

    private static int pos;
    private static String[] tokens;


    /**
     * Build a data structure representation of the lerp expression
     * written as a string.
     * 
     * @param s a String that contains the text of a lerp expression
     * @return an Expression data structure representing the lerp expression
     */
    public static Expression parse(String s){
        tokens = s.replace("(", " ( ").replace(")", " ) ").trim().split("( )+");
        pos = 0;
        //return getExpression();

        try{
            Expression e = getExpression();
            //pos++;
            if (pos < tokens.length){
                Errors.error("Too much input.", null);
            } else {
                return e;
            }
        } catch (NumberFormatException e) {
            Errors.error("Expression must start with a number or open parenthesis.", null);
        } catch (Exception e) {
            Errors.error("Unexpected error ", e);
        }

        return null; // Shouldn't get here. To satisfy Java.

    }

    public Expression parenthesis() {
        if(tokens[pos].equals("(")) {
            pos++;
            return operators();
        }
        else {
            NumExp returnNums = new NumExp(Integer.parseInt(tokens[pos]));
            pos++;
            return returnNums;
        }
    }

    public Expression operators() {
        //pos++;
        Expression e1;
        Expression e2;
        switch (tokens[pos]) {
            case("+"):
                pos++;
                e1 = parenthesis();
                e2 = parenthesis();
                if(!tokens[pos].equals(")")){
                    Errors.error("Expected ')' next but got", tokens[pos]);
                }
                else {
                    pos++;
                }
                return new AddExp(e1,e2);

            case("-"):
                pos++;
                e1 = parenthesis();
                if(tokens[pos].equals(")")){
                    return new NegExp(e1);
                }
                e2 = parenthesis();
                if(!tokens[pos].equals(")")){
                    Errors.error("Expected ')' next but got", tokens[pos]);
                }
                else {
                    pos++;
                }
                return new SubExp(e1,e2);

            case("*"):
                pos++;
                e1 = parenthesis();
                e2 = parenthesis();
                if(!tokens[pos].equals(")")){
                    Errors.error("Expected ')' next but got", tokens[pos]);
                }
                else {
                    pos++;
                }
                return new MulExp(e1,e2);

            case("/"):
                pos++;
                e1 = parenthesis();
                e2 = parenthesis();
                if(!tokens[pos].equals(")")){
                    Errors.error("Expected ')' next but got", tokens[pos]);
                }
                else {
                    pos++;
                }
                return new DivExp(e1,e2);

            case("Sqrt"):
                pos++;
                e1 = parenthesis();
                if(!tokens[pos].equals(")")){
                    Errors.error("Expected ')' next but got", tokens[pos]);
                }
                else {
                    pos++;
                    //Triple<ANFVarExp, ANFOp, Expression> extractor = operators().extract();
                    //return new Triple(extractor.first(), extractor.second(), new SqrtExp(extractor.third()));
                }
                return new SqrtExp(e1);

            default:
                return null;
        }
    }

    private static Expression getExpression(){
        Parser p = new Parser();
        Expression e = p.parenthesis();
        return e;
    }

}
