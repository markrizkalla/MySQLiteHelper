package com.example.mysqlitehelper

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.example.mysqlitehelper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var databaseHelper : ArticleDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = ArticleDBHelper(applicationContext)

        addListeners()
    }

    private fun addListeners() {
        binding.btnSave.setOnClickListener{
            val  title = binding.inputTitle.text.toString()
            val  body = binding.inputBody.text.toString()
            val  newEntry = ContentValues().apply {
                put(DB.TITLE,title)
                put(DB.BODY,body)
            }
            databaseHelper.writableDatabase.insert(DB.TABLE_NAME,null,newEntry)

        }

        binding.btnLog.setOnClickListener{
            readData()
        }
    }

    private fun readData() {
        var cursor = databaseHelper.readableDatabase.rawQuery("SELECT * FROM ${DB.TABLE_NAME}",
        arrayOf<String>())

        while (cursor.moveToNext()){
            val id = cursor.getInt(0)
            val title = cursor.getString(1)
            val body = cursor.getString(2)
            Log.d("MARKES","$id - $title - $body")
        }
    }
}