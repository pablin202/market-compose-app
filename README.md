# Clean Architecture Stock Market App

Stock Market App demonstrates modern Android development based on MVVM architecture

The purpose of this repository is to demonstrate below:

- Implementation of Android architecture components with Jetpack libraries, such as Hilt and Jetpack Compose.
- Performing background tasks with Kotlin Coroutines.


## 🛠 Tech stack & Open source libraries

- Minimum SDK level 21.
- 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- Hilt for dependency injection.
- Jetpack
  - Lifecycle: Dispose observing data when lifecycle state changes.
  - ViewModel: UI related data holder and lifecycle aware. 
  - Room: Constructs Database by providing an abstraction layer over SQLite to allow fluent database access.
  - [Hilt](https://dagger.dev/hilt/): Dependency Injection.
- Architecture
  - MVVM Architecture: View - DataBinding - ViewModel - Model
  - Repository pattern
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit): Construct the REST APIs and paging network data.
- [Moshi](https://github.com/square/moshi/): A modern JSON library for Kotlin and Java.

## 📷 Previews

<img src="https://user-images.githubusercontent.com/8398530/192728258-32dd445b-61ea-48a2-a2f3-2f4f76a980c2.jpeg" width="300">
