# EOS SDK for Java

![](https://img.shields.io/nexus/s/host.anzo/eossdk?server=https%3A%2F%2Fnexus.anzo.host%2F)
![](https://img.shields.io/github/license/AN3Orik/eossdk)

Java JNA wrapper for Epic Online Services SDK

## Current status
All possible EOS SDK interfaces/models and callbacks are described, but some JNA-specific errors can happen for untested (gray) interfaces.\
So, let me know via issues if you encounter any problems

```diff
+green completed
#gray  completed, but not tested
-red   completed, but known issues exists

+ Achivements
+ AntiCheatClient
+ AntiCheatServer
# Auth
# Connect
# CustomInvites
# Ecom
# Friends
# IntegratedPlatform
# KWS
# Leaderboards
# Lobby
+ Logging
+ Metrics
+ Mods
# P2P
+ Platform
# PlayerDataStorage
# Presence
# ProgressionSnapshot
+ Reports
+ Sanctions
# Sessions
+ Stats
+ TitleStorage
# UI
# UserInfo
```

## Platform support
Because project using JNA library, all available platforms are supported (for which Epic released a library, of course).

## Distribution
Because the library is in active development state, currently only private snapshot repository is available for tests.

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

## Using & Documentation
During development, I try to preserve the original documentation as much as possible, with an eye to the specifics of javadoc generating.

So use [Official EOS SDK documentation](https://dev.epicgames.com/docs/api-ref)

Also a basic project is available [here](https://github.com/AN3Orik/eossdk/tree/main/eossdk-example) (more just "how-to-use" than ready-to-go example)