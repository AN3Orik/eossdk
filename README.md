# EOS SDK for Java

![](https://img.shields.io/nexus/s/host.anzo/eossdk?server=https%3A%2F%2Fnexus.anzo.host%2F)
![](https://img.shields.io/github/license/AN3Orik/eossdk)

Java wrapper for Epic Online Services SDK

Work in progress.

## Distribution
Because library in dev state, currently only private snapshot repository is available for tests.

Please note that the library version corresponds to the EOS SDK version.

```groovy
// Gradle
maven { url "https://nexus.anzo.host/repository/maven-snapshots/" }
dependencies {
    // EOS SDK wrapper library
    implementation "host.anzo:eossdk:1.16.1-SNAPSHOT"
    // Windows native library
    implementation "host.anzo:eossdk-native-windows:1.16.1-SNAPSHOT"
    // Linux native library
    implementation "host.anzo:eossdk-native-linux:1.16.1-SNAPSHOT"
    // iOS native library
    implementation "host.anzo:eossdk-native-ios:1.16.1-SNAPSHOT"
}
```
