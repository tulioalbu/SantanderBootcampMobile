package me.dio.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import androidx.lifecycle.ViewModelProvider
import me.dio.businesscard.data.BusinessCard
import me.dio.businesscard.data.BusinessCardRepository



class MainViewModel (private val businessCardRepository: BusinessCardRepository) : ViewModel() {

    fun insert (businessCard: BusinessCard) {
        businessCardRepository.insert(businessCard)
    }

    fun getAll() : LiveData<List<BusinessCard>> {
        return businessCardRepository.getAll()
    }
}

class MainViewModelFactory(private val repository: BusinessCardRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if ( modelClass.isAssignableFrom(MainViewModel::class.java) ){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

