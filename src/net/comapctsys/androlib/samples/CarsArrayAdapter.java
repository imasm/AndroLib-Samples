/*
 * Copyright 2013 Ivan Masmitjà
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

package net.comapctsys.androlib.samples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CarsArrayAdapter extends ArrayAdapter<Car>
    {
        int mLayoutId;
        LayoutInflater mInflater;
        SimpleDateFormat mDateFormat;
        NumberFormat mDecimalFormat;

        int mColorCobro;
        int mColorAbono;
        int mColor0;

        public CarsArrayAdapter(Context context, int layoutID, ArrayList<Car> arr)
        {
            super(context, layoutID, arr);

            mLayoutId = layoutID;
            mInflater = LayoutInflater.from(context);
        }

        class ViewHolder
        {
            public TextView tvLicense;
            public TextView tvModel;
            public TextView tvYear;

            ViewHolder(View base)
            {
                tvLicense = (TextView) base.findViewById(R.id.carLicense);
                tvModel = (TextView) base
                        .findViewById(R.id.carModel);
                tvYear = (TextView) base.findViewById(R.id.carYear);
            }
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View rowview = convertView;
            if (rowview == null)
            {
                LayoutInflater inflater = mInflater;
                rowview = inflater.inflate(mLayoutId, parent, false);
            }

            // Holder pattern
            ViewHolder holder = (ViewHolder) rowview.getTag();
            if (holder == null)
            {
                holder = new ViewHolder(rowview);
                rowview.setTag(holder);
            }

            Car car = this.getItem(position);

            if (holder.tvLicense != null)
                holder.tvLicense.setText(car.getLicense());

            if (holder.tvModel != null)
                holder.tvModel.setText(car.getModel());

            if (holder.tvYear != null)
                holder.tvYear.setText(Integer.toString(car.getYear()));

            return rowview;
        }

    }
