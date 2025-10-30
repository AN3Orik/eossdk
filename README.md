# EOS SDK for Java

[![mavencentral](https://img.shields.io/maven-central/v/host.anzo/eossdk)](https://central.sonatype.com/artifact/host.anzo/eossdk)
[![javadoc](https://javadoc.io/badge2/host.anzo/eossdk/javadoc.svg?rnd=)](https://javadoc.io/doc/host.anzo/eossdk)
![](https://img.shields.io/github/license/AN3Orik/eossdk)

Java JNA wrapper for Epic Online Services SDK

## Current status
All possible EOS SDK interfaces/models and callbacks are described, but some JNA-specific errors can happen for untested (gray) interfaces.\
So, let me know via issues if you encounter any problems.

```diff
+green completed
#gray  completed, but not tested
-red   unimplemented

+ Achivements
+ AntiCheatClient
+ AntiCheatServer
+ Auth
+ Connect
# CustomInvites
# Ecom
+ Friends
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
+ ProgressionSnapshot
+ Reports
# RTC
# RTC Audio
# RTC Data
# RTC Admin
+ Sanctions
# Sessions
+ Stats
+ TitleStorage
# UI
# UserInfo
```

## Platform support
Project using JNA library, so all available platforms are supported (for which Epic released a library, of course).

## Distribution
New releases are made available on Maven Central, enabling you to employ your preferred dependency management tool for retrieval.

*Please note that the library version corresponds to the compatible EOS SDK version (with an added wrapper version after last dot)*

```groovy
// Gradle
dependencies {
    // EOS SDK wrapper library
    implementation "host.anzo:eossdk:1.17.1.3.+"
}
```

Of course, for full-fledged work, you will need native EOS SDK libraries. There is two options:
1. Copy native libraries from EOS SDK distribution to your application classpath/resources manually
2. Include Maven Central dependencies additionally to wrapper library (version must be corresponds to EOS SDK version, not to a wrapper version):
```groovy
// Gradle
dependencies {
    // Windows native library
    implementation "host.anzo:eossdk-native-windows:1.17.1.3"
    // Linux native library
    implementation "host.anzo:eossdk-native-linux:1.17.1.3"
    // iOS native library
    implementation "host.anzo:eossdk-native-ios:1.17.1.3"
}
```

## Using & Documentation
During development, I try to preserve the original documentation as much as possible, with an eye to the specifics of [javadoc](https://javadoc.io/doc/host.anzo/eossdk) generating.

So you can use [Official EOS SDK documentation](https://dev.epicgames.com/docs/api-ref)

Also a basic project is available [here](https://github.com/AN3Orik/eossdk/tree/main/eossdk-example) (more just "how-to-use" than ready-to-go example)

## SAST Tools

[PVS-Studio](https://pvs-studio.com/pvs-studio/?utm_source=website&utm_medium=github&utm_campaign=open_source) - static analyzer for C, C++, C#, and Java code.
