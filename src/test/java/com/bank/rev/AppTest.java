package com.bank.rev;

import com.bank.rev.dao.gen.tables.pojos.Transfer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Assume the RESTApi is called by multiple systems
 */
public class AppTest {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Random rand = new Random();

    @BeforeClass
    public static void startServer() {
        App.main(null);
        System.out.println("server started...");
    }

    @Test
    public void transferFundTest() {
        // infinite loop
        while (true) {
            performTest();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void performTest() {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable transfer1 = () -> {
            while (true) {
                try {
                    int randNumber = rand.nextInt(10000);
                    Transfer transfer = new Transfer("tr1", BigDecimal.valueOf(randNumber), "NGN", "2222222222", "1111111111", "txnNarration", "abc123", null);
                    doTransfer(transfer);
                    Thread.sleep(500);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable transfer2 = () -> {
            while (true) {
                try {
                    int randNumber = rand.nextInt(10000);
                    Transfer transfer = new Transfer("tr2", BigDecimal.valueOf(randNumber), "NGN", "2222222222", "3333333333", "txnNarration", "abc123", null);
                    doTransfer(transfer);
                    Thread.sleep(500);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable transfer3 = () -> {
            while (true) {
                try {
                    int randNumber = rand.nextInt(10000);
                    Transfer transfer = new Transfer("tr3", BigDecimal.valueOf(randNumber), "NGN", "3333333333", "1111111111", "txnNarration", "abc123", null);
                    doTransfer(transfer);
                    Thread.sleep(500);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        executorService.submit(transfer1);
        executorService.submit(transfer2);
        executorService.submit(transfer3);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doTransfer(final Transfer transfer) throws IOException {
        URL url = new URL("http://localhost:7001/transfers");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("charset", "utf-8");
        connection.setReadTimeout(1000);
        connection.setDoOutput(true);
        connection.getOutputStream().write(gson.toJson(transfer).getBytes());

        // read the response
        int responseCode = connection.getResponseCode();
        System.out.println("Response code:" + responseCode);
        if (responseCode == 200) {
            System.out.println(transfer.getRef() + ": " + readFromStream(connection.getInputStream()));
        }
        connection.disconnect();
    }

    private String readFromStream(final InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuilder sb = new StringBuilder(500);
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

}
