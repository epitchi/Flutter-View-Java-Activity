package com.example.flutter_view_java_activity.binding.input.virtual_controller; /**
 * Created by Karim Mreisi.
 */


import android.content.Context;

import com.example.flutter_view_java_activity.nvstream.input.ControllerPacket;


public class LeftAnalogStick extends AnalogStick {
    public LeftAnalogStick(final VirtualController controller, final Context context) {
        super(controller, context, EID_LS);

        addAnalogStickListener(new AnalogStick.AnalogStickListener() {
            @Override
            public void onMovement(float x, float y) {
                VirtualController.ControllerInputContext inputContext =
                        controller.getControllerInputContext();
                inputContext.leftStickX = (short) (x * 0x7FFE);
                inputContext.leftStickY = (short) (y * 0x7FFE);

                controller.sendControllerInputContext();
            }

            @Override
            public void onClick() {
            }

            @Override
            public void onDoubleClick() {
                VirtualController.ControllerInputContext inputContext =
                        controller.getControllerInputContext();
                inputContext.inputMap |= ControllerPacket.LS_CLK_FLAG;

                controller.sendControllerInputContext();
            }

            @Override
            public void onRevoke() {
                VirtualController.ControllerInputContext inputContext =
                        controller.getControllerInputContext();
                inputContext.inputMap &= ~ControllerPacket.LS_CLK_FLAG;

                controller.sendControllerInputContext();
            }
        });
    }
}
