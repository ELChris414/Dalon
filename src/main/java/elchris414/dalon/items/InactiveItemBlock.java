package elchris414.dalon.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class InactiveItemBlock extends ItemBlock {

	public InactiveItemBlock(Block block) {
		super(block);
		setRegistryName(block.getRegistryName());
	}

}
