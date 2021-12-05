package com.hrsalterego.puppyproject1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.hrsalterego.puppyproject1.network.DogPhoto
import com.hrsalterego.puppyproject1.network.DogPhotoApi

class DogViewModel: ViewModel() {
private val _dogPhoto = MutableLiveData<DogPhoto>()
    val dogPhoto: LiveData<DogPhoto> = _dogPhoto

    init {
        getNewPhoto()
    }

fun getNewPhoto() {
    viewModelScope.launch {
        _dogPhoto.value = DogPhotoApi.retrofitService.getRandomPhoto()
    }
}

}
