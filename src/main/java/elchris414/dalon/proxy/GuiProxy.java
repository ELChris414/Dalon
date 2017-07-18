package elchris414.dalon.proxy;

import elchris414.dalon.runeforge.RuneForgeContainer;
import elchris414.dalon.runeforge.RuneForgeGui;
import elchris414.dalon.runeforge.RuneForgeTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiProxy implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity te = world.getTileEntity(pos);
		if (te instanceof RuneForgeTileEntity) {
			return new RuneForgeContainer(player.inventory, (RuneForgeTileEntity) te);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof RuneForgeTileEntity) {
            RuneForgeTileEntity containerTileEntity = (RuneForgeTileEntity) te;
            return new RuneForgeGui(containerTileEntity, new RuneForgeContainer(player.inventory, containerTileEntity));
        }
        return null;
	}

}
