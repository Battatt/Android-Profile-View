package ru.battatt.profileview

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.widget.ArrayAdapter
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ru.battatt.profileview.databinding.ActivityProfileBinding

class ProfileViewModel: ViewModel() {
    var activity: AppCompatActivity? = null
    var binding: ActivityProfileBinding? = null
    var launcher: ActivityResultLauncher<Intent>? = null
    val defaultAchievments = arrayListOf(
        Achievment("Born", "19.09.2007"),
        Achievment("Woke up at 5 am", "every Monday"),
        Achievment(),
        Achievment(),
        Achievment(),
        Achievment(),
        Achievment()
    )

    fun init(activity: AppCompatActivity, binding: ActivityProfileBinding){
        this.binding = binding
        this.activity = activity
        this.launcher = activity?.registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback {
                val uriImage = it.data?.data
                binding?.Avatar?.setImageURI(uriImage)
            }
        )
        // Spinner
        val statuses = activity.resources.getStringArray(R.array.statuses)
        val adapter = ArrayAdapter(activity, R.layout.spinner_item, statuses)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.statusSpinner.adapter = adapter

        // RecyclerView
        val achievmentsAdapter = AchievmentAdapter(defaultAchievments)
        this.binding?.achievmentsRV?.adapter = achievmentsAdapter
    }

    fun returnToMainViewOnClick() {
        val intent = Intent(activity, MainActivity::class.java)
        activity?.startActivity(intent)
    }

    fun emailClick() {
        val addresses = arrayOf("batabatmaev@mail.ru")
        val uri = Uri.parse("mailto:")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra(Intent.EXTRA_EMAIL, addresses)
        activity?.startActivity(intent)
    }

    fun phoneNumberClick() {
        val uri = Uri.parse("tel:+7 961-396-03-55")
        val intent = Intent(Intent.ACTION_DIAL, uri)
        activity?.startActivity(intent)
    }

    fun chooseImage() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        launcher?.launch(intent)
    }

}