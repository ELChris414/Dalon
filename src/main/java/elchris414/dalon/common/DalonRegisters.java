package elchris414.dalon.common;

import org.apache.logging.log4j.Level;

import elchris414.dalon.Dalon;
import elchris414.dalon.DalonBlocks;
import elchris414.dalon.DalonStrings;
import elchris414.dalon.blocks.GemInfuser;
import elchris414.dalon.blocks.InactiveBlock;
import elchris414.dalon.blocks.RuneStoneOre;
import elchris414.dalon.items.InactiveItem;
import elchris414.dalon.items.InactiveItemBlock;
import elchris414.dalon.proxy.CommonProxy;
import elchris414.dalon.runeforge.RuneForge;
import elchris414.dalon.runeforge.RuneForgeTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class DalonRegisters extends CommonProxy {
	@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	event.getRegistry().register(new RuneStoneOre("runestoneore"));
    	event.getRegistry().register(new InactiveBlock("runestoneblock", Material.GROUND));
    	event.getRegistry().register(new RuneForge());
    	GameRegistry.registerTileEntity(RuneForgeTileEntity.class, DalonStrings.MODID + "_runeforge");
    	event.getRegistry().register(new GemInfuser());
    	event.getRegistry().register(new InactiveBlock("infusedredwool", Material.CLOTH).setHardness(0.8f));
    	event.getRegistry().register(new InactiveBlock("hardenedconcretepowder", Material.GROUND).setHardness(1f));
    	event.getRegistry().register(new InactiveBlock("whiteconcretebricks", Material.GROUND).setHardness(2f).setResistance(30f));
    	Dalon.logger.log(Level.INFO, "Loaded blocks");
    	
    }
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	// Blocks
    	event.getRegistry().register(new InactiveItemBlock(DalonBlocks.runestoneore));
    	event.getRegistry().register(new InactiveItemBlock(DalonBlocks.runestoneblock));
    	event.getRegistry().register(new InactiveItemBlock(DalonBlocks.runeforge));
    	event.getRegistry().register(new InactiveItemBlock(DalonBlocks.geminfuser));
    	event.getRegistry().register(new InactiveItemBlock(DalonBlocks.infusedredwool));
    	event.getRegistry().register(new InactiveItemBlock(DalonBlocks.hardenedconcretepowder));
    	event.getRegistry().register(new InactiveItemBlock(DalonBlocks.whiteconcretebricks));
    	// Items
    	event.getRegistry().register(new InactiveItem("runestone"));
    	event.getRegistry().register(new InactiveItem("unprocessedrunestone"));
    	event.getRegistry().register(new InactiveItem("inkbottle"));
    	event.getRegistry().register(new InactiveItem("goldenring"));
    	event.getRegistry().register(new InactiveItem("pen"));
    	event.getRegistry().register(new InactiveItem("magnifyingglass"));
    	event.getRegistry().register(new InactiveItem("magnifyingglassgoldenring"));
    	event.getRegistry().register(new InactiveItem("ironpresser"));
    	event.getRegistry().register(new InactiveItem("peninkbottle"));
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
