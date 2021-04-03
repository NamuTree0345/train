package xyz.namutree0345.train

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class TrainReleaseCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(args.isNotEmpty()) {
            if(trainMap.containsKey(Bukkit.getPlayer(args[0]))) {
                trainMap.remove(Bukkit.getPlayer(args[0]))
            }
        }
        return true
    }

}
