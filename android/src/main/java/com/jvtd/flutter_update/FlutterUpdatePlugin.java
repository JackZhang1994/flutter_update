package com.jvtd.flutter_update;

import android.content.Context;
import android.content.Intent;

import org.jetbrains.annotations.NotNull;

import java.io.File;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * Description:
 * Author: Jack Zhang
 * create on: 2019-10-31 14:19
 */
public class FlutterUpdatePlugin implements MethodCallHandler
{
  private Context context;

  private FlutterUpdatePlugin(Context context)
  {
    this.context = context;
  }


  //
  // Plugin registration.
  //
  public static void registerWith(Registrar registrar)
  {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_update");
    channel.setMethodCallHandler(new FlutterUpdatePlugin(registrar.context()));
  }

  @Override
  public void onMethodCall(@NotNull MethodCall methodCall, @NotNull Result result)
  {
    if (methodCall.method.equals("install"))
    {
      String path = methodCall.argument("path");
      openFile(path);
    } else
    {
      result.notImplemented();
    }
  }

  /**
   * 安装 文件（APK）
   */
  private void openFile(String path)
  {
    Intent intents = new Intent();
    intents.setAction(Intent.ACTION_VIEW);
    intents.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    FileProvider7.setIntentDataAndType(context, intents, "application/vnd.android.package-archive", new File(path), false);
    context.startActivity(intents);
  }
}
