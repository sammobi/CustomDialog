package com.softgridtech.androiddialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Simpalm on 1/13/16.
 */


public class CustomDialogActivity {


    public static void showCustomDialog(final Context context, String title, String msg, final String result, View.OnClickListener listener) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


        dialog.setContentView(R.layout.activity_custom__dialog);

        final TextView mResultsTv = (TextView) dialog.findViewById(R.id.resultsTv);

        SeekBar mBrightnessSkbr = (SeekBar) dialog.findViewById(R.id.brightnessSkbr);

        mBrightnessSkbr.setMax(20);
        mBrightnessSkbr.setProgress(0);
        mBrightnessSkbr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mResultsTv.setText(result + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setSecondaryProgress(seekBar.getProgress());

            }
        });

        Button okBtn = (Button) dialog.findViewById(R.id.loginbtn);

        if (null != listener)

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
