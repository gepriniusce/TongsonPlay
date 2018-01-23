package pr.tongson.pattern3.Immutable;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class Product {
    /**
     * final可以确保不会被继承
     * private确保不可被访问，final确保不可被修改
     */
    private final String a;
    private final String b;
    private final double c;

    public Product(String a, String b, double c) {
        //创建对象时必须指定值，因为创建后将无法修改  
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public double getC() {
        return c;
    }
    
    
}  