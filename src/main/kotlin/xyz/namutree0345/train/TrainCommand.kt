package xyz.namutree0345.train

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class TrainCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(args.isNotEmpty()) {
            trainMap[sender as Player] = Bukkit.getPlayer(args[0])!!
            val id = Bukkit.getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getPlugin(Train::class.java),
                {
                    if(trainMap.containsKey(sender)) {
                        val loc = trainMap[sender]!!.location.clone()
                        loc.x = loc.direction.x * (-2)
                        loc.z = loc.direction.z * (-2)
                        sender.teleport(loc)
                    }
                }, 0L, 1L)
            Bukkit.getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getPlugin(Train::class.java),
                {
                    if(!trainMap.containsKey(sender))
                        Bukkit.getScheduler().cancelTask(id)
                }, 0L, 1L)
        }
        return true
    }
}