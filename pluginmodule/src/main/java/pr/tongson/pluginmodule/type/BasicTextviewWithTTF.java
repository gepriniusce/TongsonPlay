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
public class BasicTextviewWithTTF extends TextView {

    public BasicTextviewWithTTF(Context context) {
        super(context);
        setTTFstyle();
    }

    public BasicTextviewWithTTF(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTTFstyle();
    }

    public BasicTextviewWithTTF(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTTFstyle();
    }

    /**
     * 设置字体样式
     */
    public void setTTFstyle(){
        Typeface type = TTFUtils.getTtf();
        if(null != type){
            setTypeface(type);
        }
    }

}
