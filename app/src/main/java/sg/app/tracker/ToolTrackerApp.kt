package sg.app.tracker

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import sg.app.tracker.di.repositoryModule
import sg.app.tracker.di.roomModule
import sg.app.tracker.di.viewModelModule


@Suppress("Unused")
class ToolTrackerApp : Application() {

    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidLogger()
            androidContext(this@ToolTrackerApp)
            modules(
                listOf(
                    roomModule,
                    repositoryModule,
                    viewModelModule

                )
            )
        }

    }

}