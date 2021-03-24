package com.codecool.chessopen;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessResults {

    public List<String> getCompetitorsNamesFromFile(String fileName) {

        File file = new File(fileName);
        HashMap<String, Integer> chessGames = new HashMap<>();
        List<String> chessPlayers = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                String playerName = temp[0];
                Integer playersGameResult = (Integer.parseInt(temp[1]) +
                        Integer.parseInt(temp[2]) +
                        Integer.parseInt(temp[3]) +
                        Integer.parseInt(temp[4]) +
                        Integer.parseInt(temp[5])) * -1;

                chessGames.put(playerName, playersGameResult);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        chessGames.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(stringIntegerEntry -> chessPlayers.add(stringIntegerEntry.getKey()));

        return chessPlayers;
    }
}
