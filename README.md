# Marvel Comic Viewer
Marvel Comic Viewer is an app that shows you basic information of the 100 most recently sold Marvel comics.

## Features
- View title, description, characters, creators and the cover image of each comic
- Scroll left and right through comics
- Click on the attribution text to visit the comic link on Marvel's website

## Download, build and install
- Pull down repo
- Open in Android Studio
- Ensure that installed Kotlin version is equal to or greater than version specified in app level build.gradle
- Obtain Marvel API keys (public and private)
- Add the following code to local.properties
>MARVEL_PUBLIC_KEY=${your public key}  
>MARVEL_PRIVATE_KEY=${your private key}
- Make Project
- Build and run on emulator or device

## Libraries Used
- __Android Material Components, Navigation Component__: Modern Android build components
- __Android Lifecycle components, ViewModel__: On demand API fetches and configuration change handling
- __Kotlin coroutines__: Asynchronous operations
- __Glide__: Image handling
- __Google Secrets Gradle Plugin__: Hide API keys from codebase
- __Yelp Swagger Gradle Codegen__: Quick API and model codegen from API spec (Note: needed to make extensive code changes after codegen, but this greatly reduced coding time)
- __Retrofit, Moshi, GSON__: API definition and usage
- __Apache Commons Codec__: MD5 Hashing
- __Espresso, JUnit__: Instrument and unit testing