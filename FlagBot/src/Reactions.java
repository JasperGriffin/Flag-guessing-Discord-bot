

import net.dv8tion.jda.core.entities.MessageReaction;
import net.dv8tion.jda.core.entities.MessageReaction.ReactionEmote;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Reactions extends ListenerAdapter {

	int a = 0;

	public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {

		ReactionEmote rEmote = new ReactionEmote("✔", event.getMessageIdLong(), event.getJDA()); // string, long, jd
		MessageReaction reaction = new MessageReaction(event.getChannel(), rEmote, event.getMessageIdLong(), true, 1);

		a += reaction.getCount();
		// event.getChannel().sendMessage("A is: " + a).queue();

		if (event.getReactionEmote().getName().equals("✅") && a == 2) { // crossEmoji(event, reaction);
			event.getChannel().sendMessage("you've clicked this ✅").queue();
			a = 0;
		}
	}
}
