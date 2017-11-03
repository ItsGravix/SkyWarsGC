package com.gravix.skywars;

import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Board
{
    // Hay que crear la clase de la arena para poner a funcionar la board...
    public static void ScoreBoard(final Player player) {
        if (player != null) {
            final Date now = new Date();
            final SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yy");
            final String dateNow = dmy.format(now);
            HashMap<String, Integer> data = null;
            String titulo = "SKYWARS";
            if (player.getGame() != null) {
                final Arena map = player.getGame();
                if (map.getGameState() == Arena.GameState.WAITING) {
                    data = new HashMap<String, Integer>();
                    titulo = "§e§lSKYWARS";
                    int account = 15;
                    for (final String list : Config.get().getConfig().getStringList("waiting.lineas")) {
                        data.put(getVars(map, player, list, dateNow), account);
                        --account;
                    }
                }
                else if (map.getGameState() == Arena.GameState.STARTING) {
                    data = new HashMap<String, Integer>();
                    titulo = "§e§lSKYWARS";
                    int account = 15;
                    for (final String list : Config.get().getConfig().getStringList("starting.lineas")) {
                        data.put(getVars(map, player, list, dateNow), account);
                        --account;
                    }
                }
                else if (map.getGameState() == Arena.GameState.PREGAME) {
                    data = new HashMap<String, Integer>();
                    titulo = "§e§lSKYWARS";
                    int account = 15;
                    for (final String list : Config.get().getConfig().getStringList("pregame.lineas")) {
                        data.put(getVars(map, player, list, dateNow), account);
                        --account;
                    }
                }
                else if (map.getGameState() == Arena.GameState.PLAYING) {
                    data = new HashMap<String, Integer>();
                    titulo = "§e§lSKYWARS";
                    int account = 15;
                    for (final String list : Config.get().getConfig().getStringList("playing.lineas")) {
                        data.put(getVars(map, player, list, dateNow), account);
                        --account;
                    }
                }
                else {
                    data = new HashMap<String, Integer>();
                    titulo = "§e§lSKYWARS";
                    int account = 15;
                    for (final String list : Config.get().getConfig().getStringList("playing.lineas")) {
                        data.put(getVars(map, player, list, dateNow), account);
                        --account;
                    }
                }
            }
            else {
                data = new HashMap<String, Integer>();
                titulo = "§e§lSKYWARS";
                int account2 = 15;
                for (final String list2 : Config.get().getConfig().getStringList("lobby.lineas")) {
                    Player p = player.getP();
                    data.put(getVarsLobby(player, list2, dateNow, p), account2);
                    --account2;
                }
            }
            BoardIterator.ScoreboardUtil.rankedSidebarDisplay(player.getP(), titulo, data);
        }
    }

    public static String getVars(final Arena arena, final Player player, final String texto, final String date) {
        return texto.replaceAll("%map%", arena.getName());
    }

    public static String getVarsLobby(final Player player, final String texto, final String date, final Player p) {
        return texto.replaceAll("%kills%", new StringBuilder().append(player.getKills()).toString()).replaceAll("%deaths%", new StringBuilder().append(player.getDeaths()).toString()).replaceAll("%date%", date);
    }
}