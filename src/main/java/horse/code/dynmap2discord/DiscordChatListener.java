package horse.code.dynmap2discord;

import github.scarsz.discordsrv.api.Subscribe;
import github.scarsz.discordsrv.api.events.DiscordGuildMessagePreProcessEvent;
import org.dynmap.DynmapAPI;

public class DiscordChatListener {
	private DynmapAPI dynmap;
	public DiscordChatListener(DynmapAPI dynmap) {
		this.dynmap = dynmap;
	}

	@Subscribe
	public void onDiscordChatMessage(DiscordGuildMessagePreProcessEvent event) {
		String name = "[Discord] " + event.getMember().getEffectiveName();
		String message = event.getMessage().getContentStripped();

		dynmap.postPlayerMessageToWeb(name, null, message);
	}
}
