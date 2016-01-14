package com.softgridtech.androiddialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Simpalm on 1/12/16.
 */
public class Dialogutility {

    public static void showCustomDialog(final Context context, String title, String msg, View.OnClickListener listener) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        dialog.setContentView(R.layout.ok_dialog);

        TextView titleTv = (TextView) dialog.findViewById(R.id.title_tv);
        titleTv.setText(title);

        TextView messageTv = (TextView) dialog.findViewById(R.id.message_tv);
        messageTv.setText(msg);

        Button okBtn = (Button) dialog.findViewById(R.id.ok_btn);
        okBtn.setTag(dialog);
        if(null != listener)

        okBtn.setOnClickListener(listener);

        else
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
