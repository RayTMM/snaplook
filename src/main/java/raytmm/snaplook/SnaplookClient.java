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

    static boolean isActive = false;
    static Perspective savedPerspective = null;
    public static void onEndTick(MinecraftClient client)
    {

        if (!isActive)
        {
            if (SnaplookKeyMapping.BACK_VIEW_KEYMAPPING.isPressed())
            {
                savedPerspective = client.options.getPerspective();
                isActive = true;
                client.options.setPerspective(Perspective.THIRD_PERSON_BACK);
                Snaplook.LOGGER.info("BACK isPressed: " + SnaplookKeyMapping.BACK_VIEW_KEYMAPPING.isPressed());
            }
            else if (SnaplookKeyMapping.FRONT_VIEW_KEYMAPPING.isPressed())
            {
                savedPerspective = client.options.getPerspective();
                isActive = true;
                client.options.setPerspective(Perspective.THIRD_PERSON_FRONT);
                Snaplook.LOGGER.info("FRONT isPressed: " + SnaplookKeyMapping.FRONT_VIEW_KEYMAPPING.isPressed());
            }
        }
        else //snaplook is currently active
        {
            if (!SnaplookKeyMapping.BACK_VIEW_KEYMAPPING.isPressed() && !SnaplookKeyMapping.FRONT_VIEW_KEYMAPPING.isPressed())
            {
                client.options.setPerspective(savedPerspective);
                savedPerspective = null;
                isActive = false;
            }

        }
    }
}
