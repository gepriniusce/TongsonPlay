package pr.tongson.pattern.Prototype;

/**
 * <b>Create Date:</b> 2017/11/8<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 具体原型 <br>
 * 被复制的对象
 * 需要实现抽象的原型角色所要求的接口。
 */
public class ConcretePrototype implements Prototype {
    /**
     * 克隆方法
     *
     * @return
     */
    @Override
    public Prototype clone() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
