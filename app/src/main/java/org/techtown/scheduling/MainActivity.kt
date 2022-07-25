package org.techtown.scheduling

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var myHelper : myDBHelper
    lateinit var sqlDB:SQLiteDatabase
    lateinit var testBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testBtn = findViewById(R.id.button)

        myHelper = myDBHelper(this)
        //db생성해서 초기화시키는 코드
        sqlDB = myHelper.writableDatabase
        myHelper.onUpgrade(sqlDB,1,2)
        sqlDB.close()

        testBtn.setOnClickListener{
            var intent = Intent(this, MyScheDay::class.java)
            startActivity(intent)
        }
    }

    inner class myDBHelper(context: Context):SQLiteOpenHelper(context,"scheDB",null,1){
        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL("CREATE TABLE scheTBL (dateName STRING PRIMARY KEY, timeData STRING, myplans CHAR(30));")
        }

        override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS scheTBL")
            onCreate(db)
        }

    }
}