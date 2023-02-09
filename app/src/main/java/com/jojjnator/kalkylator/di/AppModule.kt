package com.jojjnator.kalkylator.di

import com.jojjnator.kalkylator.interfaces.QuoteRepository
import com.jojjnator.kalkylator.network.KtorClient
import com.jojjnator.kalkylator.repository.QuoteRepositoryImpl
import org.koin.dsl.module
import com.jojjnator.kalkylator.viewmodel.CalculatorViewModel
import com.jojjnator.kalkylator.viewmodel.QuoteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

val appModule = module {
    viewModel { CalculatorViewModel() }
    single { KtorClient() }
    single { QuoteRepositoryImpl(get()) }

    viewModel{ QuoteViewModel(get()) }
}