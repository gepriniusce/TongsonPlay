package pr.tongson;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

/**
 * <b>Create Date:</b> 2017/12/1<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class HttpRequest implements LifecycleObserver {

    public HttpRequest() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny() {
        Log.i("Tongson", "ON_ANY");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Log.i("Tongson", "ON_CREATE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        Log.i("Tongson", "ON_START");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Log.i("Tongson", "ON_RESUME");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Log.i("Tongson", "ON_PAUSE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        Log.i("Tongson", "ON_STOP");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Log.i("Tongson", "onDestroy");
    }
    
    
}
