package com.hrsalterego.puppyproject1

import coil.load
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hrsalterego.puppyproject1.databinding.ActivityMainBinding
import androidx.activity.viewModels
import androidx.core.net.toUri
import com.hrsalterego.puppyproject1.repository.DogRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: DogViewModel by viewModels()
    private lateinit var repository: DogRepository
    private var breedText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getRandomDogPhoto()

        repository = DogRepository()
    }
    private fun getRandomDogPhoto() {
        val randomPhotoButton = binding.button

        viewModel.dogPhoto.observe(this, {
            val imgUri = it.imageUrl!!.toUri().buildUpon().scheme("https").build()
            binding.imageView.load(imgUri)
        })
        randomPhotoButton.setOnClickListener {
            viewModel.getNewPhoto()
        }
    }

}
