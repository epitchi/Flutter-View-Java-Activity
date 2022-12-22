package com.example.flutter_view_java_activity.utils;

import android.app.Activity;
import android.content.Intent;

import com.example.flutter_view_java_activity.BuildConfig;
import com.example.flutter_view_java_activity.Game;
import com.example.flutter_view_java_activity.nvstream.http.NvApp;

import java.security.cert.X509Certificate;

public class ServerHelper {
    public static final String CONNECTION_TEST_SERVER = BuildConfig.APP_CONNECTIVITY_TEST_CHECK_DOMAIN;

    public static final int UPDATES_REQUEST_CODE = 3;

    public static Intent createStartIntent(Activity parent, String host, NvApp app, String uniqueId,
                                           String uuid, String pcName, X509Certificate serverCert,
                                           String sessionKey) {
        Intent intent = new Intent(parent, Game.class);
        intent.putExtra(Game.EXTRA_HOST, host);
        intent.putExtra(Game.EXTRA_APP_NAME, app.getAppName());
        intent.putExtra(Game.EXTRA_APP_ID, app.getAppId());
        intent.putExtra(Game.EXTRA_APP_HDR, app.isHdrSupported());
        intent.putExtra(Game.EXTRA_UNIQUE_ID, uniqueId);
        intent.putExtra(Game.EXTRA_PC_UUID, uuid);
        intent.putExtra(Game.EXTRA_PC_NAME, pcName);
        intent.putExtra(Game.EXTRA_SERVER_CERT, serverCert);
        intent.putExtra(Game.EXTRA_SESSION_KEY, sessionKey);
        return intent;
    }

    public static void doStart(Activity parent, Intent intent) {
        parent.startActivity(intent);
    }
}
