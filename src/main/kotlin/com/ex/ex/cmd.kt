package com.ex.ex

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player

class cmd: TabExecutor {

    var tab1: MutableList<String>? = ArrayList<String>()


    override fun onCommand(sender: CommandSender,command: Command,label: String,args: Array<out String>): Boolean {
        if(sender is Player) {
            val p: Player = sender
            if(args.size >= 0) {
                val w = args[0].toFloat()
                p.flySpeed = w
//                if(args[0] == "test") {
//                    p.sendMessage("hello")
//                }
            }
        }
        return false
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): MutableList<String>? {
        if(args.size == 1) {
            return tab1()
        }
        return null
    }
    fun tab1(): MutableList<String>? {
        if(tab1?.size!! > 0) return tab1
        tab1?.add("record")
        tab1?.add("기록") // 플레이어 전체 기록 불러오기(명령어 하나 연동 더 할듯!)

        tab1?.add("separate")
        tab1?.add("격리") // 다른 공간에 혼자 10분정도 격리. args 뒤에 시간(초) 필수

        tab1?.add("alert")
        tab1?.add("공지") // 긴급 공지 및 서버 공지 선택 가능

        tab1?.add("msg")
        tab1?.add("전송") // private 메세지 보내기

        tab1?.add("run")
        tab1?.add("실행") // minecraft command 이거 실행하기
        return tab1
    }
}