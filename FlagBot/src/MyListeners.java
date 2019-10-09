
import java.util.List;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MyListeners extends ListenerAdapter {

	public void onMessageReceived(MessageReceivedEvent event) {

		String[] userMsg = event.getMessage().getContentRaw().split("\\s+");

		if (userMsg[0].equalsIgnoreCase(Main.prefix + "ping")) {

			EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle("Pong!");
			embed.setDescription("A method that just returns a pong to any ping requests (doesn't even return the user's ping lol)");
			embed.setColor(0x06f395);
			embed.setFooter("Created by Jappy", event.getMember().getUser().getAvatarUrl());

			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(embed.build()).queue();
			embed.clear();

		}

		if (userMsg[0].equalsIgnoreCase(Main.prefix + "prune")) {

			if (userMsg.length < 2) {
				// event.getChannel().sendMessage("Prune commands must have a number at the end
				// between 1 and 100").queue();

				EmbedBuilder embed = new EmbedBuilder();
				embed.setTitle("Please select a number");
				embed.setDescription("Enter a number" + Main.prefix + "prune #");
				embed.setColor(0);
				event.getChannel().sendMessage(embed.build()).queue();

			}

			else {

				try {

					int total = Integer.parseInt(userMsg[1]);
					total++;
					List<Message> selectedMsgs = event.getChannel().getHistory().retrievePast(total).complete();
					event.getTextChannel().deleteMessages(selectedMsgs).queue();

					// success✅

					EmbedBuilder embed = new EmbedBuilder();
					embed.setTitle("✅");
					embed.setDescription("");
					embed.setColor(0);
					event.getChannel().sendMessage(embed.build()).queue();

				} catch (IllegalArgumentException e) {

					if (e.toString().startsWith("java.lang.IllegalArgumentException: Must provide at least 2")) {
						// event.getChannel().sendMessage("Input must be at least 2 ffs").queue();

						EmbedBuilder embed = new EmbedBuilder();
						embed.setTitle("�?�");
						embed.setDescription("");
						embed.setColor(0);
						event.getChannel().sendMessage(embed.build()).queue();

					}

					else if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
						// event.getChannel().sendMessage("Input must not be more than 100").queue();

						EmbedBuilder embed = new EmbedBuilder();
						embed.setTitle("�?�");
						embed.setDescription("");
						embed.setColor(0);
						event.getChannel().sendMessage(embed.build()).queue();
					}

					else {
						// can't be older than 2 weeks
						// event.getChannel().sendMessage("what the hell have you done").queue();
						// 🚧

						EmbedBuilder embed = new EmbedBuilder();
						embed.setTitle("🚧");
						embed.setDescription("");
						embed.setColor(0);
						event.getChannel().sendMessage(embed.build()).queue();
					}
				}
			}

		}

	}
}
