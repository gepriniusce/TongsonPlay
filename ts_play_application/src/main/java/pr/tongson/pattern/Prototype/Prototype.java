package pr.tongson.pattern.Prototype;

/**
 * <b>Create Date:</b> 2017/11/8<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 抽象原型 <br>
 * 给出所有的具体原型类所需的接口
 */
public interface Prototype extends Cloneable {
    Prototype clone();
}
