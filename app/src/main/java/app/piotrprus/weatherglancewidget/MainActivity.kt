package app.piotrprus.weatherglancewidget

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.piotrprus.weatherglancewidget.ui.theme.WeatherGlanceWidgetTheme
import app.piotrprus.weatherglancewidget.widget.WidgetConst

class MainActivity : ComponentActivity() {

    val screenText = mutableStateOf("Please open the app from widget")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkOpenedFromWidget(intent)
        setContent {
            WeatherGlanceWidgetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(screenText.value)
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let { newIntent -> checkOpenedFromWidget(newIntent) }
    }

    private fun checkOpenedFromWidget(intent: Intent) {
        val latitude = intent.getDoubleExtra(WidgetConst.LOCATION_WIDGET_LATITUDE, Double.MIN_VALUE)
        val longitude =
            intent.getDoubleExtra(WidgetConst.LOCATION_WIDGET_LONGITUDE, Double.MIN_VALUE)
        val name = intent.getStringExtra(WidgetConst.WIDGET_NAME_KEY)
        if (latitude == Double.MIN_VALUE || longitude == Double.MIN_VALUE) {
            screenText.value = "Please open the app from widget"
        } else {
            screenText.value = name + "\n$latitude" + "\n$longitude"
        }

    }
}

@Composable
fun Greeting(name: String) {
    Box(modifier = Modifier.fillMaxSize().padding(30.dp), contentAlignment = Alignment.Center) {
        Text(text = "Hello $name", style = MaterialTheme.typography.h4)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherGlanceWidgetTheme {
        Greeting("Android")
    }
}