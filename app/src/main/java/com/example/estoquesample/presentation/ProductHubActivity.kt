package com.example.estoquesample.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.estoquesample.commons.model.Product
import com.example.estoquesample.viewmodel.ProductViewModel

class ProductHubActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductHubScreen()
                }
            }
        }
    }
}

@Composable
fun ProductHubScreen(viewModel: ProductViewModel = viewModel()) {
    // Exemplo de produto para demonstrar as ações
    val dummyProduct = Product(
        name = "Produto Exemplo",
        code = "ABC-123",
        quantity = 50,
        price = 29.90
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { viewModel.insert(dummyProduct) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text("Inserir Produto")
        }

        Button(
            onClick = { viewModel.update(dummyProduct) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text("Atualizar Produto")
        }

        Button(
            onClick = { viewModel.delete(dummyProduct) },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Deletar Produto")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductHubScreenPreview() {
    MaterialTheme {
        Surface {
            ProductHubScreen()
        }
    }
}
