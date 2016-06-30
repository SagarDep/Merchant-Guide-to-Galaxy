package com.thoughtworks.marchant_guide.ui.fragment.customview;

import com.thoughtworks.marchant_guide.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/*
 * Custom EditText class which does not open softkeyboard on touch and have custom fonts
 * 
 */
public class EditTextNoKeyBoard extends EditText {

	public EditTextNoKeyBoard(Context context) {
		super(context);

	}

	public EditTextNoKeyBoard(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		init(attrs);
	}

	public EditTextNoKeyBoard(Context context, AttributeSet attrs) {
		super(context, attrs);

		init(attrs);
	}

	@Override
	public boolean onCheckIsTextEditor() {
		// TODO Auto-generated method stub
		return false;

	}

	private void init(AttributeSet attrs) {
		if (attrs != null) {
			TypedArray a = getContext().obtainStyledAttributes(attrs,
					R.styleable.CustomTextView);

			String fontName = a.getString(R.styleable.CustomTextView_font);

			try {
				if (fontName != null) {
					Typeface myTypeface = Typeface.createFromAsset(getContext()
							.getAssets(), "fonts/" + fontName);
					setTypeface(myTypeface);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			a.recycle();
		}
	}
}