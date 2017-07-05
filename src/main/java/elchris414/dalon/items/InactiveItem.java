package elchris414.dalon.items;

import elchris414.dalon.DalonStrings;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class InactiveItem extends Item {
	public InactiveItem(String unlocalizedName) {
		setUnlocalizedName(DalonStrings.MODID + "." + unlocalizedName);
		setRegistryName(unlocalizedName);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
