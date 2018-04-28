package np.com.sagardevkota.daggertemplate.data.local.sqllite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

import np.com.sagardevkota.daggertemplate.common.Const


open class DBBaseHelper(context: Context)//super(context, Environment.getExternalStorageDirectory()+"/tealdb/" +Const.DATABASE_NAME, null, Const.DATABASE_VERSION);
    : SQLiteOpenHelper(context, Const.DATABASE_NAME, null, Const.DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        // TODO Auto-generated method stub

        val cmd: String

        cmd = "CREATE TABLE IF NOT EXISTS " + Const.TABLE_REPO + "(id INTEGER PRIMARY KEY, name TEXT,full_name TEXT,description TEXT)"
        db.execSQL(cmd)


    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // TODO Auto-generated method stub

        db.execSQL("DROP TABLE IF EXISTS " + Const.TABLE_REPO)

        // Create tables again
        onCreate(db)

    }

}