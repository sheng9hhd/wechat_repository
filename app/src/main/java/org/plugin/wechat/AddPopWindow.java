package org.plugin.wechat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.view.ViewGroup.LayoutParams;

/**
 * Created by cloudplug on 2016-09-07.
 */
public class AddPopWindow  extends PopupWindow {
    private View conentView;

    @SuppressLint("InflateParams")
    public AddPopWindow(final Activity context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(R.layout.popupwindow_add, null);

        this.setContentView(conentView);

        this.setWidth(LayoutParams.WRAP_CONTENT);

        this.setHeight(LayoutParams.WRAP_CONTENT);

        this.setFocusable(true);
        this.setOutsideTouchable(true);

        this.update();

        ColorDrawable dw = new ColorDrawable(0000000000);

        this.setBackgroundDrawable(dw);

        this.setAnimationStyle(R.style.AnimationPreview);

    }

    /**
     * popupWindow
     *
     * @param parent
     */
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {

            this.showAsDropDown(parent, 0, 0);
        } else {
            this.dismiss();
        }
    }
}