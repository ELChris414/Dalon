package elchris414.dalon.proxy;

import java.io.File;

import org.apache.logging.log4j.Level;

import elchris414.dalon.Config;
import elchris414.dalon.Dalon;
import elchris414.dalon.DalonBlocks;
import elchris414.dalon.DalonStrings;
import elchris414.dalon.blocks.GemInfuser;
import elchris414.dalon.blocks.InactiveBlock;
import elchris414.dalon.blocks.RuneStoneOre;
import elchris414.dalon.items.InactiveItem;
import elchris414.dalon.items.InactiveItemBlock;
import elchris414.dalon.runeforge.RuneForge;
import elchris414.dalon.runeforge.RuneForgeTileEntity;
import elchris414.dalon.worldgen.DalonWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
	
	// Config instance
	public static Configuration config;
	
    public void preInit(FMLPreInitializationEvent e) {
    	File directory = e.getModConfigurationDirectory();
    	config = new Configuration(new File(directory.getPath(), "dalon.cfg"));
    	Config.readConfig();
    }

    public void init(FMLInitializationEvent e) {
    	GameRegistry.registerWorldGenerator(new DalonWorldGen(), 0);
    	NetworkRegistry.INSTANCE.registerGuiHandler(Dalon.instance, new GuiProxy());
    	Dalon.logger.log(Level.INFO, "Registered World Generator");
    }

    public void postInit(FMLPostInitializationEvent e) {
    	if (config.hasChanged()) {
    		config.save();
    	}
    }
}