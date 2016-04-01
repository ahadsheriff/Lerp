import jdk.nashorn.internal.parser.Token;
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
            if (pos >= tokens.length) {
                Errors.error("Unexpected end of input.", null);
            }
            return operators();
        }
        else {
            NumExp returnNums = new NumExp(Integer.parseInt(tokens[pos]));
            pos++;
            if (pos >= tokens.length) {
                Errors.error("Unexpected end of input.", null);
            }
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
                if (pos >= tokens.length) {
                    Errors.error("Unexpected end of input.", null);
                }
                e1 = parenthesis();
                e2 = parenthesis();
                if(!tokens[pos].equals(")")){
                    Errors.error("Unexpected token", tokens[pos] + "; expected ).");
                }
                else {
                    pos++;
                    if (pos >= tokens.length) {
                        Errors.error("Unexpected end of input.", null);
                    }
                }
                return new AddExp(e1,e2);

            case("-"):
                pos++;
                if (pos >= tokens.length) {
                    Errors.error("Unexpected end of input.", null);
                }
                e1 = parenthesis();
                if(tokens[pos].equals(")")){
                    return new NegExp(e1);
                }
                e2 = parenthesis();
                if(!tokens[pos].equals(")")){
                    Errors.error("Unexpected token", tokens[pos] + "; expected ).");
                }
                else {
                    pos++;
                    if (pos >= tokens.length) {
                        Errors.error("Unexpected end of input.", null);
                    }
                }
                return new SubExp(e1,e2);

            case("*"):
                pos++;
                if (pos >= tokens.length) {
                    Errors.error("Unexpected end of input.", null);
                }
                e1 = parenthesis();
                e2 = parenthesis();
                if(!tokens[pos].equals(")")){
                    Errors.error("Unexpected token", tokens[pos] + "; expected ).");
                }
                else {
                    pos++;
                    if (pos >= tokens.length) {
                        Errors.error("Unexpected end of input.", null);
                    }
                }
                return new MulExp(e1,e2);

            case("/"):
                pos++;
                if (pos >= tokens.length) {
                    Errors.error("Unexpected end of input.", null);
                }
                e1 = parenthesis();
                e2 = parenthesis();
                if(!tokens[pos].equals(")")){
                    Errors.error("Unexpected token", tokens[pos] + "; expected ).");
                }
                else {
                    pos++;
                    if (pos >= tokens.length) {
                        Errors.error("Unexpected end of input.", null);
                    }
                }
                return new DivExp(e1,e2);

            case("Sqrt"):
                pos++;
                if (pos >= tokens.length) {
                    Errors.error("Unexpected end of input.", null);
                }
                e1 = parenthesis();
                if(!tokens[pos].equals(")")){
                    Errors.error("Unexpected token", tokens[pos] + "; expected ).");
                }
                else {
                    pos++;
                    if (pos >= tokens.length) {
                        Errors.error("Unexpected end of input.", null);
                    }
                }
                return new SqrtExp(e1);

            default:
                Errors.error("Unexpected operator", "'" + tokens[pos] + "'\n");
                return null;
        }
    }

    private static Expression getExpression(){
        Parser p = new Parser();
        Expression e = p.parenthesis();
        return e;
    }

}
