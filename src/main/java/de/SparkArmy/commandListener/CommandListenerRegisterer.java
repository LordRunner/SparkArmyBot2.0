package de.SparkArmy.commandListener;

import de.SparkArmy.commandListener.globalCommands.slashCommands.FeedbackCommand;
import de.SparkArmy.commandListener.globalCommands.slashCommands.ModmailCommand;
import de.SparkArmy.commandListener.guildCommands.messageCommands.Report;
import de.SparkArmy.commandListener.guildCommands.slashCommands.admin.*;
import de.SparkArmy.commandListener.guildCommands.slashCommands.moderation.*;
import de.SparkArmy.commandListener.guildCommands.userCommands.admin.ModUnmodMember;
import de.SparkArmy.commandListener.guildCommands.userCommands.general.RoleRemove;
import de.SparkArmy.commandListener.guildCommands.userCommands.moderation.UserContextMute;
import de.SparkArmy.commandListener.guildCommands.userCommands.moderation.UserContextWarn;
import de.SparkArmy.utils.MainUtil;
import net.dv8tion.jda.api.JDA;

import java.util.ArrayList;

public class CommandListenerRegisterer {

    private final ArrayList<CustomCommandListener> commands = new ArrayList<>();
    private final JDA jda = MainUtil.jda;

    public CommandListenerRegisterer() {
        this.registerCommandListeners();
    }

    private void registerCommandListeners() {
        // SlashCommands
            // Global Commands
            commands.add(new FeedbackCommand());
            commands.add(new ModmailCommand());

            // Moderation Commands
            commands.add(new SlashWarn());
            commands.add(new SlashMute());
            commands.add(new SlashBan());
            commands.add(new SlashKick());
            commands.add(new UserPunishments());
            commands.add(new UserNicknames());

            // Admin Commands
            commands.add(new Punishment());
            commands.add(new ReactionRoles());
            commands.add(new MediaOnly());
            commands.add(new Notifications());
            commands.add(new Lockdown());
            commands.add(new UpdateCommands());
            commands.add(new LogChannelConfig());
            commands.add(new ModmailConfig());
            commands.add(new ModerationConfig());
            commands.add(new GuildMemberCountChannel());
            commands.add(new Purge());

        // User Commands
            // Admin Commands
            commands.add(new ModUnmodMember());

            // Moderation Commands
            commands.add(new UserContextWarn());
            commands.add(new UserContextMute());

            // General Commands
            commands.add(new RoleRemove());

        // Message Commands
            // General Commands
            commands.add(new Report());


        this.commands.forEach(this.jda::addEventListener);
    }
}
