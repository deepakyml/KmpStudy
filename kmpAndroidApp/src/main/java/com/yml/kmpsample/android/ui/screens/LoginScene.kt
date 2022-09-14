//package com.yml.kmpsample.android.ui.screens
//
//import android.media.AudioAttributes
//import android.media.AudioManager
//import android.media.MediaPlayer
//import android.os.Build
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.constraintlayout.compose.ConstraintLayout
//import com.skydoves.landscapist.glide.GlideImage
//import kotlinx.coroutines.launch
//import java.io.IOException
//
//
//@Composable
//fun LoginView(modifier: Modifier=Modifier) {
//
//    var text = rememberSaveable { mutableStateOf("") }
//    val coroutineScope = rememberCoroutineScope()
//
//    val ctx = LocalContext.current
//    ConstraintLayout(modifier = modifier.fillMaxSize()) {
//              val (bgImage, card,avatar) = createRefs()
//              GlideImage(
//                  modifier = Modifier
//                      .constrainAs(bgImage) {
//                          top.linkTo(parent.top)
//                          start.linkTo(parent.start)
//                          end.linkTo(parent.end)
//                          bottom.linkTo(parent.bottom)
//                      },
//                  imageModel = ImageUtils().getAblurredBackgroundImage(),
//                  contentScale = ContentScale.FillBounds)
//
//        Card(modifier = Modifier
//            .constrainAs(card) {
//                top.linkTo(parent.top)
//                start.linkTo(parent.start)
//                end.linkTo(parent.end)
//                bottom.linkTo(parent.bottom)
//            }
//            .padding(12.dp), elevation = 12.dp,shape = RoundedCornerShape(50.dp)) {
//            Column(Modifier.padding(top = 70.dp, start = 12.dp, end = 12.dp, bottom = 12.dp)) {
////                TextField(  value = text.value,
////                  onValueChange = {
////                      text.value = it
////                  },modifier = Modifier
////                        .padding(16.dp)
////                        .background(MaterialTheme.colors.surface, RoundedCornerShape(4.dp))
////                        .padding(12.dp)
////                        .fillMaxWidth())
//
//                OutlinedTextField(value=text.value, onValueChange = {
//                    text.value = it
//                }, label = { Text("Email or Phone") },modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxWidth(), shape = RoundedCornerShape(15.dp))
//
//                Button(onClick = {
//                    coroutineScope.launch {
//                        val data= DictionaryApi().lookupWord(text.value)
//                        var audioUrl = data.first().phonetics?.first()?.audio
//                        val mediaPlayer = MediaPlayer()
//
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                            mediaPlayer.setAudioAttributes(
//                                AudioAttributes.Builder()
//                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//                                    .build()
//                            )
//                        } else {
//                            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
//                        }
//
//                        try {
//                            mediaPlayer.setDataSource(audioUrl)
//                            mediaPlayer.prepare()
//                            mediaPlayer.start()
//                        } catch (e: IOException) {
//                            e.printStackTrace()
//                        }
//                    }
//                }, modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(12.dp),shape = RoundedCornerShape(15.dp)) {
//
//                    Text(text = "Sign in", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
//                }
//
//            }
//
//        }
//
//
//        GlideImage(
//            modifier = Modifier
//                .constrainAs(avatar) {
//                    top.linkTo(card.top)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    bottom.linkTo(card.top)
//                }
//                .size(150.dp)
//                .clip(CircleShape)                       // clip to the circle shape
//                .border(1.dp, Color.Black, CircleShape),
//            imageModel = ImageUtils().getTodaysBotAvatar(),
//            contentScale = ContentScale.Fit)
//
//
//
//          }
//
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    SkunKTheme {
//        LoginView()
//    }
//}