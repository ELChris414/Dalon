package elchris414.dalon.runeforge;

import javax.annotation.Nullable;

import elchris414.dalon.DalonItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class RuneForgeContainer extends Container {
	
	private RuneForgeTileEntity te;
	
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 1, 6);
    public InventoryCraftResult craftResult = new InventoryCraftResult();
	
	public RuneForgeContainer(IInventory playerInventory, RuneForgeTileEntity te) {
		this.te = te;
		
		addOwnSlots();
		addPlayerSlots(playerInventory);
	}
	
	private void addPlayerSlots(IInventory playerInventory) {
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 9; ++col) {
				int x = 10 + col * 18;
				int y = row * 18 + 70;
				this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 10, x, y));
			}
		}
		
		for (int row = 0; row < 9; ++row) {
			int x = 10 + row * 18;
			int y = 58 + 70;
			this.addSlotToContainer(new Slot(playerInventory, row, x, y));
		}
	}
	
	private void addOwnSlots() {
		IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);		
		
		addSlotToContainer(new SlotItemHandler(itemHandler, 0, 82, 27) {
			// Center
			@Override
			public boolean isItemValid(ItemStack stack) {
				return false;
			}
			@Override
			public void onSlotChanged()
		    {
		        this.inventory.markDirty();
		    }
		});
		
		// LEFT
		addSlotToContainer(new SlotItemHandler(itemHandler, 1, 8, 27) {
			@Override
			public void onSlotChanged()
		    {
		        this.inventory.markDirty();
		        markDirty();
		    }
		}); // Gem
		addSlotToContainer(new SlotItemHandler(itemHandler, 2, 27, 27) {
			@Override
			public void onSlotChanged()
		    {
		        this.inventory.markDirty();
		        markDirty();
		    }
		}); // Rune Slot
		addSlotToContainer(new SlotItemHandler(itemHandler, 3, 46, 27) {
			@Override
			public void onSlotChanged()
		    {
		        this.inventory.markDirty();
		        markDirty();
		    }
		}); // Category item
		
		// RIGHT
		addSlotToContainer(new SlotItemHandler(itemHandler, 4, 118, 27) {
			@Override
			public void onSlotChanged()
		    {
		        this.inventory.markDirty();
		        markDirty();
		    }
		});
		addSlotToContainer(new SlotItemHandler(itemHandler, 5, 137, 27) {
			@Override
			public void onSlotChanged()
		    {
		        this.inventory.markDirty();
		        markDirty();
		    }
		});
		addSlotToContainer(new SlotItemHandler(itemHandler, 6, 156, 27) {
			@Override
			public void onSlotChanged()
		    {
		        this.inventory.markDirty();
		        markDirty();
		    }
		});
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return te.canInteractWith(playerIn);
	}
	
	public void markDirty() {
		ItemStack gemSlot = this.inventoryItemStacks.get(1);
		ItemStack runeSlot = this.inventoryItemStacks.get(2);
		ItemStack itemSlot = this.inventoryItemStacks.get(3);
		
		if (!gemSlot.isEmpty() && !runeSlot.isEmpty() && !itemSlot.isEmpty()) {
			this.inventorySlots.get(0).putStack(RuneForgeRecipes.checkForRecipe(gemSlot, runeSlot, itemSlot));
			this.inventorySlots.get(0).onSlotChanged();
		}
	}

}
