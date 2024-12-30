package com.example.mvvmdemo

import android.app.Application
import com.example.mvvmdemo.model.QuotesApi
import com.example.mvvmdemo.model.QuotesDB
import com.example.mvvmdemo.model.QuotesRepository
import com.example.mvvmdemo.model.RetrofitHelper

class QuotesApplication : Application() {

    lateinit var quoteRepository: QuotesRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        val database = QuotesDB.getDatabase(applicationContext)
        quoteRepository = QuotesRepository(quoteService, database, applicationContext)
    }
}