@echo off
:: eossdk-native-windows
gradlew.bat :eossdk-native-windows:jreleaserConfig --git-root-search
pause
gradlew.bat :eossdk-native-windows:clean && gradlew.bat :eossdk-native-windows:publish
pause
gradlew.bat :eossdk-native-windows:jreleaserDeploy
pause

:: eossdk-native-linux
gradlew.bat :eossdk-native-linux:jreleaserConfig --git-root-search
pause
gradlew.bat :eossdk-native-linux:clean && gradlew.bat :eossdk-native-linux:publish
pause
gradlew.bat :eossdk-native-linux:jreleaserDeploy
pause

:: eossdk-native-ios
gradlew.bat :eossdk-native-ios:jreleaserConfig --git-root-search
pause
gradlew.bat :eossdk-native-ios:clean && gradlew.bat :eossdk-native-ios:publish
pause
gradlew.bat :eossdk-native-ios:jreleaserDeploy
pause

:: eossdk
gradlew.bat :eossdk:jreleaserConfig --git-root-search
pause
gradlew.bat :eossdk:clean && gradlew.bat :eossdk:publish
pause
gradlew.bat :eossdk:jreleaserDeploy
pause