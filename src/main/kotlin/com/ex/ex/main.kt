package com.ex.ex

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class main: JavaPlugin() {

    override fun onEnable() {
        logger.info("enabled")

        Bukkit.getPluginManager().registerEvents(events(), this)
        getCommand("ting").setExecutor(cmd())
    }

    override fun onDisable() {
        logger.info("disabled")
    }
}