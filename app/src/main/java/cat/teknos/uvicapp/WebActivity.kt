package cat.teknos.uvicapp

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class WebActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_URL = "extra_url"
    }

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        webView = findViewById(R.id.webView)

        // Enable JavaScript (optional)
        webView.settings.javaScriptEnabled = true

        // Retrieve the URL from the intent extras
        val url = intent.getStringExtra(EXTRA_URL)

        // Load the web page using the URL
        loadWebPage(url)
    }

    private fun loadWebPage(url: String?) {
        if (url != null) {
            webView.loadUrl(url)
        } else {
            // Handle invalid URL
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}