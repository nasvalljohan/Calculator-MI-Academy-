package com.jojjnator.kalkylator.di

import org.koin.dsl.module
import com.jojjnator.kalkylator.viewmodel.CalculatorViewModel
import com.jojjnator.kalkylator.viewmodel.GoTViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

val appModule = module {
    viewModel { CalculatorViewModel() }
    viewModel{ GoTViewModel() }
}