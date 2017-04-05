package pr.tongson.pluginmodule.type;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/3/24<br>
 * <b>Author:</b> mmc_Kongming_Tongson<br>
 * <b>Description:</b> <br>
 */
public class TongsonTextView extends TextView {

    public static Typeface myTypeface;

    public TongsonTextView(Context context) {
        super(context);
        setTTFstyle();
    }

    public TongsonTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTTFstyle();
    }

    public TongsonTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTTFstyle();
    }

    private void setTTFstyle() {
        Typeface typeface= getTtf();
        if (null != typeface) {
            setTypeface(typeface);
        }
    }


    /**
     * 加载字体库
     * <p>
     * 此处应该在Application中
     *
     * @param context
     */
    public static void loadTtf(Context context) {
        Typeface fontFace = null;
        try {
            fontFace = Typeface.createFromAsset(context.getAssets(), "fonts/msyhl.ttc");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (fontFace != null) {
            myTypeface = fontFace;
        }
    }

    /**
     * 获取字体
     *
     * @return
     */
    private Typeface getTtf() {
        return myTypeface;
    }
}
