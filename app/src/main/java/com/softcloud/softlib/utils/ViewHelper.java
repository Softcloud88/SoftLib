package com.softcloud.softlib.utils;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by j-renzhexin on 2016/8/26.
 */
public class ViewHelper {

    public static void setTextNumber(TextView tv, int number) {
        String text = SafeCast.getString(number);
        setText(tv, text);
    }

    public static void setTextNumber(TextView tv, float number) {
        String text = SafeCast.getString(number);
        setText(tv, text);
    }

    public static void setTextNumber(TextView tv, double number) {
        String text = SafeCast.getString(number);
        setText(tv, text);
    }

    public static void setText(TextView tv, CharSequence text) {
        setText(tv, text, 0);
    }

    public static void setTextFromHtml(TextView tv, String formatHtml) {
        if (tv != null) {
            try {
                tv.setText(Html.fromHtml(formatHtml));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void setText(TextView tv, CharSequence text, int colorId) {
        if (tv != null) {
            tv.setText(text);
            if (colorId != 0) {
                tv.setTextColor(ResUtils.getColor(colorId));
            }
        }
    }

    public static void setTextColor(TextView tv, int colorId) {
        if (tv != null && colorId != 0) {
            tv.setTextColor(ResUtils.getColor(colorId));
        }
    }

    public static void setTextDrawableRight(TextView tv, @DrawableRes int drawableResId) {
        if (drawableResId == 0) {
            return;
        }
        Drawable drawable = ResUtils.getDrawable(drawableResId);
        if (tv != null && drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tv.setCompoundDrawables(null, null, drawable, null);
        }
    }

    public static void setTextDrawableLeft(TextView tv, @DrawableRes int drawableResId) {
        if (drawableResId == 0) {
            return;
        }
        Drawable drawable = ResUtils.getDrawable(drawableResId);
        if (tv != null && drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tv.setCompoundDrawables(drawable, null, null, null);
        }
    }

    public static void setBackground(View view, int colorId) {
        if (view != null) {
            view.setBackgroundColor(ResUtils.getColor(colorId));
        }
    }

    public static void setBackgroundResource(View view, @DrawableRes int resId) {
        if (view != null) {
            view.setBackgroundResource(resId);
        }
    }

    public static void setImage(ImageView iv, int imgResId) {
        if (iv != null) {
            iv.setImageDrawable(ResUtils.getDrawable(imgResId));
        }
    }

    public static void setOnClickListener(View view, View.OnClickListener listener) {
        if (view != null && listener != null) {
            view.setOnClickListener(listener);
        }
    }

    public static void setVisibility(View view, int visibility) {
        if (view != null && (visibility == View.VISIBLE || visibility == View.INVISIBLE
                || visibility == View.GONE)) {
            view.setVisibility(visibility);
        }
    }

    public static void setEnabled(View view, boolean enabled) {
        if (view != null) {
            view.setEnabled(enabled);
        }
    }

    public static void setSelected(View view, boolean selected) {
        if (view != null) {
            view.setSelected(selected);
        }
    }

    public static void setOnTouchListener(View view, View.OnTouchListener listener) {
        if (view != null && listener != null) {
            view.setOnTouchListener(listener);
        }
    }

    @SuppressWarnings("deprecation")
    public static void setBackground(View view, Drawable background) {
        if (view == null)
            return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(background);
        } else {
            view.setBackgroundDrawable(background);
        }
    }

    public static int getListViewHeightBasedOnChildren(ListView listView) {
        int totalHeight = 0;
        if (listView == null)
            return totalHeight;
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return totalHeight;
        }

        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        totalHeight = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        return totalHeight;
    }

    public static int getListViewWidthBasedOnChildren(ListView listView) {
        int width = 0;
        if (listView == null)
            return width;
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return width;
        }

        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            if (width < listItem.getMeasuredWidth()) {
                width = listItem.getMeasuredWidth();
            }
        }
        return width;
    }
}
