package pr.tongson.pluginmodule.type;

import android.content.Context;
import android.graphics.Typeface;

/**
 * TrueTypeFont
 */
/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/3/24<br>
 * <b>Author:</b> mmc_Kongming_Tongson<br>
 * <b>Description:</b> TrueTypeFont <br>
 */
public class TTFUtils {

    public static Typeface ttf;

    /**
     * 加载字体
     * @return
     */
    public static void loadTtf(Context context){
        Typeface fontFace = null;
        try {
            fontFace = Typeface.createFromAsset(context.getAssets(),
                    "fonts/msyhl.ttc");
        }
        catch (RuntimeException e){
            e.printStackTrace();
        }
        if(fontFace != null){
            ttf = fontFace;
        }
    }

    /**
     * 获取字体
     * @return
     */
    public static Typeface getTtf(){
        return  ttf;
    }

}
