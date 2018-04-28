package np.com.sagardevkota.daggertemplate.data.local.sqllite


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log

import java.util.ArrayList

import np.com.sagardevkota.daggertemplate.common.Const
import np.com.sagardevkota.daggertemplate.data.local.sqllite.DBBaseHelper
import np.com.sagardevkota.daggertemplate.data.models.Repository

class DBRepoHelper// private ServerSyncListener<JSONObject> listener;
(context: Context) : DBBaseHelper(context) {

    // Select All Query
    // looping through all rows and adding to list
    // Adding contact to list
    // return contact list
    val allItems: List<Repository>
        get() {
            val itemlist = ArrayList<Repository>()
            val selectQuery = "SELECT  * FROM " + Const.TABLE_REPO

            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQuery, null)
            if (cursor.moveToFirst()) {
                do {
                    val item = Repository()
                    item.fullName = cursor.getString(1)
                    item.fullName = cursor.getString(2)
                    item.description = cursor.getString(3)
                    itemlist.add(item)
                } while (cursor.moveToNext())
            }
            cursor.close()
            db.close()
            return itemlist
        }

    // Creating Tables
    override fun onCreate(db: SQLiteDatabase) {
        super.onCreate(db)
    }

    // Upgrading database
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Drop older table if existed
        super.onUpgrade(db, oldVersion, newVersion)
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    fun addItem(item: Repository) {
        val db = this.writableDatabase

        val values = ContentValues()
        //values.put("id", "NULL"); // Contact Phone
        values.put("name", item.name) // Contact Name
        values.put("full_name", item.fullName)
        values.put("description", item.description)


        // Inserting Row
        db.insert(Const.TABLE_REPO, null, values)
        db.close() // Closing database connection
        Log.d("sagarda7", "added added")
    }


}