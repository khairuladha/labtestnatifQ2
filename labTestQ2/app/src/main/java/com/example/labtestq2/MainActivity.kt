package com.example.labtestq2

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.openOrCreateDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(!dbExists(this, "mydata")){
            createDB();

        }

        val uname = findViewById<TextView>(R.id.txtUsername)
        val pass = findViewById<TextView>(R.id.txtPass)


        val btnlogin = findViewById<Button>(R.id.btnSubmit)
        btnlogin.setOnClickListener(){


            val valueUsername = uname
            val valuePass = pass
            val intent = Intent(this, seondActivity::class.java).apply {
                putExtra("username", valueUsername.toString())
                putExtra("password", valuePass.toString())
            }
            startActivity(intent)
        }


    }

    private fun dbExists(c: Context, dbName: String):Boolean{
        val dbFile: File = c.getDatabasePath(dbName)
        return dbFile.exists()
    }

    private fun createDB(){
        val db = openOrCreateDatabase("mydata", MODE_PRIVATE ,null)
        subToast("Database mydata created")
        val sqlText = "CREATE TABLE IF NOT EXISTS user" +
                "(username VARCHAR(30) PRIMARY KEY, " +
                "password VARCHAR(30) NOT NULL " +
                ");"
        subToast("Table user created")
        db.execSQL(sqlText)
        var nextSQL = "INSERT INTO user(username, password) VALUES ('ahmad', 'ahmad1234');"
        db.execSQL(nextSQL)
        subToast("1 sample user added!")
    }



private fun subToast(msg: String){
        Toast.makeText(this ,msg, Toast.LENGTH_SHORT).show()
    }

}