package big_xplosion.ee3addons;

import big_xplosion.ee3addons.compat.CompatManager;
import big_xplosion.ee3addons.configuration.Config;
import big_xplosion.ee3addons.core.Content;
import big_xplosion.ee3addons.lib.Reference;
import big_xplosion.ee3addons.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;

import java.io.File;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, dependencies = Reference.DEPENDENCIES)
public class EE3Addons {

	@Mod.Instance(Reference.MOD_ID)
	public static EE3Addons instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static CommonProxy proxy;

	public CompatManager manager = new CompatManager();

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		manager.setupModules();

		Config.init(new File(event.getModConfigurationDirectory(), "EE3Addons" + File.separator + "ee3Addons.cfg"));

		Content.preInit();

		manager.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		Content.init();

		manager.init(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Content.postInit();

		manager.postInit(event);
	}

	@Mod.EventHandler
	public void doneLoading(FMLLoadCompleteEvent event) {
		manager.doneLoadingEvent(event);
	}

	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent event) {

	}
}
