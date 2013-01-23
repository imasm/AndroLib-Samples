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

import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import net.comapctsys.androlib.samples.DbHelper;
import net.comapctsys.androlib.samples.MyApplication;
import net.comapctsys.androlib.samples.R;
import net.compactsys.androlib.data.SQLParser;

import java.io.*;

public class TestData extends AndroidTestCase {

    public static String[] getSqlStatements() throws IOException
    {
        Resources res = MyApplication.getInstance().getResources();
        InputStream ins = res.openRawResource(R.raw.database_v1);
        BufferedReader br = new BufferedReader(new InputStreamReader(ins));
        return SQLParser.parseSqlFile(br);
    }

    public void testSqlParser() throws IOException {

        String[] sqlstrings = getSqlStatements();

        assertTrue(sqlstrings.length == 10);

        assertTrue(sqlstrings[0].startsWith("CREATE"));
        for (int i=1; i<5;i++)
            assertTrue(sqlstrings[i].startsWith("INSERT INTO suppliers"));

        assertTrue(sqlstrings[5].startsWith("CREATE TABLE customers"));

        for (int i=6; i< 9;i++)
            assertTrue(sqlstrings[i].startsWith("INSERT INTO customers"));

        assertTrue(sqlstrings[9].startsWith("UPDATE suppliers"));
    }

    public void testCreateDatabase() throws IOException {
        File dbFile = getContext().getDatabasePath(DbHelper.DATABASE_NAME);
        if (dbFile.exists())
            dbFile.delete();

        DbHelper dbHelper = new DbHelper(getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db.close();
    }
}
