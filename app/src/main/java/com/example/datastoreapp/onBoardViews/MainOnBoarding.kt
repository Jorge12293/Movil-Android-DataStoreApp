package com.example.datastoreapp.onBoardViews


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.datastoreapp.R
import com.example.datastoreapp.data.PageData
import com.example.datastoreapp.dataStore.StoreBoarding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainOnBoarding(navController: NavController,store: StoreBoarding){
    val items = ArrayList<PageData>()

    items.add(
        PageData(
            image = R.raw.page1,
            title = "Title 1",
            desc = "Lorem ipsum dolor sit amet,Lorem ipsum dolor sit amet,Lorem ipsum dolor sit amet,"
        )
    )
    items.add(
        PageData(
            image = R.raw.page2,
            title = "Title 2",
            desc = "Lorem ipsum dolor sit amet,Lorem ipsum dolor sit amet,Lorem ipsum dolor sit amet,"
        )
    )
    items.add(
        PageData(
            image = R.raw.page3,
            title = "Title 3",
            desc = "Lorem ipsum dolor sit amet,Lorem ipsum dolor sit amet,Lorem ipsum dolor sit amet,"
        )
    )
    items.add(
        PageData(
            image = R.raw.page4,
            title = "Title 4",
            desc = "Lorem ipsum dolor sit amet,Lorem ipsum dolor sit amet,Lorem ipsum dolor sit amet,"
        )
    )

    val pagerState = rememberPagerState (
        pageCount = items.size,
        initialOffscreenLimit = 3,
        infiniteLoop = false,
        initialPage = 0
    )

    OnBoardingPager(
        item = items,
        pagerState = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        navController,
        store
    )
}