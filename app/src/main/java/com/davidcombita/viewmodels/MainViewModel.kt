package com.davidcombita.viewmodels

import androidx.lifecycle.ViewModel
import com.davidcombita.domain.GetCatsUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val getCatsUseCase: GetCatsUseCase
) : ViewModel() {
}