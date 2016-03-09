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
        try{
            Expression e = getExpression();
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


    // TODO any other helper methods

    private static Expression getExpression(){
        // TODO
        return null; 
    }

}
