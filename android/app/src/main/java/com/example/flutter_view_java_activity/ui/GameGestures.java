package com.example.flutter_view_java_activity.ui;

import android.os.ResultReceiver;
import android.view.View;

public interface GameGestures {
    void toggleKeyboard();
    void hideKeyboard(View view, ResultReceiver receiver);
}
