package com.hrsalterego.puppyproject1.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hrsalterego.puppyproject1.network.ApplicationManager
import com.hrsalterego.puppyproject1.network.DogPhoto
import com.hrsalterego.puppyproject1.network.DogPhotoApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class DogRepository {
    private val serviceScope = CoroutineScope(Dispatchers.Default)

    init {
        serviceScope.launch (Dispatchers.IO) {
            getRandomDog()
        }
    }

    suspend fun getRandomDog() {
        try {
            val dog = DogPhotoApiService.retrofitService.getRandomDogImage()
            ApplicationManager.db.dogDao().insertAll(dog)
        } catch (e: Exception) {
            Log.e("MainViewModel", "Error occurred: ${e.message}")
        }
    }

    fun getDogs(): LiveData<List<DogPhoto>> {
        return ApplicationManager.db.dogDao().getAll()
    }

}