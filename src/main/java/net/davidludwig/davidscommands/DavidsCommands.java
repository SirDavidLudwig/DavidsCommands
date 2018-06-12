package net.davidludwig.davidscommands;

import net.davidludwig.davidscommands.client.ClientProxy;
import net.davidludwig.davidscommands.command.CommandUnloadPriority;
import net.davidludwig.davidscommands.command.server.CommandCountEntities;
import net.davidludwig.davidscommands.command.server.CommandInstantBlockFalling;
import net.davidludwig.davidscommands.command.server.CommandRngReset;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;

@Mod(modid = DavidsCommands.MODID, name = DavidsCommands.NAME, version = DavidsCommands.VERSION, acceptableRemoteVersions = "*")
public class DavidsCommands
{
    public static final String MODID = "davidscommands";
    public static final String NAME = "David's Commands";
    public static final String VERSION = "0.1";

    private static Logger logger;

    @SidedProxy(clientSide = "net.davidludwig.davidscommands.client.ClientProxy", serverSide = "net.davidludwig.davidscommands.client.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void onServerStart(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandInstantBlockFalling());
        event.registerServerCommand(new CommandCountEntities());
        event.registerServerCommand(new CommandRngReset());
    }

    @SideOnly(Side.CLIENT)
    @EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new CommandUnloadPriority());
        MinecraftForge.EVENT_BUS.register(proxy);
    }
}
