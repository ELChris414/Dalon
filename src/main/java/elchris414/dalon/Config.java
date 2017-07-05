package elchris414.dalon;

import org.apache.logging.log4j.Level;

import elchris414.dalon.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class Config {
	private static final String CATEGORY_GENERAL = "general";
	
	public static boolean expensiveRecipes = true;
	
	public static void readConfig() {
		Configuration cfg = CommonProxy.config;
		try {
			cfg.load();
			initGeneralConfig(cfg);
		} catch (Exception e1) {
			Dalon.logger.log(Level.ERROR, "Problem loading config file", e1);
		} finally {
			if (cfg.hasChanged()) {
				cfg.save();
			}
		}
	}
	
	private static void initGeneralConfig(Configuration cfg) {
		cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General Configuration");
		expensiveRecipes = cfg.getBoolean("expensiveRecipes", CATEGORY_GENERAL, true, "Set true for expensive recipes and false for cheap recipes");
	}
}
