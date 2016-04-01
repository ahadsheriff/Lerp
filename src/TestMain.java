/**
 * Created by ahadsheriff on 3/31/16.
 */
import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.org.apache.xpath.internal.operations.Div;

import java.util.List;

/**
 * Created by Matthew Toro on 3/19/2016.
 */
public class TestMain {

    public static void main(String[] args) {

        Machine m  = new Machine();
        //String test = "(* (+ 2 (* 3 4)) (+ (sqrt 9) (- 5 )))";
        String test = "(+ 2 (* 3 4))";
        //String test = "0";
        Expression exp = Parser.parse(test);
        ANFExp anfExp = exp.toANF();
        System.out.println(exp);
        System.out.println(anfExp);
        anfExp.compile(m);
        m.execute();

        //System.out.println(anfExp);
        //anfExp.compile(m);
        //m.displayInstructions();
        //m.execute();
    }

}