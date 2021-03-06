/*
 * Copyright 2012 Ivan Masmitjà
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

package net.comapctsys.androlib.samples.widgets;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import net.comapctsys.androlib.samples.R;

public class CheckableLayoutActivity extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] planets = getResources().getStringArray(R.array.planets);
        setListAdapter(new ArrayAdapter<String>(this,
                R.layout.checkable_list_item_1,
                R.id.text1,
                planets));
    }
}
