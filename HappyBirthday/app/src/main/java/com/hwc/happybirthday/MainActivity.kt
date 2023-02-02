package com.hwc.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hwc.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    BirthdayGreetingWithImage(message = stringResource(R.string.happy_birthday_text), from = stringResource(R.string.signature_text))
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
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
        )
        /*
        * 다른 텍스트요소를 추가할 수 있다
        * */
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding()
        )
    }
}

/*
* 안드로이드 resource
* - 이미지와 문자열은 독자적인 관리가 가능하도록 코드로부터 분리해야 한다
* 리소스 그룹화
* - 항상 프로젝트의 res/ 디렉터리에 각 유형에 맞는 리소스를 재배치해야한다
* - drawable:이미지, mipmap:런처아이콘, values:텍스트
* - https://developer.android.com/guide/topics/resources/available-resources?hl=ko
* 프로젝트의 R(안드로이드가 자동으로 생성한다) 클래스에서 생성된 리소스 ID로 리소스에 액세스할 수 있다
* */
@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val image = painterResource(R.drawable.androidparty)
    /*
    * Box 레이아웃
    * 요소를 서로 위에 쌓는다
    * 특정 정렬도 사용할 수 있다
    * */
    Box {
        Image(
            painter = image,
            /*
            * 접근성을 위한 코딩 사례를 따르면 장애가 있는 사용자를 비롯해서 모든 사용자가 앱과 상호작용할 수 있어야 한다
            * UI 요소의 목적을 설명하고 TalkBack 과 함께 사용할 수 있어야하지만 여기서 이 이미지는 단순 배경역할이므로 null 로 생략한다
            * */
            contentDescription = null,
            /*
            * modifier 를 이용해서 요소를 장식하거나 동작을 추가한다
            * */
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message, from)
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
        /*
        * 문자열을 리소스에 저장하고 리소스로부터 불러와서 사용한다
        * */
        BirthdayGreetingWithImage(message = stringResource(R.string.happy_birthday_text), from = stringResource(R.string.signature_text))
    }
}
