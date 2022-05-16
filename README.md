# WeatherApp
`MetaWeather`의 Open API를 사용하여 **se로 시작하는 지역의 오늘, 내일 날씨**를 보여주는 앱.

# 프로젝트 구현 결과

https://user-images.githubusercontent.com/64943924/168603331-1d7101ac-10d6-4d66-8755-bc8a4ad93a16.mp4


## 구현 내용
- [x] Hilt 사용하여 의존성 주입
- [x] Coroutines 사용하여 metaweather api 비동기 호출
- [x] DataBinding을 사용해 뷰와 데이터 동기화
- [x] ProgressBar, SwipeRefreshLayout을 사용하여 데이터 로딩 레이아웃 구성

<img src="https://user-images.githubusercontent.com/64943924/168596487-bc2bf359-61fe-4fdd-b65d-fc08eb3bc223.png" width=500>

## 개발 환경
- Android Studio Bumblebee
- minSdk 26, targetSdk 31
- MVVM Pattern
- Library : Coroutine, Retrofit, OkHttp, Hilt, ktx, Glide

## 프로젝트 구조
```
🌞com.doyeon.weatherapp
 ┣ 📁data
 ┃ ┣ 📂api
 ┃ ┣ 📂model
 ┃ ┣ 📂repository
 ┃ ┣ 📂source
 ┣ 📂di
 ┣ 📁domain
 ┃ ┣ 📂model
 ┃ ┣ 📂repository
 ┣ 📂ui
 ┃ ┣ 📂adapter
 ┗ 📂utils
```
