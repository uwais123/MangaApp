package com.uwaisalqadri.mangaku.android.ui.search.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.uwaisalqadri.mangaku.domain.model.Manga

@Composable
fun SearchResult(
    manga: Manga,
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp,
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .height(130.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(90.dp)
        ) {
            Image(
                painter = rememberCoilPainter(request = manga.attributes?.posterImage?.original),
                contentDescription = "search image result",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}