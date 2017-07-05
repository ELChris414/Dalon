package elchris414.dalon;

import elchris414.dalon.proxy.CommonProxy;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class DalonRecipes extends CommonProxy{
	@SubscribeEvent
	public static void registerFurnace(RegistryEvent.Register<IRecipe> event) {
		GameRegistry.addSmelting(DalonItems.unprocessedrunestone, new ItemStack(DalonItems.runestone, 1), 1f);
	}
}
