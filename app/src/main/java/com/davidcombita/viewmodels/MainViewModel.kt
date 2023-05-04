package com.davidcombita.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidcombita.BuildConfig
import com.davidcombita.data.models.CatsUI
import com.davidcombita.domain.GetCatsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val getCatsUseCase: GetCatsUseCase
) : ViewModel() {

    private val _cats = MutableStateFlow(CatsUI())
    val cats: StateFlow<CatsUI> = _cats.asStateFlow()

    init {
        viewModelScope.launch{
            _cats.update { it.copy(loading = true) }
            val cats = getCatsUseCase(BuildConfig.APIKEY)
            if(cats.isSuccessful){
                _cats.update { it.copy(catsInfo = cats.body()!!, error = false) }
            }else{
                _cats.update { it.copy(error = true) }
            }
            _cats.update { it.copy(loading = false) }
        }
    }
}