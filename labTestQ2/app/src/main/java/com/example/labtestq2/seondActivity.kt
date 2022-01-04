package com.example.labtestq2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class seondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seond)
        val intent = this.getIntent()
        val eusername = intent.getStringExtra("username")
        val epassword = intent.getStringExtra("password")

        supportActionBar?.setTitle(eusername)

        //read database
        val db = openOrCreateDatabase("mydata", MODE_PRIVATE, null)
        val sql = "SELECT username, password from user where entiti='$eusername'"
        val cursor = db.rawQuery(sql, null)

        var username = ""
        var password = ""

        while (cursor.moveToNext()){
            username = cursor.getString(0)
            password = cursor.getString(1)
        }
        cursor.close()

        val btnLogout = findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java).apply{

            }
        }

    }
}