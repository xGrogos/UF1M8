package com.xgrogos.uf1m8.DB

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
// Imports de la classe LolContract.
import com.xgrogos.uf1m8.DB.LolContract.SQL_CREATE_ENTRIES;
import com.xgrogos.uf1m8.DB.LolContract.SQL_DELETE_ENTRIES;
import com.xgrogos.uf1m8.DB.LolContract.SQL_DELETE_ROWS;
import com.xgrogos.uf1m8.DB.LolContract.champion_name;
import com.xgrogos.uf1m8.DB.LolContract.champion_type;
import com.xgrogos.uf1m8.DB.LolContract.champion_description;
import com.xgrogos.uf1m8.DB.LolContract.table_name;
// Import del constructor Lol
import com.xgrogos.uf1m8.Lol;

class LolDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION)  {
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "loldb.db"
    }


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    fun insertLol(l: Lol) {
        val values = ContentValues()
        values.put(champion_name, l.name)
        values.put(champion_type, l.type)
        values.put(champion_description, l.description)

        val db = this.writableDatabase
        db.insert(table_name, null, values)
    }

    fun deleteLol() {
        val db = this.writableDatabase
        db.execSQL(SQL_DELETE_ROWS)
    }

    fun getAllChampions() : ArrayList<Lol> {
        val championList = ArrayList<Lol>()
        val db = this.readableDatabase;
        // Saves the following queries of the database select.
        val cursor : Cursor = db.rawQuery("Select * from " + LolContract.table_name, null)
        if (cursor.moveToFirst()) {
            do {
                // Passing values
                val name: String = cursor.getString(1)
                val type: String = cursor.getString(2)
                val description: String = cursor.getString(3)

                championList.add(Lol(name, type, description))
            } while (cursor.moveToNext())
        }
        db.close()
        db.close()
        return championList
    }
}