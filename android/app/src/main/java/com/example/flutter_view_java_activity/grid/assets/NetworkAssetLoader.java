package com.example.flutter_view_java_activity.grid.assets;

import android.content.Context;

import com.example.flutter_view_java_activity.LimeLog;
import com.example.flutter_view_java_activity.binding.PlatformBinding;
import com.example.flutter_view_java_activity.nvstream.http.NvHTTP;

import java.io.IOException;
import java.io.InputStream;

public class NetworkAssetLoader {
    private final Context context;
    private final String uniqueId;

    public NetworkAssetLoader(Context context, String uniqueId) {
        this.context = context;
        this.uniqueId = uniqueId;
    }

    public InputStream getBitmapStream(CachedAppAssetLoader.LoaderTuple tuple) {
        InputStream in = null;
        try {
            NvHTTP http = new NvHTTP(tuple.computer.activeAddress, uniqueId,
                    tuple.computer.serverCert, PlatformBinding.getCryptoProvider(context));
            in = http.getBoxArt(tuple.app);
        } catch (IOException ignored) {}

        if (in != null) {
            LimeLog.info("Network asset load complete: " + tuple);
        }
        else {
            LimeLog.info("Network asset load failed: " + tuple);
        }

        return in;
    }
}
