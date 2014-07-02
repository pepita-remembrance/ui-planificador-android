package uqbar.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;

public class EnvironmentUtils {

  public static boolean isDebuggable(Context context){
    return ( 0 != ( context.getApplicationInfo().flags &= ApplicationInfo.FLAG_DEBUGGABLE ) );
  }
}
