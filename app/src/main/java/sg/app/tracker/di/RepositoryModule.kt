package sg.app.tracker.di

import org.koin.dsl.module
import sg.app.tracker.repository.SplashRepository
import sg.app.tracker.repository.ToolDetailsRepository


val repositoryModule = module {
    factory { SplashRepository(get(),get(),get()) }
    factory { ToolDetailsRepository(get()) }
}