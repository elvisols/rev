package com.bank.rev;

import com.bank.rev.dao.gen.tables.Account;
import com.bank.rev.dao.gen.tables.pojos.Transfer;
import com.bank.rev.util.Config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jooq.Configuration;
import org.jooq.impl.DSL;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.jooq.impl.DSL.sum;
import static org.junit.Assert.assertEquals;

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
    public void transferFundTest() throws SQLException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        // get opening balance
        BigDecimal oBalance = DSL.using(Config.getInstance().getConfiguration()).select(sum(Account.ACCOUNT.BALANCE)).from(Account.ACCOUNT).fetchOneInto(BigDecimal.class);

        Instant start = Instant.now();

        // perform concurrent transfers between accounts.
        while (countDownLatch.getCount() > 0) {
            countDownLatch.countDown();
            performTest();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

        // get closing balance
        BigDecimal cBalance = DSL.using(Config.getInstance().getConfiguration()).select(sum(Account.ACCOUNT.BALANCE)).from(Account.ACCOUNT).fetchOneInto(BigDecimal.class);
        // check if sample transfers are consistent
        assertEquals(oBalance, cBalance);
    }

    private void performTest() {
        CountDownLatch latch = new CountDownLatch(8);
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Runnable transfer1 = () -> {
            while (true) {
                try {
                    int randNumber = rand.nextInt(70000);
                    Transfer transfer = new Transfer("tr1", BigDecimal.valueOf(randNumber), "USD", "2222222222", "1111111111", "txnNarration", "abc123", null);
                    doTransfer(transfer);
                    latch.countDown();
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
                    int randNumber = rand.nextInt(70000);
                    Transfer transfer = new Transfer("tr2", BigDecimal.valueOf(randNumber), "USD", "3333333333", "2222222222", "txnNarration", "abc123", null);
                    doTransfer(transfer);
                    latch.countDown();
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
                    int randNumber = rand.nextInt(70000);
                    Transfer transfer = new Transfer("tr3", BigDecimal.valueOf(randNumber), "USD", "4444444444", "3333333333", "txnNarration", "abc123", null);
                    doTransfer(transfer);
                    latch.countDown();
                    Thread.sleep(500);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable transfer4 = () -> {
            while (true) {
                try {
                    int randNumber = rand.nextInt(70000);
                    Transfer transfer = new Transfer("tr4", BigDecimal.valueOf(randNumber), "USD", "1111111111", "4444444444", "txnNarration", "abc123", null);
                    doTransfer(transfer);
                    latch.countDown();
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
        executorService.submit(transfer4);

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
