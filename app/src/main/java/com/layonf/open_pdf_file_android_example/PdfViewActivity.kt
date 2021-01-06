package com.layonf.open_pdf_file_android_example

import android.app.Activity
import android.content.Intent
import android.net.Uri
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
                selectPdfFromStorage()
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

    private fun selectPdfFromStorage(){
        Toast.makeText(this, "selectPDF", Toast.LENGTH_LONG).show()
        val browserStorage = Intent(Intent.ACTION_GET_CONTENT)
        browserStorage.type = "application/pdf"
        browserStorage.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(
            Intent.createChooser(browserStorage, "Select PDF"), PDF_SELECTION_CODE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == PDF_SELECTION_CODE && resultCode == Activity.RESULT_OK && data != null ){
            val selectedPdfFromStorage = data.data
            showPdfFromURI(selectedPdfFromStorage)
        }
    }

    private fun showPdfFromURI(uri: Uri?) {
        pdfView.fromUri(uri)
            .defaultPage(0)
            .spacing(10)
            .load()
    }

    companion object {
        private const val PDF_SELECTION_CODE  = 99
    }
}