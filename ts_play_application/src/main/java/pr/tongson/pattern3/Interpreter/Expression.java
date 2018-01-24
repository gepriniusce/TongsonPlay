package pr.tongson.pattern3.Interpreter;

/**
 * <b>Create Date:</b> 2018/1/24<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 这个抽象类代表终结类和非终结类的抽象化<br>
 *
 * @author mmc_Kongming_Tongson
 */
abstract public class Expression {
    /**
     * 以环境类为准，本方法解析给定的任何一个表达式
     *
     * @return
     */
    public abstract boolean interpret(Context ctx);

    /**
     * 检验两个表达式再结构上是否相同
     *
     * @param o
     * @return
     */
    @Override
    public abstract boolean equals(Object o);

    /**
     * 返回表达式的hash code
     *
     * @return
     */
    @Override
    public abstract int hashCode();

    /**
     * 将表达式转换成字符串
     *
     * @return
     */
    @Override
    public abstract String toString();
}
