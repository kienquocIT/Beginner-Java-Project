package org.example;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        boolean isExit = false;

        while (!isExit) {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/2eb0a3ff3ae297b883ca6a5b/latest/VND"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject obj = new JSONObject(response.body());
            double rateUSD = obj.getJSONObject("conversion_rates").getDouble("USD");
            double rateEUR = obj.getJSONObject("conversion_rates").getDouble("EUR");

            System.out.println("=== Currency Converter to VND ===");

            System.out.println("1. View the currency code");
            System.out.println("2. Convert to VND");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1 USD = " + 1/rateUSD + "VND");
                    System.out.println("1 EUR = " + 1/rateEUR + "VND");
                    break;
                case 2:
                    System.out.print("Please enter your amount: ");
                    double amount = new Scanner(System.in).nextDouble();
                    System.out.println("- " + amount + " USD = " + amount * (1/rateUSD) + "VND");
                    System.out.println("- "  + amount + " EUR = " + amount * (1/rateEUR) + "VND");
                    break;
                case 3:
                    isExit = true;
                    break;
            }
        }
    }
}