package org.techtown.scheduling

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var myHelper : myDBHelper
    lateinit var sqlDB:SQLiteDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_sche_day)

        myHelper = myDBHelper(this)
        //db생성해서 초기화시키는 코드
        sqlDB = myHelper.writableDatabase
        myHelper.onUpgrade(sqlDB,1,2)
        sqlDB.close()
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