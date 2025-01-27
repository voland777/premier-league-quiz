package com.footballquiz.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    private static final String API_URL = "https://footballapi.pulselive.com/football/standings?compSeasons={seasonId}&altIds=true&detail=2&FOOTBALL_COMPETITION=1";

    public static String getFixturesTable (String seasonId) {
        String urlString = API_URL.replace("{seasonId}", seasonId);
        HttpURLConnection con = null;
        BufferedReader in = null;
        try {
            URL url = new URL(urlString);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } catch (IOException e) {
            System.err.println("Error making GET request: " + e.getMessage());
            return null;
        } finally {
            // Ensure resources are cleaned up, regardless of success or failure
            try {
                if (in != null) in.close();
                if (con != null) con.disconnect();
            } catch (IOException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
