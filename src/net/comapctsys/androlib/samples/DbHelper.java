package net.comapctsys.androlib.samples;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import net.compactsys.androlib.data.SQLParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "androlib_db";
    public static final int DATABASE_VERSION = 1;

    private Context mContext;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Resources res = mContext.getResources();
        InputStream ins = res.openRawResource(R.raw.database_v1);
        BufferedReader br = new BufferedReader(new InputStreamReader(ins));
        try {
            String[] sqlstrings = SQLParser.parseSqlFile(br);
            for (String sql : sqlstrings) {
                db.execSQL(sql);
            }
        } catch (Exception ex) {

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
