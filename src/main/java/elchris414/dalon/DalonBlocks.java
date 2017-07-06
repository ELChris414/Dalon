package elchris414.dalon;

import elchris414.dalon.blocks.GemInfuser;
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
	@GameRegistry.ObjectHolder("dalon:geminfuser")
	public static GemInfuser geminfuser;
	@GameRegistry.ObjectHolder("dalon:infusedredwool")
	public static InactiveBlock infusedredwool;
	@GameRegistry.ObjectHolder("dalon:hardenedconcretepowder")
	public static InactiveBlock hardenedconcretepowder;
	@GameRegistry.ObjectHolder("dalon:whiteconcretebricks")
	public static InactiveBlock whiteconcretebricks;
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		runestoneore.initModel();
		runestoneblock.initModel();
		runeforge.initModel();
		geminfuser.initModel();
	}
}