package pr.tongson.pattern3.Interpreter;

import java.util.HashMap;

/**
 * <b>Create Date:</b> 2018/1/24<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class Context {
    private HashMap map = new HashMap();

    public void assign(Variable var, boolean value) {
        map.put(var, new Boolean(value));
    }


    public boolean lookup(Variable var) throws IllegalArgumentException {

        Boolean value = (Boolean) map.get(var);
        if (value == null) {
            throw new IllegalArgumentException();
        }
        
        return value.booleanValue();
    }

    public boolean interpret(Expression expression) {
        return false;
    }
}
