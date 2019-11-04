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