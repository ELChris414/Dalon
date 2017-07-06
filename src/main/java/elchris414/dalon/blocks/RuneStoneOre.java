package elchris414.dalon.blocks;

import java.util.Random;

import elchris414.dalon.DalonCreativeTab;
import elchris414.dalon.DalonItems;
import elchris414.dalon.DalonStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RuneStoneOre extends Block {
	private int meta = 0;
	private int least_quantity = 2;
	private int most_quantity = 4;
	
	public RuneStoneOre(String unlocalizedName) {
		super(Material.GROUND);
		setUnlocalizedName(DalonStrings.MODID + "." + unlocalizedName);
		setRegistryName(unlocalizedName);
		setHardness(2f);
		setResistance(15f);
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(DalonCreativeTab.INSTANCE);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
	@Override
	public Item getItemDropped(IBlockState blockstate, Random random, int fortune) {
	    return DalonItems.unprocessedrunestone;
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random)
    {
        return quantityDroppedWithBonus(fortune, random);
    }
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
	    if (this.least_quantity >= this.most_quantity)
	        return this.least_quantity;
	    return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
	}
	

}
