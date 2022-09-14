import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yml.kmpsample.android.MainViewModel
import com.yml.kmpsample.android.ui.screens.CollapsedSearchView
import com.yml.kmpsample.android.ui.screens.ExpandedNewsCard
import com.yml.kmpsample.android.ui.screens.ExpandedSearchView
import com.yml.kmpsample.android.ui.screens.NewsCard
import com.yml.kmpsample.models.NewsArticle

@Composable
fun HomeScreen(){
    val viewModel = viewModel<MainViewModel>()
    val searchExpanded = remember{mutableStateOf(false)}
    val showFullNews:MutableState<NewsArticle?> = remember { mutableStateOf(null) }
    Scaffold(
        topBar = {

        }
    ) {
        if(showFullNews.value!=null){
            ExpandedNewsCard(article = showFullNews.value!!) {
                showFullNews.value=null
            }
        }else{
            Column(modifier = Modifier.fillMaxSize().padding(it)) {
                when (val state = viewModel.state.collectAsState().value) {
                    MainViewModel.State.Loading -> {
                        Text("Loading", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
                    }
                    is MainViewModel.State.Data -> {
                        Column(modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .padding(12.dp),verticalArrangement = Arrangement.spacedBy(1.dp)
                        ) {
                            Text(text = "News", modifier = Modifier
                                .padding(start = 12.dp, top = 25.dp), textAlign = TextAlign.Start, color = Color.Black, fontSize = 28.sp,fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(5.dp))
                            state.data.forEach { it ->
                                Spacer(modifier = Modifier.height(5.dp))
                                NewsCard(article = it) { article->
                                    showFullNews.value = article
                                }
                            }
                        }
                    }
                    else -> {
                        //show error image
                    }
                }
            }
    }
    }

}