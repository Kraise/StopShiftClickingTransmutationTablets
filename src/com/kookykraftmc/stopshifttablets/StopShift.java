package com.kookykraftmc.stopshifttablets;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class StopShift extends JavaPlugin implements Listener
{
    static final Logger log = Bukkit.getLogger();
    public void onEnable()
    {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }
    
    @EventHandler
    public void onShiftClick(InventoryClickEvent e)
    {
        if(e.getInventory() == null)
            return;
        if(!e.getInventory().getType().name().equals("CHEST"))
            return;
        if(!e.getClick().isShiftClick())
            return;
        if(!e.getInventory().getTitle().equals("container.ee3:transmutationTablet"))
            return;
        /* Need some test and will fix name */
        if(!e.getInventory().getTitle().equals("container.ae2:craftingTerminal"))
            return;
        Player p = (Player) e.getWhoClicked();
        p.sendMessage(ChatColor.RED + "Do not shift click transmutation tablets or crafting terminal!");
        Vector v = new Vector();
        v.setX(5.0);
        v.setZ(5.0);
        p.setVelocity(v);
        e.setCancelled(true);

    }
}
