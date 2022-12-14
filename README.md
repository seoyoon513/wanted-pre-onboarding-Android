# NewsApp
News API를 활용한 android 뉴스앱 입니다. 

*삭제 기능 미완

## 주요기능
* Retrofit을 이용한 서버 통신 결과 해당 뉴스 정보를 recycler view로 나타냈습니다
* 해당 뉴스를 클릭하면 상세 내용을 볼 수 있습다
* DataBinding을 사용하여 선언적 방식으로 데이터를 연결하였습니다
* 해당 뉴스 클릭 시 adapter에서 글로벌 액션으로 처리하여 불필요한 코드를 줄였습니다

### 1. TopNews screen
<img src="https://user-images.githubusercontent.com/110798031/190167327-3e294e45-5c3d-487c-a017-d12ee2cc59dc.png" width="225" height="400"><img src="https://user-images.githubusercontent.com/110798031/190167340-92dd2197-92d7-4250-bee7-e3dabf4b8d65.png" width="225" height="400">

### 2. Category screen
<img src="https://user-images.githubusercontent.com/110798031/190168990-4ac3123b-75df-453a-b3be-5cea54223284.png" width="225" height="400"><img src="https://user-images.githubusercontent.com/110798031/190169006-fe9eb3e5-a4f6-4d62-8dd3-5162cb29b444.png" width="225" height="400"><img src="https://user-images.githubusercontent.com/110798031/190169041-127fbf36-a387-430a-91a2-bcad74c1b245.png" width="225" height="400">

### 3. Saved screen
<img src="https://user-images.githubusercontent.com/110798031/190287500-0220d554-557b-4f1e-bba9-842fa87436af.png" width="225" height="400"><img src="https://user-images.githubusercontent.com/110798031/190287514-f0227a97-66ed-4c51-bc75-5f1df5b39ee8.png" width="225" height="400"><img src="https://user-images.githubusercontent.com/110798031/190287520-bad8a7d6-1917-470c-bcdd-c99a190f1546.png" width="225" height="400">


## 구조
```bash
├── database
│   ├── AppDataBase
│   ├── SavedNews
│   └── SavedNewsDao
├── model
│   └── News
├── network
│   ├── NewsApi
│   └── NewsApiClient
├── repository
│   ├── SavedNewsRepository
│   └── TopNewsRepository
├── ui
│   ├── adapter
│   │   └── TopNewsAdapter
│   ├── common
│   │   ├── BaseFragment
│   │   ├── ImageBindingAdapter
│   │   ├── TextBindingAdapter
│   │   └── ViewModelFactory
│   ├── fragment
│   │   ├── CategoryFragment
│   │   ├── CategoryNewsFragment
│   │   ├── NewsDetailFragment
│   │   ├── SavedFragment
│   │   └── TopNewsFragment
│   └── MainActivity
├── utils
│   └── Constant
└──viewmodel
    ├── SavedNewsViewModel
    └── TopNewsViewModel

``` 

## Library
### Jetpack
UI
* Navigation
* RecyclerView
* ConstraintLayout
* fragment

DATA
* Room db

### Kotlin
Android KTX
* Coroutine
* MVVM Pattern

### Server
* Retrofit2

### etc
* Glide
