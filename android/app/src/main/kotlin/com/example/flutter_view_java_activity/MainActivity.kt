package com.example.flutter_view_java_activity

import android.content.Intent
import android.os.Bundle

import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant


import io.flutter.app.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.view.FlutterMain

class MainActivity: FlutterActivity() {
    private val CHANNEL = "com.startActivity/testChannel"
    override fun onCreate(savedInstanceState: Bundle?) {
      FlutterMain.startInitialization(this); //Added line 
      super.onCreate(savedInstanceState)
      GeneratedPluginRegistrant.registerWith(FlutterEngine(this))

      MethodChannel(flutterView,CHANNEL).setMethodCallHandler{ call,result ->
        if(call.method.equals("StartSecondActivity")){
          val intent=Intent(this, JavaActivity::class.java)
          startActivity(intent)
          result.success("ActivityStarted")
        }
        else{
          result.notImplemented()
        }
      }
    }
  }