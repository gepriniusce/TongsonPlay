package pr.tongson.pattern.SimpleFactory;

import android.util.Log;

/**
 * <b>Create Date:</b> 2017/11/6<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 具体产品Product <br>
 */
public class Grape implements Fruit {

    private boolean seedless;

    @Override
    public void grow() {
        Log.i("", "Grape is growing...");
    }

    @Override
    public void harvest() {
        Log.i("", "Grape has been harvested.");
    }

    @Override
    public void plant() {
        Log.i("", "Grape  has been planted.");
    }

    public boolean isSeedless() {
        return seedless;
    }

    public void setSeedless(boolean seedless) {
        this.seedless = seedless;
    }
}
