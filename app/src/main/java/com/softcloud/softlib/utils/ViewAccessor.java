package com.softcloud.softlib.utils;

import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by j-renzhexin on 2016/8/26.
 */
public class ViewAccessor {

    View rootView;

    protected ViewAccessor(View rootView) {
        this.rootView = rootView;
    }

    public static ViewAccessor create(View rootView) {
        return new ViewAccessor(rootView);
    }

    public ViewAccessor setVisibility(int vId, int visibility) {
        View v = rootView.findViewById(vId);
        ViewHelper.setVisibility(v, visibility);
        return this;
    }

    public ViewAccessor setTextFromHtml(int textViewId, String formatHtml) {
        View tv = rootView.findViewById(textViewId);
        if (tv instanceof TextView) {
            ViewHelper.setTextFromHtml((TextView)tv, formatHtml);
        }
        return this;
    }

    public ViewAccessor setText(int textViewId, CharSequence text) {
        return setText(textViewId, text, 0);
    }

    public ViewAccessor setText(int textViewId, CharSequence text, int colorId) {
        View tv = rootView.findViewById(textViewId);
        if (tv instanceof TextView) {
            ViewHelper.setText((TextView)tv, text, colorId);
        }
        return this;
    }

    public ViewAccessor setTextNumber(int textViewId, double number) {
        View tv = rootView.findViewById(textViewId);
        if (tv instanceof TextView) {
            ViewHelper.setTextNumber((TextView)tv, number);
        }
        return this;
    }

    public ViewAccessor setTextNumber(int textViewId, float number) {
        View tv = rootView.findViewById(textViewId);
        if (tv instanceof TextView) {
            ViewHelper.setTextNumber((TextView)tv, number);
        }
        return this;
    }

    public ViewAccessor setTextNumber(int textViewId, int number) {
        View tv = rootView.findViewById(textViewId);
        if (tv instanceof TextView) {
            ViewHelper.setTextNumber((TextView)tv, number);
        }
        return this;
    }

    public ViewAccessor setTextColor(int textViewId, int colorId) {
        View tv = rootView.findViewById(textViewId);
        if (tv instanceof TextView) {
            ViewHelper.setTextColor((TextView)tv, colorId);
        }
        return this;
    }

    public ViewAccessor setTextDrawableRight(int textViewId, @DrawableRes int drawableResId) {
        View tv = rootView.findViewById(textViewId);
        if (tv instanceof TextView) {
            ViewHelper.setTextDrawableRight((TextView)tv, drawableResId);
        }
        return this;
    }

    public ViewAccessor setTextDrawableLeft(int textViewId, @DrawableRes int drawableResId) {
        View tv = rootView.findViewById(textViewId);
        if (tv instanceof TextView) {
            ViewHelper.setTextDrawableLeft((TextView)tv, drawableResId);
        }
        return this;
    }

    public ViewAccessor setBackground(int vId, int colorId) {
        View v = rootView.findViewById(vId);
        ViewHelper.setBackground(v, colorId);
        return this;
    }

    public ViewAccessor setBackgroundResource(int vId, @DrawableRes int resId) {
        View v = rootView.findViewById(vId);
        ViewHelper.setBackgroundResource(v, resId);
        return this;
    }

    public ViewAccessor setImage(int imageViewId, int imageResId) {
        View v = rootView.findViewById(imageViewId);
        if (v instanceof ImageView) {
            ViewHelper.setImage((ImageView) v, imageResId);
        }
        return this;
    }

    public ViewAccessor setOnClickListener(int viewId, View.OnClickListener listener) {
        View v = rootView.findViewById(viewId);
        ViewHelper.setOnClickListener(v, listener);
        return this;
    }

    public ViewAccessor setEnabled(int viewId, boolean enable) {
        View v = rootView.findViewById(viewId);
        ViewHelper.setEnabled(v, enable);
        return this;
    }

    public ViewAccessor setSelected(int viewId, boolean selected) {
        View v = rootView.findViewById(viewId);
        ViewHelper.setSelected(v, selected);
        return this;
    }

    public ViewAccessor setOnTouchListener(int viewId, View.OnTouchListener listener) {
        View v = rootView.findViewById(viewId);
        ViewHelper.setOnTouchListener(v, listener);
        return this;
    }
}
