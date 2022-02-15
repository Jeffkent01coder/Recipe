package com.jeff.howto

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.jeff.howto.databinding.ActivitySplashBinding
import com.jeff.howto.entities.Category
import com.jeff.howto.interfaces.GetDataService
import com.jeff.howto.retrofitclient.RetrofitClientInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity(),EasyPermissions.RationaleCallbacks,EasyPermissions.PermissionCallbacks {

    private var READ_STORAGE_PERM = 123
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        readStorageTask()

        binding.btnGetStarted.setOnClickListener {
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java ))
            finish()
        }
    }

    fun getCategories(){
        val service = RetrofitClientInstance.retrofitInstance.create(GetDataService::class.java)
        val call = service.getCategoryList()
        call.enqueue(object : Callback<List<Category>>{
            override fun onResponse(call: Call<List<Category>>,response: Response<List<Category>>) {

                insertDataIntoRoomDb(response.body())
            }

            override fun onFailure(call: Call<List<Category>>,t: Throwable) {

                binding.loader.visibility = View.INVISIBLE
                Toast.makeText(this@SplashActivity,"Something Went Wrong",Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun insertDataIntoRoomDb(category: List<Category>?){


    }

    private fun hasReadStoragePermissions(): Boolean {
        return EasyPermissions.hasPermissions(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)
    }


    private fun readStorageTask(){
        if (!hasReadStoragePermissions()){
            getCategories()
        }else{
            EasyPermissions.requestPermissions(
                this,
                "This app needs Permission to your Storage",
                READ_STORAGE_PERM,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults, this)
    }

    override fun onRationaleAccepted(requestCode: Int) {

    }

    override fun onRationaleDenied(requestCode: Int) {

    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {

    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this,perms)){
            AppSettingsDialog.Builder(this).build().show()
        }
    }

}