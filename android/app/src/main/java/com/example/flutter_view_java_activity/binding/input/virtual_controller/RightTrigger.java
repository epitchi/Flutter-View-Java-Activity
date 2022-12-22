package com.example.flutter_view_java_activity.binding.input.virtual_controller; /**
 * Created by Karim Mreisi.
 */


import android.content.Context;

public class RightTrigger extends DigitalButton {
    public RightTrigger(final VirtualController controller, final int layer, final Context context) {
        super(controller, EID_RT, layer, context);
        addDigitalButtonListener(new DigitalButton.DigitalButtonListener() {
            @Override
            public void onClick() {
                VirtualController.ControllerInputContext inputContext =
                        controller.getControllerInputContext();
                inputContext.rightTrigger = (byte) 0xFF;

                controller.sendControllerInputContext();
            }

            @Override
            public void onLongClick() {
            }

            @Override
            public void onRelease() {
                VirtualController.ControllerInputContext inputContext =
                        controller.getControllerInputContext();
                inputContext.rightTrigger = (byte) 0x00;

                controller.sendControllerInputContext();
            }
        });
    }
}
