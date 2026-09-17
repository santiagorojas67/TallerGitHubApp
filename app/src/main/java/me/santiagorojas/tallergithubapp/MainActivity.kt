package me.santiagorojas.tallergithubapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.santiagorojas.tallergithubapp.ui.theme.TallerGitHubAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TallerGitHubAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.mi_foto),
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )

        Column(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Santiago Rojas",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )

            Text(
                text = "Desarrollador Movil Jr.",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = Color.Blue,
                fontStyle = FontStyle.Italic
            )
        }

        Column(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                .padding(8.dp)
        ) {
            InfoSection(label = "Edad", value = "19 años")
            InfoSection(label = "Correo", value = "srojas20unab.edu.co")
            InfoSection(label = "Ciudad", value = "Bucaramanga")
        }

        Text(
            text = "Contactar",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 16.dp)
                .border(1.dp, Color.Black)
                .background(Color.White)
                .padding(horizontal = 24.dp, vertical = 12.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun InfoSection(label: String, value: String) {
    Text(
        text = label,
        textAlign = TextAlign.Start,
        fontSize = 16.sp,
        color = Color.Red,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        modifier = Modifier
            .background(Color.White)
            .padding(all = 6.dp)
    )

    Text(
        text = value,
        textAlign = TextAlign.Start,
        fontSize = 16.sp,
        color = Color.Black,
        fontStyle = FontStyle.Italic,
        modifier = Modifier
            .background(Color.White)
            .padding(all = 6.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    TallerGitHubAppTheme {
        ProfileScreen()
    }
}
