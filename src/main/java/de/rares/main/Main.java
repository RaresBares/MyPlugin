package de.rares.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.awt.*;

public class Main extends JavaPlugin implements Listener {
    public static Main main;
    @Override
    public void onEnable() {
        this.main = this;
        Runnable r = new Runnable() {
            public void run() {
                for(int i = 3; i >= 1; i--) {
                 System.out.println("System startet in " + i);
                }

                Bukkit.getPluginManager().registerEvents(main, main);
                System.out.println("System gestartet");
            }
        };

        Thread t = new Thread(r);
        t.start();

    }

    @EventHandler
    public void chat(AsyncPlayerChatEvent pe){

        String prefix = "§";
        Player p = pe.getPlayer();
        if(p.hasPermission("owner.prefix")){
            prefix += "4 OWNER |";
        }else
        if(p.hasPermission("admin.prefix")){
            prefix += "c ADMIN |";
        }else
        if(p.hasPermission("supporter.prefix")){
            prefix += "e SUPP |";
        }else
        if(p.hasPermission("developer.prefix")){
            prefix += "b DEV |";
        }else
        if(p.hasPermission("builder.prefix")){
            prefix += "a BUILDER |";
        }else
        if(p.hasPermission("yt.prefix")){
            prefix += "5 YT |";
        }else
        if(p.hasPermission("supreme.prefix")){
            prefix += "d SUPREME |";
        }else
        if(p.hasPermission("ultra.prefix")){
            prefix += "3 OWNER |";
        }else
        if(p.hasPermission("griefer.prefix")){
            prefix += "4 OWNER |";
        }else
        if(p.hasPermission("premium.prefix")){
            prefix += "6 OWNER |";
        }else{
            prefix += "7 SPIELER |";
        }

            pe.setFormat(prefix + " " + p.getName() + " >> §f" + pe.getMessage());



    }

}
