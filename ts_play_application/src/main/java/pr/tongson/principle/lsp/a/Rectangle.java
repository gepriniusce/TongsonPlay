package pr.tongson.principle.lsp.a;

/**
 * <b>Create Date:</b> 2017/10/9<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 矩形 <br>
 */
public class Rectangle implements Quadrangle {

    private long width;

    private long height;

    public void setWidth(long width) {
        this.width = width;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    @Override
    public long getWidth() {
        return this.width;
    }

    @Override
    public long getHeight() {
        return this.height;
    }
}
