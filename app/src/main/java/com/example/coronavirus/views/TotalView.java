package com.example.coronavirus.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.coronavirus.R;

public class TotalView extends LinearLayout {

    private TextView mPrimaryTextView;
    private TextView mSecondaryTextView;

    public TotalView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // inflate created layout
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.total_view, this, true);

        // get custom attributes
        // obtain drawable from particular attribute
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TotalView);
        Drawable drawable = array.getDrawable(R.styleable.TotalView_src);
        String primaryText = array.getString(R.styleable.TotalView_primaryText);
        String secondaryText = array.getString(R.styleable.TotalView_secondaryText);
        array.recycle();

        // image view
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageDrawable(drawable);

        // primary text
        mPrimaryTextView = findViewById(R.id.primaryText);
        mPrimaryTextView.setText(primaryText);

        // secondary text
        mSecondaryTextView = findViewById(R.id.secondaryText);
        mSecondaryTextView.setText(secondaryText);
    }

    public void setPrimaryText(String str) {
        mPrimaryTextView.setText(str);
    }

    public void setSecondaryText(String str) {
        mSecondaryTextView.setText(str);
    }
}
