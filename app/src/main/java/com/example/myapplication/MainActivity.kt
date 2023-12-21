import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)

        // Enable JavaScript (optional)
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // Load a web page with a GET request
        val url = "https://www.example.com"
        webView.loadUrl(url)
    }
}
