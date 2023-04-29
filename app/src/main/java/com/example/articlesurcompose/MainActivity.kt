package com.example.articlesurcompose

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.articlesurcompose.ui.theme.ArticleSurComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticleSurComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleWithImage(
                        stringResource(R.string.article_title),
                        stringResource(R.string.article_introduction),
                        stringResource(R.string.article_corpus)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleWithImage(title: String, introduction: String, corps: String, modifier: Modifier = Modifier) {
    // Chargement de la ressource : bg_(...).png
    val image = painterResource(id = R.drawable.bg_compose_background)

    // Disposition en colonne des éléments de l'écran
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Background Image
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        Text(
            text = introduction,
            textAlign = TextAlign.Justify,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = corps,
            textAlign = TextAlign.Justify,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArticleWithImagePreview() {
    ArticleSurComposeTheme {
        ArticleWithImage(
            stringResource(R.string.article_title),
            stringResource(R.string.article_introduction),
            stringResource(R.string.article_corpus)
        )
    }
}