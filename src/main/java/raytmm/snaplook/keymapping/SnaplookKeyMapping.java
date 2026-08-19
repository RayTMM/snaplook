package raytmm.snaplook.keymapping;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import raytmm.snaplook.Snaplook;

public class SnaplookKeyMapping
{
    public static final KeyBinding BACK_VIEW_KEYMAPPING = KeyBindingHelper.registerKeyBinding((
            new net.minecraft.client.option.KeyBinding((
                    "key.snaplook.snap_key_backwards"),
                    InputUtil.Type.KEYSYM,
                    GLFW.GLFW_KEY_Z,
                    "category.snaplook"
                )
    ));

    public static final KeyBinding FRONT_VIEW_KEYMAPPING = KeyBindingHelper.registerKeyBinding((
           new net.minecraft.client.option.KeyBinding((
                   "key.snaplook.snap_key_forwards"),
                    InputUtil.Type.KEYSYM,
                    GLFW.GLFW_KEY_X,
                    "category.snaplook"
                )
        ));

        public static void register() {
            Snaplook.LOGGER.info("Registering Mod Keybinds for " + Snaplook.MOD_ID);
        }

    }
