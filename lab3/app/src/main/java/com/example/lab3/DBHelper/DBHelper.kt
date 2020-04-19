package com.example.lab3.DBHelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {


    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY:String = ("Create table  $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY, $COL_TEXT TEXT, $COL_COLOR TEXT, $COL_PRICE TEXT)")

        db!!.execSQL(CREATE_TABLE_QUERY)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
    }

    companion object{
        private val DATABASE_VER=1
        private val DATABASE_NAME = "Orders.db"

        //Table
        private val TABLE_NAME="Order"
        private val COL_ID="id"
        private val COL_TEXT="Text"
        private val COL_COLOR="Color"
        private val COL_PRICE="Price"
    }


}