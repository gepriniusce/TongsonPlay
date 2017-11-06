package pr.tongson.pattern.SimpleFactory;

import android.util.Log;

/**
 * <b>Create Date:</b> 2017/11/6<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 具体产品Product <br>
 */
public class Apple implements Fruit {
    private int treeAge;
    @Override
    public void grow() {
        Log.i("","Apple is growing...");
    }

    @Override
    public void harvest() {
        Log.i("","Apple has been harvested.");
    }

    @Override
    public void plant() {
        Log.i("","Apple  has been planted.");
    }

    public int getTreeAge() {
        return treeAge;
    }

    public void setTreeAge(int treeAge) {
        this.treeAge = treeAge;
    }
}
