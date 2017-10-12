package pr.tongson.principle.ocp.b;

/**
 * <b>Create Date:</b> 2017/10/12<br>
 * <b>Author:</b> mmc_Kongming_Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class ComputerBook implements IComputerBook {
    private String name;
    private String scope;
    private String author;
    private int price;

    public ComputerBook(String _name, int _price, String _author, String _scope) {
        this.name = _name;
        this.price = _price;
        this.author = _author;
        this.scope = _scope;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public String getScope() {
        return this.scope;
    }

}
