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

package net.comapctsys.androlib.samples.tests;

import android.test.AndroidTestCase;

import net.compactsys.androlib.util.DateUtils;

import java.util.Calendar;
import java.util.Date;

public class TestDateUtils extends AndroidTestCase {

    public void testDates() {

        // Get Current date
        Calendar cal = Calendar.getInstance();
        Date dnow = cal.getTime();

        // Split date
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        // set time to 0
        Date dtoday = DateUtils.stripTime(dnow);

        // Check Values
        assertTrue(dnow.getTime() >= dtoday.getTime());

        cal.setTime(dtoday);
        assertEquals(cal.get(Calendar.HOUR), 0);
        assertEquals(cal.get(Calendar.MINUTE), 0);
        assertEquals(cal.get(Calendar.SECOND), 0);
        assertEquals(cal.get(Calendar.MILLISECOND), 0);


        // make new Date
        Date d2 = DateUtils.getDate(year, month, day);
        assertTrue(dtoday.equals(d2));
    }
}
