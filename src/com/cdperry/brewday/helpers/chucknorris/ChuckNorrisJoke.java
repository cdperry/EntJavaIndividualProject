package com.cdperry.brewday.helpers.chucknorris;

import java.net.MalformedURLException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import java.io.*;
import javax.json.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;

/**
 * This class is used to pull a joke from the Internet Chuck Norris Database (http://www.icndb.com)
 * The API returns results in JSON which are then made available as a string.
 */
public class ChuckNorrisJoke {

    private final Logger log = Logger.getLogger(this.getClass());

    private String joke;

    public ChuckNorrisJoke() {
        this.joke = this.retrieveChuckNorrisJokeAlternate();
    }

    public String getJoke() {
        return this.joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    /**
     * As a backup in case the proxy stops working before class ...
     *
     * @return a String representing a Ron Swanson quote
     */
    public String retrieveRonSwansonQuote() {

        BufferedReader httpResponse = null;
        JsonReader myJSONReader = null;
        HttpURLConnection urlConnection = null;

        joke = "Ron Swanson broke the internet";

        try {

            URL API = new URL("http://ron-swanson-quotes.herokuapp.com/v2/quotes");
            urlConnection = (HttpURLConnection) API.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Accept", "application/json");

            if (urlConnection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + urlConnection.getResponseCode());
            }

            httpResponse = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));

            String jsonResponse;
            StringBuilder parsedHTML = new StringBuilder();


            while ((jsonResponse = httpResponse.readLine()) != null) {
                parsedHTML.append(jsonResponse);
            }

            joke = parsedHTML.toString();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            try {

                if (httpResponse != null) {
                    httpResponse.close();
                }

                if (myJSONReader != null) {
                    myJSONReader.close();
                }

                if (urlConnection != null) {
                    urlConnection.disconnect();
                }

            } catch (Exception ex) {
                log.error(ex);
            }

        }

        return joke;

    }


    /**
     *  This method uses an alternate method of connecting to the REST API - on OpenShift I was having trouble
     *  using Jackson (I was getting HTTP 403 FORBIDDEN responses)
     *
     * @return a String containing a Chuck Norris joke
     */
    public String retrieveChuckNorrisJokeAlternate() {

        BufferedReader httpResponse = null;
        JsonReader myJSONReader = null;
        HttpURLConnection urlConnection = null;

        joke = "Chuck Norris broke the internet";

        try {

            URL API = new URL("http://api.icndb.com/jokes/random/");
            //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("52.58.120.225", 3128));
            urlConnection = (HttpURLConnection) API.openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Accept", "application/json");

            if (urlConnection.getResponseCode() != 200) {
                joke = "Uh, oh. HTTP " + urlConnection.getResponseCode() + " - Chuck Norris broke the internet.";
                throw new RuntimeException("Failed : HTTP error code : "
                        + urlConnection.getResponseCode());
            }

            httpResponse = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));

            String jsonResponse;
            StringBuilder parsedHTML = new StringBuilder();


            while ((jsonResponse = httpResponse.readLine()) != null) {
                parsedHTML.append(jsonResponse);
            }

            myJSONReader = Json.createReader(new StringReader(parsedHTML.toString()));
            JsonObject myJSONObject = myJSONReader.readObject();

            if (myJSONObject.getString("type").equals("success")) {
                joke = myJSONObject.getJsonObject("value").getString("joke");
            } else {
                joke = "Chuck Norris is sleeping - no, I mean waiting - today.  No jokes for you.";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            try {

                if (httpResponse != null) {
                    httpResponse.close();
                }

                if (myJSONReader != null) {
                    myJSONReader.close();
                }

                if (urlConnection != null) {
                    urlConnection.disconnect();
                }

            } catch (Exception ex) {
                log.error(ex);
            }

        }

        return joke;

    }

    /**
     * This method returns a joke from the API
     * @return a String containing a Chuck Norris joke
     */
    private String retrieveChuckNorrisJokeJackson() {

        ObjectMapper mapper = new ObjectMapper();
        String API;
        String joke = "";
        ChuckNorrisContainer container;
        ChuckNorrisResult result;

        API = "http://api.icndb.com/jokes/random/";

        try {

            container = mapper.readValue(new URL(API), ChuckNorrisContainer.class);

            result = container.getValue();

            if (container.getType().equals("success")) {
                joke = result.getJoke();
            } else {
                joke = "Chuck Norris is sleeping - no, I mean waiting - today.  No jokes for you.";
            }

        } catch (MalformedURLException ex) {
            joke = "Chuck Norris broke the internet.";
            log.error(ex);
        } catch (Exception ex) {
            joke = "Chuck Norris broke the internet.";
            log.error(ex);
        }

        return joke;

    }

    public static void main(String[] args) {

        String joke;
        ChuckNorrisJoke q = new ChuckNorrisJoke();
        Logger log = Logger.getLogger(q.getClass());

        log.warn(q.getJoke());

    }

}
