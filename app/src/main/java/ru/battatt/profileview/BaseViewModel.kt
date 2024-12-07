package ru.battatt.profileview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ru.battatt.profileview.databinding.ActivityMainBinding

class BaseViewModel: ViewModel() {
    var activity: AppCompatActivity? = null
    var binding: ActivityMainBinding? = null

    fun init(activity: AppCompatActivity, binding: ActivityMainBinding){
        this.binding = binding
        this.activity = activity
    }

    fun toProfileButtonClick(){
        val intent = Intent(activity, ProfileActivity::class.java)
        activity?.startActivity(intent)
    }
}