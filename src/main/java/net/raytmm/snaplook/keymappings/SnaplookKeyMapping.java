package net.raytmm.snaplook.keymappings;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import net.raytmm.snaplook.Snaplook;
import org.lwjgl.glfw.GLFW;

public class SnaplookKeyMapping {

    public static final KeyMapping.Category SNAPLOOK_CATEGORY =
            KeyMapping.Category.register(Identifier.fromNamespaceAndPath("snaplook", "main"));
    public static final KeyMapping BACK_VIEW_KEYMAPPING = KeyMappingHelper.registerKeyMapping(
            new KeyMapping("key.snaplook.snap_key_backwards", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Z, SNAPLOOK_CATEGORY));
    public static final KeyMapping FRONT_VIEW_KEYMAPPING = KeyMappingHelper.registerKeyMapping(
            new KeyMapping("key.snaplook.snap_key_forwards", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_X, SNAPLOOK_CATEGORY));


    public static void register()
    {
        Snaplook.LOGGER.info("Registering Mod Keybinds for " + Snaplook.MOD_ID);
    }
}
