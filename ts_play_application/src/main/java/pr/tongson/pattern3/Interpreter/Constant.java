package pr.tongson.pattern3.Interpreter;

/**
 * <b>Create Date:</b> 2018/1/24<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class Constant extends Expression {
    private boolean value;

    public Constant(boolean value) {
        this.value = value;
    }

    /**
     * 解析操作
     * @param ctx
     * @return
     */
    @Override
    public boolean interpret(Context ctx) {
        return value;
    }

    /**
     * 检验两个表达式在结构上是否相同
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Constant) {
            return this.value == ((Constant) o).value;
        }
        return false;
    }

    /**
     * 返回表达式的hash code
     * @return
     */
    @Override
    public int hashCode() {
        return (this.toString()).hashCode();
    }

    /**
     * 将表达式转换成字符串
     * @return
     */
    @Override
    public String toString() {
        return new Boolean(value).toString();
    }
}
