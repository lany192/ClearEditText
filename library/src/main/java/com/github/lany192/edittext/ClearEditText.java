package com.github.lany192.edittext;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;

public class ClearEditText extends AppCompatEditText implements OnFocusChangeListener, TextWatcher {
    private Drawable mLeftDrawable;
    private boolean hasFocus;
    @DrawableRes
    private int mLeftDrawableResId;
    private boolean mClearEnable = false;

    public ClearEditText(Context context) {
        super(context);
        init();
    }

    public ClearEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        initClearIcon();
        initLeftIcon();
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
        setCompoundDrawablePadding(8);
    }

    private void initClearIcon() {
        Drawable clearDrawable = getCompoundDrawables()[2];
        if (clearDrawable == null) {
            clearDrawable = ContextCompat.getDrawable(getContext(), R.drawable.vector_delete_black);
        }
        clearDrawable.setBounds(0, 0, dp2px(20), dp2px(20));
        Drawable right = mClearEnable ? clearDrawable : null;
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], right, getCompoundDrawables()[3]);
    }

    private int dp2px(float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, Resources.getSystem().getDisplayMetrics());
    }

    private void initLeftIcon() {
        if (mLeftDrawableResId > 0) {
            mLeftDrawable = getCompoundDrawables()[0];
            if (mLeftDrawable == null) {
                mLeftDrawable = ContextCompat.getDrawable(getContext(), mLeftDrawableResId);
            }
            mLeftDrawable.setBounds(0, 0, mLeftDrawable.getIntrinsicWidth(), mLeftDrawable.getIntrinsicHeight());
        }
        Drawable left = mLeftDrawable != null ? mLeftDrawable : null;
        setCompoundDrawables(left, getCompoundDrawables()[1], getCompoundDrawables()[2], getCompoundDrawables()[3]);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (getCompoundDrawables()[2] != null) {
                boolean touchable = event.getX() > (getWidth() - getTotalPaddingRight())
                        && (event.getX() < ((getWidth() - getPaddingRight())));
                if (touchable) {
                    this.setText("");
                }
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        this.hasFocus = hasFocus;
        if (hasFocus) {
            setClearIconVisible(getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }
    }

    public void setLeftIconResource(@DrawableRes int resId) {
        mLeftDrawableResId = resId;
        initLeftIcon();
    }

    private void setClearIconVisible(boolean visible) {
        this.mClearEnable = visible;
        initClearIcon();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int count, int after) {
        if (hasFocus) {
            setClearIconVisible(s.length() > 0);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    public void setShakeAnimation() {
        this.setAnimation(shakeAnimation(5));
    }

    public static Animation shakeAnimation(int counts) {
        Animation translateAnimation = new TranslateAnimation(0, 10, 0, 0);
        translateAnimation.setInterpolator(new CycleInterpolator(counts));
        translateAnimation.setDuration(1000);
        return translateAnimation;
    }
}
