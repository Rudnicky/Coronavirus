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

public class InfoSectionView extends LinearLayout {

    private TextView mHeaderText;
    private TextView mContentText;

    public InfoSectionView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // inflate created layout
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.info_section_view, this, true);

        // get custom attributes
        // obtain drawable from particular attribute
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.InfoView);
        Drawable drawable = array.getDrawable(R.styleable.InfoView_imageHeader);
        String headerText = array.getString(R.styleable.InfoView_headerText);
        String primaryText = array.getString(R.styleable.InfoView_contentText);
        array.recycle();

        // image view
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageDrawable(drawable);

        // header text
        mHeaderText = findViewById(R.id.headerText);
        mHeaderText.setText(headerText);

        // primary text
        mContentText = findViewById(R.id.primaryText);
        mContentText.setText(primaryText);
    }
}
