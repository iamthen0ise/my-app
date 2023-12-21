package com.example.myappwebview

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.content.Intent
import android.net.Uri
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var buttonInt: Button
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        buttonInt = findViewById(R.id.buttonInt)
        webView = findViewById(R.id.webView)

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = MyWebViewClient()
    }

    fun openUrlInWebView(view: android.view.View) {
        val url = "<url>"
        webView.loadUrl(url)
        webView.visibility = android.view.View.VISIBLE
    }

    fun openUrlInWebViewWithIntent(view: android.view.View) {
        val url = "<url>"

        val uri = Uri.parse(url)

        val intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            showToast("No app to handle the deep link.")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private inner class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView,
            request: WebResourceRequest
        ): Boolean {
            view.loadUrl(request.url.toString())
            return true
        }
    }
}
