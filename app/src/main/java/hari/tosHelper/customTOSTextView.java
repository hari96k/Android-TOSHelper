package hari.tosHelper;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class customTOSTextView extends TextView{

    public customTOSTextView(Context context){
        super(context);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),
                "fonts/tosfont.TTF"));
    }

    public customTOSTextView(Context context, AttributeSet attrs){
        super(context,attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),
                "fonts/tosfont.TTF"));
    }

    public customTOSTextView(Context context, AttributeSet attrs, int defStyle){
        super(context,attrs, defStyle);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),
                "fonts/tosfont.TTF"));
    }

}
