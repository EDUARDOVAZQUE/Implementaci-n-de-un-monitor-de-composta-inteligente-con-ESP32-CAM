package com.measly543.flowcontrol

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.measly543.flowcontrol.ui.theme.FlowControlTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowControlTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConnectionScreen()
                }
            }
        }
    }
}

@Composable
fun ConnectionScreen() {
    val context = LocalContext.current
    val targetSsid = "ESP32-COMPOSTA"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Configuración de Red",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(48.dp))

        // Botón para abrir los ajustes de Wi-Fi
        Button(
            modifier = Modifier.fillMaxWidth(0.8f),
            onClick = {
                val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
                context.startActivity(intent)
            }
        ) {
            Text(text = "Conectar a $targetSsid", modifier = Modifier.padding(8.dp))
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botón para continuar a la siguiente pantalla
        Button(
            modifier = Modifier.fillMaxWidth(0.8f),
            onClick = {
                // Iniciar la nueva actividad con el WebView
                val intent = Intent(context, WebViewActivity::class.java)
                context.startActivity(intent)
            }
        ) {
            Text(text = "Siguiente", modifier = Modifier.padding(8.dp))
        }
    }
}