package pr.tongson;

import android.app.Application;

import com.tencent.tinker.loader.app.ApplicationLike;
import com.tinkerpatch.sdk.TinkerPatch;
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/2/2<br>
 * <b>Author:</b> mmc_Kongming_Tongson<br>
 * <b>Description:</b> <br>
 */
public class TongsonApplication extends Application {


    private ApplicationLike tinkerApplicationLike;

    @Override
    public void onCreate() {
        super.onCreate();
        // 我们可以从这里获得Tinker加载过程的信息
        tinkerApplicationLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike();

        // 初始化TinkerPatch SDK, 更多配置可参照API章节中的,初始化SDK
        TinkerPatch.init(tinkerApplicationLike).reflectPatchLibrary().setPatchRollbackOnScreenOff(true).setPatchRestartOnSrceenOff(true);

        // 每隔3个小时去访问后台时候有更新,通过handler实现轮训的效果
        new FetchPatchHandler().fetchPatchWithInterval(3);
    }
}
