# **«Облачное хранилище» frontend**


Frontend предоставлен [Нетологией](https://github.com/netology-code/jd-homeworks/tree/master/diploma/netology-diplom-frontend)

## Описание и запуск FRONT

1. Установите nodejs (версия не ниже 14.15.0) на компьютер, следуя [инструкции](https://nodejs.org/ru/download/).
2. Скачайте [FRONT](./netology-diplom-frontend) (JavaScript).
3. Перейдите в папку FRONT приложения и все команды для запуска выполняйте из неё **netology-diplom-frontend**.
4. Следуя описанию README.md FRONT проекта, запустите nodejs-приложение (npm install...).
5. Можно задать url для вызова своего backend-сервиса.
    1. В файле `.env` FRONT (находится в корне проекта) приложения нужно изменить url до backend, например: `VUE_APP_BASE_URL=http://localhost:8080`.
    2. Пересоберите и запустите FRONT снова: `npm run build`.
    3. Изменённый `url` сохранится для следующих запусков.
6. По умолчанию FRONT запускается на порту 8080 и доступен по url в браузере `http://localhost:8080`.


## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
