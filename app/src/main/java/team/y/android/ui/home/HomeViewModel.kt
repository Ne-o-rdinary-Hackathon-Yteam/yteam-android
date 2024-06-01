package team.y.android.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import team.y.android.data.homeApiService
import team.y.android.data.model.HomeResponse
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _homeState = MutableStateFlow(HomeUiState())
    val homeState: StateFlow<HomeUiState> = _homeState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                homeApiService.getHome()
            }.onSuccess {
                _homeState.emit(
                    homeState.value.copy(
                        homeState = it,
                    ),
                )
            }.onFailure {
                it.printStackTrace()
            }
        }
    }
}

data class HomeUiState(
    val homeState: HomeResponse? = null,
)
