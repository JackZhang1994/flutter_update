#import "FlutterUpdatePlugin.h"

@implementation FlutterUpdatePlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
   FlutterMethodChannel* channel =
        [FlutterMethodChannel methodChannelWithName:@"flutter_update"
                                    binaryMessenger:registrar.messenger];

    [channel setMethodCallHandler:^(FlutterMethodCall* call, FlutterResult result) {
      if ([@"jump2AppStore" isEqualToString:call.method]) {
        NSString *url = [call.arguments objectForKey:@"url"];
        NSURL *appUrl = [NSURL URLWithString:url];
        [UIApplication.sharedApplication openURL:appUrl];
      } else {
        result(FlutterMethodNotImplemented);
      }
   }];
}
@end
