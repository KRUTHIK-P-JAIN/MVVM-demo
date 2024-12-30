package com.example.mvvmdemo.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Result::class], version = 1)
abstract class QuotesDB : RoomDatabase(){
    //mention all dao(s)
    abstract fun quotesDao(): QuotesDao

    companion object{
        private var INSTANCE : QuotesDB? = null

        //migrated from version 1 to 2
//        private val MIGRATION_1_2 = object : Migration(1, 2) {
//            override fun migrate(db: SupportSQLiteDatabase) {
//                //query to add column 'isActive'
//                db.execSQL("ALTER TABLE quote ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
//            }
//        }
        fun getDatabase(context: Context): QuotesDB {
            if (INSTANCE == null) {
                //it is multithreaded application. we are using both ui and io thread.
                /* The synchronized(this) block is used to ensure that a section of code is executed by
                only one thread at a time, effectively preventing race conditions when multiple threads
                are accessing shared resources. */
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        QuotesDB::class.java,
                        "quotes_db"
                    )
                        .createFromAsset("quotes.db")
                        //.addMigrations(MIGRATION_1_2)
                        .build()
                }
            }
            //!! is used because, if INSTANCE was null we would have created above.
            return INSTANCE!!
        }
    }
}