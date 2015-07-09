package big_xplosion.ee3addons.client.handler;

import big_xplosion.ee3addons.lib.UUIDs;
import big_xplosion.ee3addons.util.UUIDUtil;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderLivingEvent;
import org.lwjgl.opengl.GL11;

public class RenderPlayerEventHandler {

	private boolean resetRender = false;
	private boolean down = true;
	private float mod = 1.0F;

	@SubscribeEvent
	public void renderPlayerSpecialsPre(RenderLivingEvent.Pre event) {
		if (!(event.entity instanceof EntityPlayer))
			return;

		EntityPlayer player = (EntityPlayer) event.entity;

		if (player.getHideCape())
			return;

		if (!UUIDs.FLUCTUATING_BODY_RENDER.contains(UUIDUtil.getPlayerUUIDString((EntityPlayer) event.entity)))
			return;

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, mod);
		resetRender = true;

		if (down)
			mod -= 0.025;
		else
			mod += 0.025;

		if (mod <= 0 || mod >= 1)
			down = !down;
	}

	@SubscribeEvent
	public void renderPlayerSpecialsPost(RenderLivingEvent.Post event) {
		if (!(event.entity instanceof EntityPlayer))
			return;

		if (!resetRender)
			return;

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_BLEND);
		resetRender = false;
	}
}
