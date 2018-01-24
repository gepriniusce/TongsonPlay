package pr.tongson.pattern3.Visitor;

/**
 * <b>Create Date:</b> 2018/1/24<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class Client {
    private static ObjectStructure aObjects;
    private static Visitor visitor;

    static public void main(String[] args) {
        //创建一个结构对象
        aObjects = new ObjectStructure();
        //给结构增加一个节点
        aObjects.add(new NodeA());
        //给结构增加一个节点
        aObjects.add(new NodeB());
        //创建一个新的访问者
        visitor = new VisitorA();
        //让访问者访问结构
        aObjects.action(visitor);
    }
}
