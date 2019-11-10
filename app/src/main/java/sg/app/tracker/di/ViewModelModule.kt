package sg.app.tracker.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sg.app.tracker.viewmodel.SplashViewModel
import sg.app.tracker.viewmodel.ToolDetailsViewModel


val viewModelModule = module {
    viewModel { SplashViewModel(get()) }

    viewModel { ToolDetailsViewModel(get()) }
}