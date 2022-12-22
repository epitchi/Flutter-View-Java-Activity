package com.example.flutter_view_java_activity.binding;

import android.content.Context;

import com.example.flutter_view_java_activity.binding.crypto.AndroidCryptoProvider;
import com.example.flutter_view_java_activity.nvstream.http.LimelightCryptoProvider;

public class PlatformBinding {
    public static LimelightCryptoProvider getCryptoProvider(Context c) {
        return new AndroidCryptoProvider(c);
    }
}
