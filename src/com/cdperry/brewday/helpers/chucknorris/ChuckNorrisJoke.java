package com.cdperry.brewday.helpers.chucknorris;

import java.net.MalformedURLException;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

/**
 * This class is used to pull a joke from the Internet Chuck Norris Database (http://www.icndb.com)
 * The API returns results in JSON which are then made available as a string.
 */
public class ChuckNorrisJoke {

    private final Logger log = Logger.getLogger(this.getClass());

    private String joke;

    public ChuckNorrisJoke() {
        this.joke = this.retrieveChuckNorrisJoke();
    }

    public String getJoke() {
        return this.joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    /**
     * This method returns a joke from the API
     * @return a String containing a Chuck Norris joke
     */
    private String retrieveChuckNorrisJoke() {

        ObjectMapper mapper = new ObjectMapper();
        String API;
        String joke = "";
        ChuckNorrisContainer container;
        ChuckNorrisResult result;

        API = "http://api.icndb.com/jokes/random";

        try {

            container = mapper.readValue(new URL(API), ChuckNorrisContainer.class);

            result = container.getValue();

            if (container.getType().equals("success")) {
                joke = result.getJoke();
            } else {
                joke = "Chuck Norris is sleeping today.  No jokes for you.";
            }

        } catch (MalformedURLException ex) {
            log.error(ex.getStackTrace());
        } catch (Exception ex) {
            log.error(ex.getStackTrace());
        }

        log.warn(joke);

        return joke;

    }

    public static void main(String[] args) {

        String joke;
        ChuckNorrisJoke q = new ChuckNorrisJoke();

        joke = q.getJoke();

    }

}
