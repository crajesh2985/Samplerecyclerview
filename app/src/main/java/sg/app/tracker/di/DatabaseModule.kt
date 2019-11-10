package sg.app.tracker.di

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import sg.app.tracker.room.AppDatabase


val roomModule = module {
    single { AppDatabase.getInstance(androidApplication()) }
    single(createdAtStart = false) { get<AppDatabase>().getFriendDetailsDAO() }
    single(createdAtStart = false) { get<AppDatabase>().getToolDetailsDAO() }
}