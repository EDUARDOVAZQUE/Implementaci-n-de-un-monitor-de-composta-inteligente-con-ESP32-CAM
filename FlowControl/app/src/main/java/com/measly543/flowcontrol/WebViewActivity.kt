package com.measly543.flowcontrol

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.measly543.flowcontrol.ui.theme.FlowControlTheme

class WebViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowControlTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // La URL a la que se conectará el WebView
                    WebViewScreen(url = "http://192.168.4.1")
                }
            }
        }
    }
}

@Composable
fun WebViewScreen(url: String) {
    // Usamos AndroidView para integrar un WebView de Android en Compose
    AndroidView(factory = { context ->
        WebView(context).apply {
            // Configuraciones básicas del WebView
            webViewClient = WebViewClient() // Asegura que las URLs se abran dentro del WebView
            settings.javaScriptEnabled = true // Habilita JavaScript
            loadUrl(url) // Carga la URL
        }
    },
        modifier = Modifier.fillMaxSize())
}
