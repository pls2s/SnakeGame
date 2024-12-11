/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs318_project;
import java.io.*;
import java.util.*;

public class ScoreManager {

    public static void saveScore(String playerName, int score, String difficulty) {
        String scoreFile = getScoreFile(difficulty);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(scoreFile, true))) {
            writer.write(playerName + "," + score);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> loadScores(String difficulty) {
        Map<String, Integer> scores = new HashMap<>();
        String scoreFile = getScoreFile(difficulty);
        try (BufferedReader reader = new BufferedReader(new FileReader(scoreFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int score = Integer.parseInt(parts[1].trim());
                    scores.put(name, Math.max(scores.getOrDefault(name, 0), score)); // เก็บคะแนนสูงสุด
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scores;
    }

    private static String getScoreFile(String difficulty) {
        switch (difficulty.toLowerCase()) {
            case "easy" -> {
                return System.getProperty("user.home") + "\\Documents\\scores_easy.txt";
            }
            case "medium" -> {
                return System.getProperty("user.home") + "\\Documents\\scores_medium.txt";
            }
            case "hard" -> {
                return System.getProperty("user.home") + "\\Documents\\scores_hard.txt";
            }
            default -> throw new IllegalArgumentException("Invalid difficulty: " + difficulty);
        }
    }
}

