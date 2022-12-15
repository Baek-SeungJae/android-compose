package com.hwc.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hwc.greetingcard.ui.theme.GreetingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        * setContent 는 구성 가능한 함수를 통해 레이아웃을 정의하는 데 사용
        * */
        setContent {
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

/*
* @Composable 함수는 몇 가지 입력을 받아서 화면에 표시되는 내용을 생성한다
* 함수 이름은 대문자로 시작한다
* 아무것도 반환할 수 없다
* */
@Composable
fun Greeting(name: String) {
    /*
    * Text 의 배경을 다르게 설정하려면 텍스트를 Surface 로 감싸야 한다
    * Surface 는 배경 색상이나 테두리와 같은 모양을 개발자가 변경할 수 있는 UI 섹션을 나타내는 컨테이너이다
    * */
    Surface(color = Color.LightGray) {
        /*
        * Modifier 는 composable 을 강화하거나 장식하는데 사용한다
        * */
        Text(text = "Hi, my name is $name!", modifier = Modifier.padding(24.dp))
    }
}

/*
* @Preview 를 추가하면 미리보기 함수가 된다.
* showBackground = true 를 설정하면 배경이 추가된다
* */
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GreetingCardTheme {
        Greeting("SJ")
    }
}
