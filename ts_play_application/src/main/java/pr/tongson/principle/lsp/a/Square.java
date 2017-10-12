package pr.tongson.principle.lsp.a;

/**
 * <b>Create Date:</b> 2017/10/9<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 正方形 <br>
 */
public class Square implements Quadrangle {

    private long side;

    public long getSide() {
        return side;
    }

    public void setSide(long side) {
        this.side = side;
    }

    @Override
    public long getWidth() {
        return getSide();
    }

    @Override
    public long getHeight() {
        return getSide();
    }
}
