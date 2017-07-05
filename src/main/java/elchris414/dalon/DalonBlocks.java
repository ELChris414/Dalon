package elchris414.dalon;

import elchris414.dalon.blocks.InactiveBlock;
import elchris414.dalon.blocks.RuneForge;
import elchris414.dalon.blocks.RuneStoneOre;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DalonBlocks {
	@GameRegistry.ObjectHolder("dalon:runestoneore")
	public static RuneStoneOre runestoneore;
	@GameRegistry.ObjectHolder("dalon:runestoneblock")
	public static InactiveBlock runestoneblock;
	@GameRegistry.ObjectHolder("dalon:runeforge")
	public static RuneForge runeforge;
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		runestoneore.initModel();
		runestoneblock.initModel();
		runeforge.initModel();
	}
}