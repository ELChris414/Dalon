package elchris414.dalon.blocks;

import elchris414.dalon.DalonCreativeTab;
import elchris414.dalon.DalonStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class InactiveBlock extends Block{
	public InactiveBlock(String unlocalizedName, Material material) {
		super(material);
		setUnlocalizedName(DalonStrings.MODID + "." + unlocalizedName);
		setRegistryName(unlocalizedName);
		setCreativeTab(DalonCreativeTab.INSTANCE);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
