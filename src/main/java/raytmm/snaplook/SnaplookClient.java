package raytmm.snaplook;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.Perspective;
import raytmm.snaplook.keymapping.SnaplookKeyMapping;

public class SnaplookClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        SnaplookKeyMapping.register();
        ClientTickEvents.END_CLIENT_TICK.register(SnaplookClient::onEndTick);
    }

    public static void onEndTick(MinecraftClient client)
    {
        if (client.player == null)
        {
            return;
        }

        if (SnaplookKeyMapping.BACK_VIEW_KEYMAPPING.isPressed())
        {
            client.options.setPerspective(Perspective.THIRD_PERSON_BACK);
        }
        else if (SnaplookKeyMapping.FRONT_VIEW_KEYMAPPING.isPressed())
        {
            client.options.setPerspective(Perspective.THIRD_PERSON_FRONT);
        }
        else
        {
            client.options.setPerspective(Perspective.FIRST_PERSON);
        }
    }
}
