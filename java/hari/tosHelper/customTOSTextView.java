package hari.tosHelper;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class customTOSTextView extends android.support.v7.widget.AppCompatTextView {
    public customTOSTextView(Context context) {
        super(context);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/tosfont.TTF"));
    }

    public customTOSTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/tosfont.TTF"));
    }

    public customTOSTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/tosfont.TTF"));
    }
}
