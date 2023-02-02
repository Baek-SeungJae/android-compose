package com.hwc.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.hwc.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    BirthdayGreetingWithText( "Happy Birthday Sam!", "- from Emma")
                }
            }
        }
    }
}

/*
* jetpack compose 는 android UI 를 빌드하기 위해 사용하는 최신 툴킷이다
* 적은 코드, 강력한 도구, 직관적인 kotlin 기능으로 android UI 개발을 간소화하고 가속화한다
* composable 함수 집합으로 UI 를 빌드할 수 있다
*
* @Composable 어노테이션으로 컴파일러에게 이 함수가 UI로 변환하게 되어있다고 알린다
* function 내부에는 UI 상태만 작성하며, 리턴값이 없다
* composable 함수의 이름은 다음과 같이 지정한다
* - 명사여야 함 : DoneButton()
* - 동사 또는 동사구이면 안 됨 : DrawTextField()
* - 명사화된 전치사이면 안 됨 : TextFieldWithLink()
* - 형용사이면 안 됨 : Bright()
* - 부사이면 안 됨 : Outside()
* - 명사 앞에 명사를 설명하는 형용사를 붙일 수도 있음 : RoundIcon()
* - 기타 자세한 설명은 https://github.com/androidx/androidx/blob/androidx-main/compose/docs/compose-api-guidelines.md#naming-unit-composable-functions-as-entities
* */
@Composable
fun BirthdayGreetingWithText(message: String, from: String) {
    /*
    * 행과 열에 텍스트 요소 정렬
    *
    * UI 계층구조
    * - 하나의 구성요소는 다른 구성요소를 포함할 수 있다
    * - Column, Row, Box 요소는 일반적으로 상위 구성요소 역할을 한다
    *
    * 후행 람다 문법
    * - 마지막 매개변수가 함수일 때, 간단하게 표현할 수 있다
    * */
    Column {
        Text(
            text = message,
            /*
            * 확장 가능한 픽셀(sp)는 글꼴의 측정 단위이다
            * 밀도 독립형 픽셀(dp)는 주로 레이아웃에 사용한다
            * sp와 dp는 단위와 크기가 동일하지만, sp는 휴대전화 설정에서 선택한 선호하는 텍스트 크기에 따라 크기가 조절된다
            * */
            fontSize = 36.sp
        )
        /*
        * 다른 텍스트요소를 추가할 수 있다
        * */
        Text(
            text = from,
            fontSize = 24.sp
        )
    }
}

/*
* Preview 함수를 여러개 지정해도 된다
* split 화면에서는 여러개의 preview 가 이어져서 출력된다
* showSystemUi = true 옵션으로 시계, 데이터, 배터리 등 정보를 표시할 수 있다
* name = 미리보기 제목으로 주석을 달 수 있다
* */
@Preview(showBackground = false, showSystemUi = true, name = "My preview")
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        BirthdayGreetingWithText(message = "happy birthday sam!", from = "from Emma")
    }
}
