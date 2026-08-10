package net.raytmm.snaplook.keymappings;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.raytmm.snaplook.Snaplook;
import org.lwjgl.glfw.GLFW;

public class SnaplookKeyMapping {

    public static final KeyMapping BACK_VIEW_KEYMAPPING = KeyMappingHelper.registerKeyMapping(
            new KeyMapping("key.snaplook.snap_key_backwards", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Z, KeyMapping.Category.MISC));
    public static final KeyMapping FRONT_VIEW_KEYMAPPING = KeyMappingHelper.registerKeyMapping(
            new KeyMapping("key.snaplook.snap_key_forwards", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_X, KeyMapping.Category.MISC));


    public static void register()
    {
        Snaplook.LOGGER.info("Registering Mod Keybinds for " + Snaplook.MOD_ID);
    }
}
