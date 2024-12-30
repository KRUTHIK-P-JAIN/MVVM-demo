package com.example.mvvmdemo.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuotesDao {

    @Query("Select * from quote")
    suspend fun getQuotes(): List<Result>

    @Insert
    suspend fun insertQuotes(quote: List<Result>)
}