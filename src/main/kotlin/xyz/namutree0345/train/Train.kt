package xyz.namutree0345.train

import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

val trainMap: HashMap<Player, Player> = HashMap()

class Train : JavaPlugin() {

    override fun onEnable() {
        getCommand("train")?.setExecutor(TrainCommand())
    }

}