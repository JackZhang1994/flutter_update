package com.jvtd.flutter_update;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import androidx.core.content.FileProvider;

import java.io.File;

/**
 * Description:
 * Author: Jack Zhang
 * create on: 2019-10-31 14:19
 */
public class FileProvider7
{
  public static Uri getUriForFile(Context context, File file)
  {
    Uri fileUri = null;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
    {
      fileUri = getUriForFile24(context, file);
    } else
    {
      fileUri = Uri.fromFile(file);
    }
    return fileUri;
  }

  private static Uri getUriForFile24(Context context, File file)
  {
    return FileProvider.getUriForFile(context, context.getPackageName() + ".Merchant", file);
  }

  public static void setIntentDataAndType(Context context, Intent intent, String type, File file, boolean writeAble)
  {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
    {
      intent.setDataAndType(getUriForFile(context, file), type);
      intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
      if (writeAble)
      {
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
      }
    } else
    {
      intent.setDataAndType(Uri.fromFile(file), type);
    }
  }

  public static void setIntentData(Context context, Intent intent, File file, boolean writeAble)
  {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
    {
      intent.setData(getUriForFile(context, file));
      intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
      if (writeAble)
      {
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
      }
    } else
    {
      intent.setData(Uri.fromFile(file));
    }
  }
}
