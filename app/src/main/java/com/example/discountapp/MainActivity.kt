package com.example.discountapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.discountapp.ui.theme.DiscountappTheme
import com.example.discountapp.viewModels.CalcularViewModel1
import com.example.discountapp.viewModels.CalcularViewModel2
import com.example.discountapp.viewModels.CalcularViewModel3
import com.example.discountapp.views.HomeView
import com.example.discountapp.views.HomeView2
import com.example.discountapp.views.HomeView3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel : CalcularViewModel3 by viewModels()
        setContent {
            DiscountappTheme {
                HomeView3(viewModel)
            }
        }
    }
}