package com.example.bookpt

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookpt.ui.theme.BookPtTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookPtTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { paddingValues ->
                    Text(
                        text = "Hello, World!",
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }

        val postApi = RetrofitHelper.getInstance().create(postIntreface::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val result = postApi.getPost()
            if (result != null) {
                // Checking the results
                Log.d("ayush: ", result.body().toString())
            }
        }
    }
}