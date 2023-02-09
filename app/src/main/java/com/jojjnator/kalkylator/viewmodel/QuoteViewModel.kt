package com.jojjnator.kalkylator.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jojjnator.kalkylator.interfaces.QuoteRepository
import com.jojjnator.kalkylator.model.QuoteModel
import com.jojjnator.kalkylator.repository.QuoteRepositoryImpl
import kotlinx.coroutines.launch

class QuoteViewModel(
    private val repo: QuoteRepositoryImpl
) : ViewModel() {


    private val vmScope = viewModelScope

    var data: MutableState<QuoteModel?> = mutableStateOf(null)
        private set

     fun newQuote() {
        viewModelScope.launch {
            data.value = repo.getQuote()
        }
    }


    init {
        vmScope.launch {
            data.value = repo.getQuote()
        }

    }

}