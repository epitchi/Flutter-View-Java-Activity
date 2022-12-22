package com.example.flutter_view_java_activity.binding.input.evdev;

import android.app.Activity;

import com.example.flutter_view_java_activity.BuildConfig;
import com.example.flutter_view_java_activity.binding.input.capture.InputCaptureProvider;


public class EvdevCaptureProviderShim {
    public static boolean isCaptureProviderSupported() {
        return BuildConfig.ROOT_BUILD;
    }

    // We need to construct our capture provider using reflection because it isn't included in non-root builds
    public static InputCaptureProvider createEvdevCaptureProvider(Activity activity, EvdevListener listener) {
        try {
            Class providerClass = Class.forName("in.oneplay.binding.input.evdev.EvdevCaptureProvider");
            return (InputCaptureProvider) providerClass.getConstructors()[0].newInstance(activity, listener);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
