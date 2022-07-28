package me.dio.businesscard

import android.app.Application
import me.dio.businesscard.data.AppDatabase
import me.dio.businesscard.data.BusinessCardRepository

class App : Application() {
    private val database by lazy { AppDatabase.getDatabase( this)}
    val repository by lazy { BusinessCardRepository(database.businessDao())}
}