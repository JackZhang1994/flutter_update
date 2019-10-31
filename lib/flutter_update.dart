import 'package:flutter/services.dart';

class FlutterUpdate {
  static const MethodChannel _channel = const MethodChannel('flutter_update');

  /// 应用安装
  static void install(String path) {
    _channel.invokeMethod("install", {'path': path});
  }

  /// AppStore跳转
  static void jumpAppStore(String url) {
    _channel.invokeMethod("jump2AppStore", {'url': url});
  }
}
