package pr.tongson.pattern2.Flyweight;

import android.util.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <b>Create Date:</b> 2017/12/20<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class FlyweightFactory {
    private HashMap files = new HashMap();
    private Flyweight lnkFlyweight;

    public FlyweightFactory() {
    }
    
    public Flyweight factory(Character state){
        if(files.containsKey(state)){
            return (Flyweight) files.get(state);
        }else {
            Flyweight fly=new ConcreteFlyweight(state);
            files.put(state,fly);
            return fly;
        }
    }
    
    public void checkFlyweight(){
        Flyweight fly;
        int i=0;
        Log.i("Tongson","\n==========checkFlyweight==========");
        for(Iterator it=files.entrySet().iterator();it.hasNext();){
            Map.Entry e= (Map.Entry) it.next();
            Log.i("Tongson","Item"+(++i)+":"+e.getKey());

        }
        Log.i("Tongson","==========checkFlyweight==========");
    }
}
