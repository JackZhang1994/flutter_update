# flutter_update

* Flutter App版本更新逻辑处理插件，区分平台
* iOS跳转到AppStore
* Android执行apk安装

## 用法

```
   if (defaultTargetPlatform == TargetPlatform.iOS) {
       FlutterUpdate.jumpAppStore(url);
   } else {
       FlutterUpdate.install(filePath);
   }
```

## 重要提示

Android需要将本项目中necessary包下的upload_file_paths.xml文件**copy**到自己项目android -> app -> src -> main -> res -> xml路径中