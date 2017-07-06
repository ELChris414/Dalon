package elchris414.dalon.proxy;

import java.io.File;

import org.apache.logging.log4j.Level;

import elchris414.dalon.Config;
import elchris414.dalon.Dalon;
import elchris414.dalon.DalonBlocks;
import elchris414.dalon.DalonStrings;
import elchris414.dalon.blocks.GemInfuser;
import elchris414.dalon.blocks.InactiveBlock;
import elchris414.dalon.blocks.RuneForge;
import elchris414.dalon.blocks.RuneStoneOre;
import elchris414.dalon.items.InactiveItem;
import elchris414.dalon.tileentities.RuneForgeTileEntity;
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

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	event.getRegistry().register(new RuneStoneOre("runestoneore"));
    	event.getRegistry().register(new InactiveBlock("runestoneblock", Material.GROUND));
    	event.getRegistry().register(new RuneForge());
    	GameRegistry.registerTileEntity(RuneForgeTileEntity.class, DalonStrings.MODID + "_runeforge");
    	event.getRegistry().register(new GemInfuser());
    	Dalon.logger.log(Level.INFO, "Loaded blocks");
    	
    }
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	// Blocks
    	event.getRegistry().register(new ItemBlock(DalonBlocks.runestoneore).setRegistryName(DalonBlocks.runestoneore.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(DalonBlocks.runestoneblock).setRegistryName(DalonBlocks.runestoneblock.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(DalonBlocks.runeforge).setRegistryName(DalonBlocks.runeforge.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(DalonBlocks.geminfuser).setRegistryName(DalonBlocks.geminfuser.getRegistryName()));
    	// Items
    	event.getRegistry().register(new InactiveItem("runestone"));
    	event.getRegistry().register(new InactiveItem("unprocessedrunestone"));
    	// Gems
    	event.getRegistry().register(new InactiveItem("gemenergy"));
    	event.getRegistry().register(new InactiveItem("gemnature"));
    	event.getRegistry().register(new InactiveItem("gemmagic"));
    	event.getRegistry().register(new InactiveItem("gemredstone"));
    	event.getRegistry().register(new InactiveItem("gemtechnology"));
    	event.getRegistry().register(new InactiveItem("gemspirit"));
    	// Tier 1 Runes
    	event.getRegistry().register(new InactiveItem("simpleruneenergy"));
    	event.getRegistry().register(new InactiveItem("simplerunenature"));
    	event.getRegistry().register(new InactiveItem("simplerunemagic"));
    	event.getRegistry().register(new InactiveItem("simpleruneredstone"));
    	event.getRegistry().register(new InactiveItem("simplerunetechnology"));
    	event.getRegistry().register(new InactiveItem("simplerunespirit"));
    	Dalon.logger.log(Level.INFO, "Loaded items");
    }
}