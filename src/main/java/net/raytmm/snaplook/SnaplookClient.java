package net.raytmm.snaplook;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.raytmm.snaplook.keymappings.SnaplookKeyMapping;

public class SnaplookClient implements ClientModInitializer {
    @Override
    public void onInitializeClient()
    {
        SnaplookKeyMapping.register();
        ClientTickEvents.END_CLIENT_TICK.register(SnaplookClient::onEndTick);

    }


    public static void onEndTick(Minecraft client)
    {
        if (client.player == null)
        {
            return;
        }

        if (SnaplookKeyMapping.BACK_VIEW_KEYMAPPING.isDown())
        {
            client.options.setCameraType(CameraType.THIRD_PERSON_BACK);
        }
        else if (SnaplookKeyMapping.FRONT_VIEW_KEYMAPPING.isDown())
        {
            client.options.setCameraType(CameraType.THIRD_PERSON_FRONT);
        }
        else
        {
            client.options.setCameraType(CameraType.FIRST_PERSON);
        }
    }
}
