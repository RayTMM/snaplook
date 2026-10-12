package raytmm.snaplook.mixin;

import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import raytmm.snaplook.Snaplook;
import raytmm.snaplook.SnaplookClient;
import raytmm.snaplook.keymapping.SnaplookKeyMapping;

@Mixin(Keyboard.class)
public class KeybindMixin
{
    @Inject(method = "onKey", at = @At("HEAD"), cancellable = true)
    private void KeybindMixinWork(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci)
    {
        //InputUtil.Key k2 = InputUtil.fromKeyCode(key,scancode);
        Snaplook.LOGGER.info("Key Event: " + key + "Scancode: " + scancode);



        if (SnaplookKeyMapping.BACK_VIEW_KEYMAPPING.matchesKey(key, scancode))
        {

            Snaplook.LOGGER.info("SNAPLOOK BACK KEY DETECTED");
            //checking to see if key that is being inputted
            if (MinecraftClient.getInstance().currentScreen == null)
            {
                SnaplookKeyMapping.BACK_VIEW_KEYMAPPING.setPressed(true);
                Snaplook.LOGGER.info("BACK isPressed: " + SnaplookKeyMapping.BACK_VIEW_KEYMAPPING.isPressed());
            }
            /*if (action == GLFW.GLFW_PRESS)
            {
                //checking if key was pressed
                //action is a variable (duh)
                SnaplookKeyMapping.BACK_VIEW_KEYMAPPING.setPressed(true);
                Snaplook.LOGGER.info("BACK isPressed: " + SnaplookKeyMapping.BACK_VIEW_KEYMAPPING.isPressed());
            }

            */if (action == GLFW.GLFW_RELEASE)
            {
                //Checking if key was released
                SnaplookKeyMapping.BACK_VIEW_KEYMAPPING.setPressed(false);            }


        }

        if (SnaplookKeyMapping.FRONT_VIEW_KEYMAPPING.matchesKey(key, scancode))
        {
            if (MinecraftClient.getInstance().currentScreen==null)
            {
                SnaplookKeyMapping.FRONT_VIEW_KEYMAPPING.setPressed(true);
                Snaplook.LOGGER.info("FRONT isPressed: " + SnaplookKeyMapping.FRONT_VIEW_KEYMAPPING.isPressed());
            }
            /*if (action == GLFW.GLFW_PRESS)
            {
                //checking if key was pressed
                //action is a variable (duh)
                SnaplookKeyMapping.FRONT_VIEW_KEYMAPPING.setPressed(true);
            }

            */if (action == GLFW.GLFW_RELEASE)
            {
                //Checking if key was released
                SnaplookKeyMapping.FRONT_VIEW_KEYMAPPING.setPressed(false);            }


        }
    }

}
