package com.uwaisalqadri.mangaapp.android.ui.browse.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.rememberCoilPainter
import com.uwaisalqadri.mangaapp.android.ui.theme.MangaTypography
import com.uwaisalqadri.mangaapp.data.souce.remote.response.Manga

@Composable
fun Manga(
    manga: Manga,
    modifier: Modifier = Modifier,
    onReadMore: ((Manga) -> Unit)? = null
) {
    Row(
        modifier = modifier
    ) {
        Card(
            shape = RoundedCornerShape(12.dp)
        ) {
            Image(
                painter = rememberCoilPainter(request = manga.attributes.posterImage.original),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(124.dp)
                    .fillMaxHeight(),
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(20.dp, 5.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            StarRate(modifier = Modifier.fillMaxWidth())

            Text(
                text = getTitle(manga),
                fontSize = 21.sp,
                style = MangaTypography.h1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 11.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "04-05-2019", // TODO: Need Date Formatter
                    fontSize = 12.sp,
                    color = Color.Gray,
                    style = MangaTypography.h1
                )

                Text(
                    text = "Vol.${manga.attributes.volumeCount}",
                    fontSize = 15.sp,
                    style = MangaTypography.h1,
                    modifier = Modifier
                        .padding(start = 7.dp)
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                modifier = Modifier.height(40.dp),
                onClick = {
                    if (onReadMore != null) onReadMore(manga)
                }
            ) {
                Text(
                    text = "Read More",
                    color = Color.White,
                    style = MangaTypography.h1,
                    fontSize = 15.sp
                )
            }
        }
    }
}


@Composable
fun StarRate(
    modifier: Modifier
) {
    Row(
        modifier = modifier
    ) {
        (1..5).forEach { _ ->
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color.Yellow,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

private fun getTitle(manga: Manga): String {
    return when {
        manga.attributes.titles.en.isNotEmpty() -> manga.attributes.titles.en
        manga.attributes.titles.en_jp.isNotEmpty() -> manga.attributes.titles.en_jp
        manga.attributes.titles.en_us.isNotEmpty() -> manga.attributes.titles.en_us
        manga.attributes.titles.ja_jp.isNotEmpty() -> manga.attributes.titles.ja_jp
        else -> "No Title"
    }
}




