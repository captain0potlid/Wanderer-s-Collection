package com.ex.ex

import com.destroystokyo.paper.event.player.PlayerJumpEvent
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerChatEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class events: Listener {
    val joinmsg = "" + ChatColor.GREEN + " ● " + ChatColor.ITALIC + "" + ChatColor.WHITE
    val quitmsg = "" + ChatColor.RED + " ● " + ChatColor.ITALIC + "" + ChatColor.WHITE

    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent): Unit {
        val p: Player = e.player
        e.joinMessage = "$joinmsg" + p.name
    }

    @EventHandler
    fun onPlayerQuit(e: PlayerQuitEvent): Unit {
        val p: Player = e.player
        e.quitMessage = "$quitmsg" + p.name
    }

    @EventHandler
    fun onPlayerJump(e: PlayerChatEvent): Unit {
        val p: Player = e.player
        e.isCancelled = true
        Bukkit.broadcastMessage("" + ChatColor.RED + "점프 금지!")
    }
}