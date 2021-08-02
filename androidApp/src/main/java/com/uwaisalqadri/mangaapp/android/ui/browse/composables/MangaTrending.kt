package com.uwaisalqadri.mangaapp.android.ui.browse.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uwaisalqadri.mangaapp.android.ui.browse.BrowseViewModel

@Composable
fun MangaTrending(
    viewModel: BrowseViewModel,
    modifier: Modifier
) {
    Column(
        modifier = modifier
    ) {
        viewModel.trendingMangas.value.forEach { manga ->
            Manga(
                manga = manga,
                modifier = Modifier
                    .height(197.dp)
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp)
            )
        }
    }
//    LazyColumn(
//        contentPadding = paddingValues,
//        modifier = modifier
//    ) {
//        items(
//            items = viewModel.trendingMangas.value
//        ) { manga ->
//
//        }
//    }
}