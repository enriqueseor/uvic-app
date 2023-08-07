package cat.teknos.uvicapp.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import cat.teknos.uvicapp.R

class BbvaFragment : Fragment() {

    private var webView: WebView? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bbva, container, false)

        webView = view.findViewById(R.id.webView)
        webView?.settings?.javaScriptEnabled = true
        webView?.webViewClient = WebViewClient()
        webView?.loadUrl("https://www.bbva.es/en/personas/productos/cuentas/cuenta-online-sin-comisiones.html")

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        webView?.parent?.let { (it as ViewGroup).removeView(webView) }
        webView?.destroy()
    }
}