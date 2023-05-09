package com.wonddak.mokoresources.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.wonddak.mokoresources.getMyDesc
import com.wonddak.mokoresources.getMyFormatDesc

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val context = LocalContext.current
                    Column() {
                        Text(text = getMyDesc().toString(context))
                        Text(text = getMyFormatDesc("이것은").toString(context))
                    }
                }
            }
        }
    }
}
