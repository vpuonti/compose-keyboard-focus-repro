package fi.keyboard.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fi.keyboard.sample.ui.theme.KeyboardFocusReproTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KeyboardFocusReproTheme {
                Repro()
            }
        }
    }
}

@Composable
fun Repro() {
    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {

        var usePadding by remember {
            mutableStateOf(false)
        }

        Text(
            modifier = Modifier.padding(
                16.dp
            ),
            text = """
                Instructions: 
                - control the focus with keyboard
                - focus the BasicTextField
                - press dpad left and right to move the cursor
                - press the button to toggle BasicTextField horizontal padding
                - move focus to the BasicTextField
                - pressing dpad left moves focus to the button instead of moving the cursor
                """.trimIndent()
        )

        Button(
            onClick = {
                usePadding = !usePadding
            },
        ) {
            Text("Toggle TextField padding")
        }

        var tfValue by remember {
            mutableStateOf(TextFieldValue("text_field"))
        }

        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = if(usePadding){ 16.dp } else {0.dp}
                ),
            value = tfValue,
            onValueChange = {
                tfValue = it
            },
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KeyboardFocusReproTheme {
        Repro()
    }
}