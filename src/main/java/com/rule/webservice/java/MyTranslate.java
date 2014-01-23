package com.rule.webservice.java;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Document me please
 * User: wfijarczyk
 * Date: 23.01.14
 */
public class MyTranslate {

    private static final String SERVICE_URL = "http://api.microsofttranslator.com/V2/Http.svc/Translate?";
    private static final String TOKEN_URL = "https://datamarket.accesscontrol.windows.net/v2/OAuth2-13?";
    private static final String ENCODING = "UTF-8";
    private String apiKey;
    private String clientId;
    private String clientSecret;
    private String token;
    private String contentType = "text/plain";


    public String retrieveResponse(String word){
        String clientId = PropertyHandler.getClientId();
        String clientSecret = PropertyHandler.getSecret();

        try {
            String tokenJson  = getToken(clientId,clientSecret);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "chuj";
    }

    public String getToken(String clientId, String clientSecret) throws Exception {
        final URL tokenUrl = new URL(TOKEN_URL);
        final HttpURLConnection connection = (HttpURLConnection) tokenUrl.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=" + ENCODING);
        connection.setRequestProperty("Accept-Charset", ENCODING);
        connection.setDoOutput(true);

        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
        wr.write(buildTokenUrlParameters(clientId, clientSecret));
        wr.flush();


        try {
            int responseCode = connection.getResponseCode();
            String result = convertInputStreamToString(connection.getInputStream());

            if (responseCode != 200) {
                throw new Exception("Error: " + result);
            }
            return result;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private String convertInputStreamToString(final InputStream inputStream) {

        StringBuilder outputBuilder = new StringBuilder();

        if (inputStream == null) {
            return null;
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, ENCODING));
            String string;
            while (null != (string = reader.readLine())) {
                outputBuilder.append(string);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputBuilder.toString();
    }

    private String buildTokenUrlParameters(final String clientId, final String clientSecret) throws MalformedURLException, UnsupportedEncodingException {

        return "grant_type=client_credentials&scope=http://api.microsofttranslator.com"
                + "&client_id=" + URLEncoder.encode(clientId, ENCODING)
                + "&client_secret=" + URLEncoder.encode(clientSecret, ENCODING);

    }

    private URL buildTranslateUrl(final String text) throws UnsupportedEncodingException, MalformedURLException {
        final String params = "from=" + URLEncoder.encode("en", ENCODING)
                + "&to=" + URLEncoder.encode("pl", ENCODING)
                + "&text=" + URLEncoder.encode(text, ENCODING);

        return new URL(SERVICE_URL + params);

    }


}
