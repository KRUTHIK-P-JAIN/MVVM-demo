package com.example.mvvmdemo.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuotesDao {

    /*the queries which returns LiveData will run in a background thread.
    so, suspend is not required.*/
    @Query("Select * from quote")
    fun getQuotes(): LiveData<List<Quote>>

    @Insert
    suspend fun insertQuotes(quote: Quote)
}