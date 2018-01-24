package pr.tongson.pattern3.Interpreter;

/**
 * <b>Create Date:</b> 2018/1/24<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class And extends Expression {
    private Expression left, right;

    public And(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(Context ctx) {
        return ctx.interpret(this) && ctx.interpret(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof And) {
            return this.left.equals(((And) o).left) && this.right.equals(((And) o).right);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.toString()).hashCode();
    }

    @Override
    public String toString() {
        return "(" + left.toString() + "AND" + right.toString() + ")";
    }
}
