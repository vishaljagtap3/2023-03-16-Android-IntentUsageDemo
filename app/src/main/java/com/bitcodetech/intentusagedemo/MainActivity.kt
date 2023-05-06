package com.bitcodetech.intentusagedemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import com.bitcodetech.intentusagedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        StrictMode.setVmPolicy( StrictMode.VmPolicy.Builder().build())

        binding.img.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 1)
        }

        binding.btnShow.setOnClickListener {
            val intent = Intent("com.bitcodetech.media.VIEW")

            intent.action = "com.bitcodetech.media.VIEW"
            intent.addCategory("com.bitcodetech.cat.GENERAL")
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "image/jpeg"
            )

            startActivity(intent)
        }

        binding.btnShowInGal.setOnClickListener {
            //val intent = Intent("android.intent.action.VIEW")
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "image/jpeg"
            )

            startActivity(intent)
        }

        binding.btnAudio.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "audio/mp3"
            )

            startActivity(intent)
        }

        binding.btnVideo.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "video/mp4"
            )

            startActivity(intent)
        }

        binding.btnShare.setOnClickListener {
            //val intent = Intent("android.intent.action.VIEW")
            val intent = Intent(Intent.ACTION_SEND)
            intent.setDataAndType(
                Uri.parse(binding.edtPath.text.toString()),
                "image/jpeg"
            )

            startActivity(intent)
        }

        binding.btnWeb.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(binding.edtPath.text.toString())

            startActivity(intent)
        }

        binding.btnDial.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse(binding.edtPath.text.toString())
            startActivity(intent)
        }

        binding.btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse(binding.edtPath.text.toString())
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(data == null) {
            return
        }

        Log.e("tag", data.data!!.toString())
        binding.img.setImageURI(data.data)
    }
}