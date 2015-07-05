package big_xplosion.ee3addons.configuration;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

	public static Configuration config;

	public static void init(File configFile) {
		config = new Configuration(configFile);
	}

	private static void readConfig() {
		config.load();

		if (config.hasChanged())
			config.save();
	}
}
