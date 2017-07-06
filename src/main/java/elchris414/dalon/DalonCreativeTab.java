package elchris414.dalon;

import javax.annotation.Nonnull;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class DalonCreativeTab extends CreativeTabs {
	public static DalonCreativeTab INSTANCE = new DalonCreativeTab();
	
	public DalonCreativeTab() {
		super(DalonStrings.MODID);
	}
	
	@Nonnull
	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(DalonItems.runestone);
	}	
	
	@Override
	public ItemStack getTabIconItem() {
		return getIconItemStack();
	}
	

}
