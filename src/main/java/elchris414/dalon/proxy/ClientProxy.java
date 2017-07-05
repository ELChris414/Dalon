package elchris414.dalon.proxy;

import org.apache.logging.log4j.Level;

import elchris414.dalon.DalonBlocks;
import elchris414.dalon.Dalon;
import elchris414.dalon.DalonItems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    	DalonBlocks.initModels();
    	DalonItems.initModels();
    	Dalon.logger.log(Level.INFO, "Initialized models");
    }
}

