package ru.battatt.profileview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import ru.battatt.profileview.databinding.ActivityProfileBinding

class ProfileActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: ProfileViewModel =
            ViewModelProvider(this)[ProfileViewModel::class.java]
        val binding: ActivityProfileBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_profile)

        setContentView(binding.root)
        viewModel.init(this, binding)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

    }
}