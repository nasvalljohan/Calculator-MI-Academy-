package com.jojjnator.kalkylator.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jojjnator.kalkylator.model.QuoteModel
import com.jojjnator.kalkylator.repository.QuoteRepositoryImpl
import kotlinx.coroutines.launch

class GoTViewModel : ViewModel() {

    private val repo = QuoteRepositoryImpl()
    private val vmScope = viewModelScope

    var data: MutableState<QuoteModel?> = mutableStateOf(null)
        private set

    suspend fun newQuote() {
        data.value = repo.getQuote()
    }


    init {
        vmScope.launch {
            data.value = repo.getQuote()
        }

    }

}