package me.dio.githubstage.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import me.dio.githubstage.data.model.Repo
import me.dio.githubstage.domain.ListUserRepositoriesUseCase

class MainViewModel(private val listUserRepositoriesUseCase: ListUserRepositoriesUseCase) : ViewModel() {

    private val _repos = MutableLiveData<State>()
    val repos: LiveData <State> = _repos


    fun getRepoList(user: String) {
        viewModelScope.launch {
            listUserRepositoriesUseCase(user)
                .onStart {
                    _repos.postValue(State.Loading)

                }.catch {
                    _repos.postValue(State.Error(it))

                }
                .collect {
                    _repos.postValue(State.Success(it))

                }
        }
    }

    sealed class State {
        object Loading : State ()
        data class Success (val list: List <Repo>) : State()
        data class Error(val error: Throwable) : State()

    }

}