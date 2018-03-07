package pr.tongson.pattern3.Visitor;

import java.util.Enumeration;
import java.util.Vector;

/**
 * <b>Create Date:</b> 2018/1/24<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class ObjectStructure {
    private Vector nodes;
    private Node node;

    public ObjectStructure() {
        nodes = new Vector();
    }

    public void action(Visitor visitor) {
        for (Enumeration e = nodes.elements(); e.hasMoreElements(); ) {
            node = (Node) e.nextElement();
            node.accept(visitor);
        }
    }

    public void add(Node node) {
        nodes.addElement(node);
    }
}
