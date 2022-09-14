package com.yml.kmpsample.android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.glide.GlideImage
import com.yml.kmpsample.android.ui.theme.KmpSampleTheme
import com.yml.kmpsample.models.NewsArticle
import com.yml.kmpsample.utils.ImageUtils


@Composable
fun NewsCard(article: NewsArticle,    onNewsCLicked: (NewsArticle) -> Unit,) {
    val newsArticle = remember { mutableStateOf(article)}
        Card(modifier = Modifier.clickable { onNewsCLicked(newsArticle.value) }.padding(12.dp)
            .background(Color.White)
            , elevation = 12.dp,shape = RoundedCornerShape(10.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
                newsArticle.value.title?.let {
                    Text(text = it, modifier = Modifier
                        .padding(12.dp)
                        .heightIn(0.dp, 100.dp)
                        .weight(1f), textAlign = TextAlign.Justify, color = Color.Black, fontSize = 18.sp,fontWeight = FontWeight.Bold,    maxLines = 4)
                }
                Spacer(modifier = Modifier.width(5.dp))
      newsArticle.value.urlToImage?.let {GlideImage(
            modifier = Modifier
                .weight(0.5f)
                .heightIn(0.dp, 100.dp)
                .clip(RoundedCornerShape(10.dp)),
            imageModel = newsArticle.value.urlToImage,
            contentScale = ContentScale.FillBounds)
            }
            }
        }
}


@Composable
fun ExpandedNewsCard(article: NewsArticle, onCollapsed: () -> Unit){
    val newsArticle = remember { mutableStateOf(article)}
        Card(modifier = Modifier.fillMaxSize()
            .background(Color.White)
            , elevation = 12.dp,shape = RoundedCornerShape(10.dp)) {
            Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(12.dp)) {
                IconButton(onClick = {
                    onCollapsed()
                }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "back icon")
                }
                Spacer(modifier = Modifier.height(5.dp))
                newsArticle.value.title?.let {
                    Text(text = it, modifier = Modifier.fillMaxWidth()
                        .padding(14.dp), textAlign = TextAlign.Start, color = Color.Black, fontSize = 22.sp,fontWeight = FontWeight.Bold)
                }
                newsArticle.value.urlToImage?.let {
                    GlideImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        imageModel = newsArticle.value.urlToImage,
                        contentScale = ContentScale.FillBounds)
                }
                newsArticle.value.content?.let {
                    Text(text = it, modifier = Modifier.fillMaxWidth()
                        .padding(14.dp), textAlign = TextAlign.Justify, color = Color.Black, fontSize = 18.sp,fontWeight = FontWeight.Bold)
                }
                newsArticle.value.description?.let {
                    Text(text = it, modifier = Modifier.fillMaxWidth()
                        .padding(16.dp), textAlign = TextAlign.Justify, color = Color.Black, fontSize = 15.sp)
                }
            }

        }
}


@Composable
fun labeledDetails(label:String,details:String){
    Column(
        Modifier
            .fillMaxWidth()
            .padding(12.dp)) {
        Text(modifier = Modifier
            .fillMaxWidth(), text = label,textAlign = TextAlign.Start, fontSize = 14.sp)
        Text(modifier = Modifier
            .fillMaxWidth(), text = details,textAlign = TextAlign.Center, fontSize = 16.sp)
    }

}

@Preview(showBackground = true)
@Composable
fun NewsCardPreview() {
    KmpSampleTheme {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(12.dp), contentAlignment = Alignment.Center) {
            NewsCard(NewsArticle("Author","Content","Description","12/12/2022","News Title","some url",ImageUtils().getTodaysBotAvatar()),{})
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ExpandedWordCardPreview() {
    KmpSampleTheme {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(12.dp), contentAlignment = Alignment.Center) {
            ExpandedNewsCard(NewsArticle("Author","Content","Description","12/12/2022","News Title","some url",ImageUtils().getTodaysBotAvatar()),{ })
        }
    }
}