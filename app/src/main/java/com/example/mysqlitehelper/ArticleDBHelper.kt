package com.example.mysqlitehelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ArticleDBHelper(context: Context) : SQLiteOpenHelper(context,DBNAME,null,DBVERSION) {
    override fun onCreate(database: SQLiteDatabase?) {
        val sql = "CREATE TABLE ${DB.TABLE_NAME} ( " +
                "${DB.ID} INTEGER PRIMARY KEY," +
                "${DB.TITLE} TEXT," +
                "${DB.BODY} TEXT" +
                ")"

        database?.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    companion object{
        private const val DBNAME = "markes"
        private const val DBVERSION = 4
    }
}