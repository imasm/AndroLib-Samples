/*
 * Copyright (c) 2013. Ivan Masmitjà
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.comapctsys.androlib.samples.apps;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import net.comapctsys.androlib.samples.Car;
import net.comapctsys.androlib.samples.CarsArrayAdapter;
import net.comapctsys.androlib.samples.R;
import net.compactsys.androlib.apps.dialog.MultiChoiceDialogFragment;
import net.compactsys.androlib.apps.dialog.ProgressDialogFragment;

public class DialogsActivity extends Activity {
    private final int MAX_PROGRESS = 100;
    private ProgressDialogFragment mProgressDialog;
    private int mProgress;
    private Handler mProgressHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);

        mProgressHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                ProgressDialogFragment pdf = (ProgressDialogFragment) getFragmentManager().findFragmentByTag("progressDialog");

                if (pdf != null) {
                    if (mProgress >= MAX_PROGRESS) {
                        pdf.dismiss();
                    } else {
                        mProgress++;
                        pdf.setProgress(mProgress);
                        mProgressHandler.sendEmptyMessageDelayed(0, 100);
                    }
                }
            }
        };
    }

    public void onClickHandler(View v) {
        String message;
        String title;

        switch (v.getId()) {
            case R.id.btn_demo_progress_dialog_fragment:
                mProgress = 0;

                message = getString(R.string.progress_waiting);
                title = getString(R.string.progress_title);
                // Create the fragment and show it as a dialog.
                mProgressDialog = ProgressDialogFragment.newInstance(title, message, ProgressDialog.STYLE_HORIZONTAL, false);
                mProgressDialog.show(getFragmentManager(), "progressDialog");
                mProgressDialog.setMax(MAX_PROGRESS);
                mProgressDialog.setProgress(0);
                mProgressHandler.sendEmptyMessage(0);
                break;

            case R.id.btn_demo_multichoice_dialog_fragment:

                title = getString(R.string.multichoice_title);
                final MultiChoiceDialogFragment mdf = MultiChoiceDialogFragment.newInstance(title, false);

                mdf.setPositiveButton(getString(R.string.select), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListView lv = mdf.getListView();
                        String result = "Selected items: ";
                        if (lv != null) {
                            SparseBooleanArray sba = lv.getCheckedItemPositions();
                            for (int i = 0; i < sba.size(); i++) {
                                if (sba.valueAt(i)) {
                                     result += sba.keyAt(i) + ",";
                                }
                            }
                        }

                        Toast.makeText(DialogsActivity.this, result, Toast.LENGTH_LONG).show();

                        mdf.dismiss();
                    }
                });

                mdf.setNegativeeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mdf.dismiss();
                    }
                });

                mdf.setAdapter(new CarsArrayAdapter(this, R.layout.multichoice_car_item, Car.createDemo()));

                mdf.show(getFragmentManager(), "multiChoiceDialog");
                break;
        }
    }


}
