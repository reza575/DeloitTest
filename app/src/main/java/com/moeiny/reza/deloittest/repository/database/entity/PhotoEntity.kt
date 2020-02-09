package com.moeiny.reza.deloittest.repository.database.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Photo")
class PhotoEntity (@PrimaryKey   var Id:String,
                   @ColumnInfo var owner: String,
                   @ColumnInfo var secret: String,
                   @ColumnInfo var url: String,
                   @ColumnInfo var server: String,
                   @ColumnInfo var farm: Int,
                   @ColumnInfo var title: String,
                   @ColumnInfo var ispublic: Int,
                   @ColumnInfo var isfreind: Int,
                   @ColumnInfo var isfamily: Int)

