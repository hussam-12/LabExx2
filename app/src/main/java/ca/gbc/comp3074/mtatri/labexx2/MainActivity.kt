package ca.gbc.comp3074.mtatri.labexx2

import android.R.attr.stepSize
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.gbc.comp3074.mtatri.labexx2.ui.theme.LabExx2Theme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabExx2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   ActionButtons(
                       modifier = Modifier.padding(paddingValues = innerPadding)
                   )
                }
            }
        }
    }
}
@Composable
fun ActionButtons(
    modifier: Modifier = Modifier
){
    var cnt = remember { mutableIntStateOf(0) } // to start the counter from 0
    val context = LocalContext.current

    Column(
        modifier = modifier.fillMaxWidth().padding(40.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = painterResource(id=R.drawable.counter),
                contentDescription = "Application Logo",
                modifier = Modifier.width(1500.dp).height(100.dp)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("${cnt.intValue}")


        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(50.dp)
        ) {
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_EDIT)
                    cnt.intValue--
                          },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green
                )
            ) {
                Text("-", fontSize = 80.sp)
            }
            Button(
                onClick = {
                    val intent = Intent.ACTION_EDIT
                    cnt.intValue++},
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green
                )
            ) {
                Text("+", fontSize = 80.sp)
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = {
                    cnt.intValue = 0

                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                )
            ) {
                Text("Reset", fontSize = 30.sp)
            }
            Button(
                onClick = {
                   val intent = Intent.ACTION_EDIT
                          cnt.intValue },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green
                )
            ) {
                Text("Step", fontSize = 30.sp)
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabExx2Theme {

    }
}