package elchris414.dalon;

import org.apache.logging.log4j.Logger;

import elchris414.dalon.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = DalonStrings.MODID, name = DalonStrings.MODNAME, version = DalonStrings.VERSION, useMetadata = true)
public class Dalon {
	@SidedProxy(clientSide = "elchris414.dalon.proxy.ClientProxy", serverSide = "elchris414.dalon.proxy.ServerProxy")
    public static CommonProxy proxy;
	
	@Mod.Instance
    public static Dalon instance;
	
	public static Logger logger;
	
	public Object[] runeForgeRecipes;
	
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
