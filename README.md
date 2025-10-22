# MyFitness Android Project

## Требования

- Android Studio 2022.3.1 (Giraffe) или новее [подробнее](https://developer.android.com/studio/releases?hl=ru)
- Gradle 8.13
- Минимальная версия SDK: 24
- Kotlin 2.0+
- Устройство с доступом в интернет

## Запуск проекта

### Настройка `local.properties`

В корне проекта отредактируйте файл `local.properties`, добавив в него ссылку на API, откуда будут браться данные. Например:

```properties
sdk.dir=/Users/unit6/Library/Android/sdk
api=https://ref.test.kolsa.ru/
