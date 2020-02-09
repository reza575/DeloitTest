package com.moeiny.reza.deloittest.repository.database

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.moeiny.reza.deloittest.repository.database.dao.PhotoDao
import com.moeiny.reza.deloittest.repository.database.dao.PhotosDao
import com.moeiny.reza.deloittest.repository.database.entitiy.PhotoEntity
import com.moeiny.reza.deloittest.repository.database.entitiy.PhotosEntity

@Database(entities = [(PhotosEntity::class), (PhotoEntity::class)], version = 1, exportSchema = false)

public abstract class AppDatabase : RoomDatabase() {

    abstract fun PhotosDao(): PhotosDao
    abstract fun PhotoDao(): PhotoDao


    companion object {

        private var instance: AppDatabase? = null
        public var DB_NAME = "Photos"

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room
                        .databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return instance!!
        }
    }

    private val roomCallback = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            PopulateDbAsyncTask(instance)
                    .execute()
        }
    }

}

    class PopulateDbAsyncTask(db: AppDatabase?) : AsyncTask<Unit, Unit, Unit>() {
    private val photoDao = db?.PhotoDao()

    override fun doInBackground(vararg p0: Unit?) {
       // photoDao?.insert(PhotoEntity("", "","","","","",""))

      }
    }

