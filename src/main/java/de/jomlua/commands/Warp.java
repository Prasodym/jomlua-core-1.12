package de.jomlua.commands;

import de.jomlua.utils.ChatOutput;
import de.jomlua.utils.PrivatPermissions;
import de.jomlua.utils.modules.Teleport;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Warp implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) sender;
        String prefix = ChatOutput.PREFIX.getText();

        if (!(player.hasPermission(PrivatPermissions.SETSPAWN.getText()))){
            player.sendMessage(prefix + ChatOutput.NO_PERMISSIONS.getText());
            return true;
        }
        if (!(sender instanceof Player)){
            sender.sendMessage(ChatOutput.NO_PLAYER.getText());
            return true;
        }

        if (command.getName().equalsIgnoreCase("warp")) {
            if (args.length == 1) {
                if (Teleport.getBooleanWarp(args[0])) {

                   player.teleport(Teleport.TeleportWarp(args[0]));

                    player.sendMessage("§aWarpe zu §c" + args[0]);

                }else{
                    player.sendMessage(ChatOutput.PREFIX.getText() + "§cDieser Warp ist noch nicht gesetzt.");
                }
            }else{
                player.sendMessage(ChatOutput.PREFIX.getText() + "§7Befehle die dir helfen könnten.");
                player.sendMessage("§7- §e/§bwarp §c[name]");
            }
        }
        if (command.getName().equalsIgnoreCase("setwarp")) {
            if (args.length == 1) {

                    try {
                        Teleport.SetWarp(player,args[0]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    player.sendMessage(ChatOutput.PREFIX.getText() + "§a Warp §c" + args[0] + " §awurde gesetzt.");

            }else{
                player.sendMessage(ChatOutput.PREFIX.getText() + "§7Befehle die dir helfen könnten.");
                player.sendMessage("§7- §e/§bwarp §c[name]");
            }
        }

        return true;
    }
}
