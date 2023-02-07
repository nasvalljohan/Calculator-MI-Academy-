package com.jojjnator.kalkylator.di

import org.koin.dsl.module
import com.jojjnator.kalkylator.viewmodel.CalculatorViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

val appModule = module {
    viewModel { CalculatorViewModel() }
}