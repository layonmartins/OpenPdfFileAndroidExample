package com.layonf.open_pdf_file_android_example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.layonf.open_pdf_file_android_example.utils.FileUtils
import kotlinx.android.synthetic.main.activity_pdf_view.*

class PdfViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_view)
        checkPdfAction(intent)
    }

    private fun checkPdfAction(internet: Intent) {
        when (intent.getStringExtra("ViewType")) {
            "assests" -> {
                // perform action to show pdf from assets
                showPdfFromAssets(FileUtils.getPdfNameFromAssets())
            }
            "storage" -> {
                // perform action to show pdf from assets
            }
            "internet" -> {
                // perform action to show pdf from assets
            }
        }
    }

    private fun showPdfFromAssets(pdfName: String) {
        pdfView.fromAsset(pdfName)
            .password(null)
            .defaultPage(0)
            .onPageError { page, _ ->
                Toast.makeText(this@PdfViewActivity,
                    "Error at page: $page", Toast.LENGTH_LONG)
                    .show()
            }.load()
    }
}