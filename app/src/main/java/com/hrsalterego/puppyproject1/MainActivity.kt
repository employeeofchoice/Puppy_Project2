package com.hrsalterego.puppyproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hrsalterego.puppyproject1.databinding.ActivityMainBinding
import androidx.activity.viewModels
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: DogViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getRandomDogPhoto()
    }
    fun getRandomDogPhoto() {
        val randomPhotoButton = binding.button

        viewModel.dogPhoto.observe(this, {
            val imgUri = it.imageUrl!!.toUri().buildUpon().scheme("https").build()
            binding.imageView.load(imgUri)
        })
        randomPhotoButton.setOnClickListener({
            viewModel.getNewPhoto()
        }
    }
}
    }
}