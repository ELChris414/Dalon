package elchris414.dalon.blocks;

import elchris414.dalon.DalonStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GemInfuser extends Block{
	public GemInfuser() {
		super(Material.GROUND);
		setUnlocalizedName(DalonStrings.MODID + ".geminfuser");
		setRegistryName("geminfuser");
		setHardness(5f);
		setResistance(6000f);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
