package ru.battatt.profileview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import ru.battatt.profileview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: BaseViewModel = ViewModelProvider(this)[BaseViewModel::class.java]
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        setContentView(binding.root)
        viewModel.init(this, binding)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}