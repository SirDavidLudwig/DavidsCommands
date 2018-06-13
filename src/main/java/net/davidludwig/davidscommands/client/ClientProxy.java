package net.davidludwig.davidscommands.client;

import net.davidludwig.davidscommands.CommonProxy;
import net.davidludwig.davidscommands.command.CommandDisplayRngChunks;
import net.davidludwig.davidscommands.command.CommandUnloadPriority;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.debug.DebugRenderer;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {

    Minecraft minecraft;

    public CommandBase[] commands = {
            new CommandDisplayRngChunks(),
            new CommandUnloadPriority()
    };

    private ClientRenderer renderer = new ClientRenderer();

    public ClientRenderer getRenderer() {
        return renderer;
    }

    public void registerCommands() {
        for (ICommand command : commands)
            registerCommand(command);
    }

    public void registerCommand(ICommand command) {
        ClientCommandHandler.instance.registerCommand(command);
    }

    @SubscribeEvent
    public void renderWorldLastEvent(RenderWorldLastEvent event) {
        renderer.render(event.getPartialTicks());
    }

    @Override
    public void init(FMLInitializationEvent event) {
        minecraft = Minecraft.getMinecraft();
        registerCommands();
    }
}
