package com.layonf.open_pdf_file_android_example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.layonf.open_pdf_file_android_example.utils.FileUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpOnClickListener()

    }

    private fun setUpOnClickListener() {

        buttonWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }

        buttonAssets.setOnClickListener {
            val intent = Intent(this, PdfViewActivity::class.java)
            intent.putExtra("ViewType", "assests")
            startActivity(intent)
        }

        buttonStorage.setOnClickListener{
            val intent = Intent(this, PdfViewActivity::class.java)
            intent.putExtra("ViewType", "storage")
            startActivity(intent)
        }

        buttonInternet.setOnClickListener {
            val intent = Intent(this, PdfViewActivity::class.java)
            intent.putExtra("ViewType", "intent")
            startActivity(intent)
        }
    }


}