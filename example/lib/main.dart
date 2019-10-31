import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter_update/flutter_update.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: FlatButton(
              onPressed: () {
                if (defaultTargetPlatform == TargetPlatform.iOS) {
                  FlutterUpdate.jumpAppStore("http://itunes.apple.com/us/app/id444934666");
                } else {
                  FlutterUpdate.install('123');
                }
              },
              child: Text('Running on: $_platformVersion\n')),
        ),
      ),
    );
  }
}
