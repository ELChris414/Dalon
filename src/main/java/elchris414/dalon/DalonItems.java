package elchris414.dalon;

import elchris414.dalon.items.InactiveItem;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DalonItems {
	// Items
	@GameRegistry.ObjectHolder("dalon:runestone")
	public static InactiveItem runestone;
	@GameRegistry.ObjectHolder("dalon:unprocessedrunestone")
	public static InactiveItem unprocessedrunestone;
	@GameRegistry.ObjectHolder("dalon:inkbottle")
	public static InactiveItem inkbottle;
	@GameRegistry.ObjectHolder("dalon:goldenring")
	public static InactiveItem goldenring;
	@GameRegistry.ObjectHolder("dalon:pen")
	public static InactiveItem pen;
	@GameRegistry.ObjectHolder("dalon:magnifyingglass")
	public static InactiveItem magnifyingglass;
	@GameRegistry.ObjectHolder("dalon:magnifyingglassgoldenring")
	public static InactiveItem magnifyingglassgoldenring;
	@GameRegistry.ObjectHolder("dalon:ironpresser")
	public static InactiveItem ironpresser;
	@GameRegistry.ObjectHolder("dalon:peninkbottle")
	public static InactiveItem peninkbottle;
	
	// Gems
	@GameRegistry.ObjectHolder("dalon:gemenergy")
	public static InactiveItem gemenergy;
	@GameRegistry.ObjectHolder("dalon:gemnature")
	public static InactiveItem gemnature;
	@GameRegistry.ObjectHolder("dalon:gemmagic")
	public static InactiveItem gemmagic;
	@GameRegistry.ObjectHolder("dalon:gemredstone")
	public static InactiveItem gemredstone;
	@GameRegistry.ObjectHolder("dalon:gemtechnology")
	public static InactiveItem gemtechnology;
	@GameRegistry.ObjectHolder("dalon:gemspirit")
	public static InactiveItem gemspirit;
	
	// Tier 1 Runes
	@GameRegistry.ObjectHolder("dalon:simpleruneenergy")
	public static InactiveItem simpleruneenergy;
	@GameRegistry.ObjectHolder("dalon:simplerunenature")
	public static InactiveItem simplerunenature;
	@GameRegistry.ObjectHolder("dalon:simplerunemagic")
	public static InactiveItem simplerunemagic;
	@GameRegistry.ObjectHolder("dalon:simpleruneredstone")
	public static InactiveItem simpleruneredstone;
	@GameRegistry.ObjectHolder("dalon:simplerunetechnology")
	public static InactiveItem simplerunetechnology;
	@GameRegistry.ObjectHolder("dalon:simplerunespirit")
	public static InactiveItem simplerunespirit;
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		runestone.initModel();
	}
}
