package com.moeiny.reza.deloittest.repository.database.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Photos")
class PhotosEntity (@PrimaryKey  (autoGenerate = true) var Id:Int,
                    @ColumnInfo var page: Int,
                    @ColumnInfo var pages: Int,
                    @ColumnInfo var perpage: Int,
                    @ColumnInfo var total: String){
    constructor(page:Int,pages: Int,perpage:Int,total: String): this(0,page,pages,perpage,total)
}

