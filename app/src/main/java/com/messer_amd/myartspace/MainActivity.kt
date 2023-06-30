package com.messer_amd.myartspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.messer_amd.myartspace.ui.theme.MyArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    val images = listOf(
        R.drawable.sakura_anime,
        R.drawable.sakura_cartoon,
        R.drawable.sakura_classic,
        R.drawable.sakura_cyberpunk,
        R.drawable.sakura_default,
        R.drawable.sakura_picasso
    )
    val artworkTitle = listOf(
        R.string.sakura_title_anime,
        R.string.sakura_title_cartoon,
        R.string.sakura_title_classic,
        R.string.sakura_title_cyberpunk,
        R.string.sakura_title_default,
        R.string.sakura_title_picasso
    )
    val artist = listOf(
        R.string.artist_anime,
        R.string.artist_cartoon,
        R.string.artist_classic,
        R.string.artist_cyberpunk,
        R.string.artist_default,
        R.string.artist_picasso
    )
    var currentIndex by remember { mutableStateOf(0) }
    ArtWithDescription(
        image = painterResource(images[currentIndex]),
        workTitle = stringResource(artworkTitle[currentIndex]),
        artistTitle = stringResource(artist[currentIndex])
    )
    Row(
        modifier = Modifier
            .padding(bottom = 34.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        Button(
            onClick = {
                currentIndex = if (currentIndex > 0) currentIndex - 1
                else currentIndex
            }) {
            Text(text = "Previous", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.width(20.dp))
        Button(
            onClick = {
                currentIndex = (currentIndex + 1) % images.size
            }) {
            Text(text = "Next", fontSize = 20.sp)

        }
    }

}

@Composable
fun ArtWithDescription(
    image: Painter,
    workTitle: String,
    artistTitle: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .padding(4.dp)
                .shadow(elevation = 16.dp)
                .border(border = BorderStroke(14.dp, color = Color.LightGray))
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = workTitle,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(
            text = artistTitle,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(44.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyArtSpaceTheme {
        ArtSpaceApp()
    }
}