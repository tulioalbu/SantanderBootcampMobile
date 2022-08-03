package me.dio.githubstage

import android.app.Application
import me.dio.githubstage.data.di.DataModule
import me.dio.githubstage.domain.di.DomainModule
import me.dio.githubstage.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application () {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}