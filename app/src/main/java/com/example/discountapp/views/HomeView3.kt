package com.example.discountapp.views


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.discountapp.components.Alert
import com.example.discountapp.components.MainButton
import com.example.discountapp.components.MainTextField
import com.example.discountapp.components.SpaceH
import com.example.discountapp.components.TwoCards
import com.example.discountapp.viewModels.CalcularViewModel1
import com.example.discountapp.viewModels.CalcularViewModel2
import com.example.discountapp.viewModels.CalcularViewModel3

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView3(viewModel3: CalcularViewModel3) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "App Descuentos", color = Color.White) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }) {
        ContentHomeView3(it, viewModel3)
    }
}

@Composable
fun ContentHomeView3(paddingValues: PaddingValues, viewModel3: CalcularViewModel3) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val state = viewModel3.state
        TwoCards(
            title1 = "Total",
            number1 = state.totalDescuento,
            title2 = "Descuento",
            number2 = state.precioDescuento
        )

        MainTextField(value = state.precio, onValueChange = { viewModel3.onValue(it, "precio") }, label = "Precio")
        SpaceH()
        MainTextField(value = state.descuento, onValueChange = { viewModel3.onValue(it, "descuento") }, label = "Descuento")
        SpaceH(10.dp)
        MainButton(text = "Generar descuento") {
            viewModel3.calcular()
        }
        SpaceH()
        MainButton(text = "Limpiar para generar otro descuento", Color.Red) {
            viewModel3.limpiar()
        }

        if(state.showAlert){
            Alert(
                title = "Alerta",
                message = "Escribe el precio y descuento",
                confirmText = "Aceptar",
                onConfirmClick = { viewModel3.cancelAlert() }) { }
        }
    }
}

