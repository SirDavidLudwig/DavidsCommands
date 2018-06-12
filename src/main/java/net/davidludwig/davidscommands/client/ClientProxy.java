package net.davidludwig.davidscommands.client;

import net.davidludwig.davidscommands.CommonProxy;
import net.minecraft.client.renderer.debug.DebugRenderer;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {

    private ClientRenderer renderer = new ClientRenderer();

    public ClientRenderer getRenderer() {
        return renderer;
    }

    @SubscribeEvent
    public void renderWorldLastEvent(RenderWorldLastEvent event) {
        renderer.render(event.getPartialTicks());
    }
}
