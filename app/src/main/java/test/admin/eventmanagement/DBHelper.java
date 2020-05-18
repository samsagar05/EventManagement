package test.admin.eventmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "event.db";

    private ContentValues cValues;
    private SQLiteDatabase dataBase = null;

    private String CREATE_TABLE_EVENT;

    private String CREATE_TABLE_USER;

    public  static final String TABLE_EVENT="tbl_event";

    public  static final String TABLE_USER="tbl_user";

    public  static final String COL_EVE_NAME="ev_name";
    public  static final String COL_EVE_IMG="ev_img";
    public  static final String COL_EVE_DATE="ev_date";
    public  static final String COL_EVE_CAPT="ev_cap";
    public  static final String COL_EVE_DETAILS="ev_det";


    public  static final String COL_USER_NAME="user_name";
    public  static final String COL_USER_EMAIL="user_email";
    public  static final String COL_USER_MOBILE="user_mobile";
    public  static final String COL_USER_PASS="user_pass";
    public  static final String COL_USER_COLG="user_colg";
    public  static final String COL_USER_ID="user_id";



    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL("PRAGMA FOREIGN_KEYS=ON ");
    }

    public DBHelper(Context context) {
        super(context,  DATABASE_NAME, null, 1);

        }

    @Override
    public void onCreate(SQLiteDatabase db) {

        CREATE_TABLE_EVENT="create table tbl_user(user_id text,user_name text,user_mobile text,user_colg,user_pass)";
        db.execSQL(CREATE_TABLE_EVENT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if EXISTS tbl_user");
        onCreate(db);
    }


    void insertUser(String name,String mobile,String colg,String uname,String pass)
    {

        try {
            dataBase = getWritableDatabase();
        } catch (SQLException s) {
            new Exception("Error with DB Open");
        }
        cValues=new ContentValues();

        cValues.put(COL_USER_NAME,name);
        cValues.put(COL_USER_MOBILE,mobile);
        cValues.put(COL_USER_COLG,colg);
        cValues.put(COL_USER_ID,uname);
        cValues.put(COL_USER_PASS,pass);

        dataBase.insert(TABLE_USER, null, cValues);

        dataBase.close();




    }
}
