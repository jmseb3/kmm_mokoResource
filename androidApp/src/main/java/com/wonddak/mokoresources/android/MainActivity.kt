package com.wonddak.mokoresources.android

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.wonddak.mokoresources.User
import com.wonddak.mokoresources.getClose
import com.wonddak.mokoresources.getImage
import com.wonddak.mokoresources.getMyDesc
import com.wonddak.mokoresources.getMyFormatDesc
import com.wonddak.mokoresources.getThemeColor
import com.wonddak.mokoresources.getUserName
import com.wonddak.mokoresources.getValueColor
import dev.icerock.moko.resources.ColorResource
import dev.icerock.moko.resources.ImageResource

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
                        Text(
                            text = getMyDesc().toString(context),
                            color = getValueColor().toColor()
                        )
                        Text(
                            text = getMyFormatDesc("이것은").toString(context),
                            color = getThemeColor().toColor()
                        )
                        Text(text = getUserName(null).toString(context))
                        Text(text = getUserName(User("wonddak",27)).toString(context))
                        Image(painter = getImage().toResource(), contentDescription = "")
                        Icon(painter = getClose().toResource(), contentDescription = "")
                    }
                }
            }
        }
    }
}

@Composable
fun ColorResource.toColor() : Color {
    return colorResource(this.resourceId)
}

@Composable
fun ImageResource.toResource() : Painter {
    return painterResource(id = this.drawableResId)
}