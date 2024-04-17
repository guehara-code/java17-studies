package dev.lpa;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

import static java.net.HttpURLConnection.HTTP_OK;

public class ASyncHandlerClient {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://localhost:8080");
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(url.toURI())
                    .header("User-Agent", "Chrome")
                    .headers("Accept", "application/json", "Accept", "text/html")
                    .timeout(Duration.ofSeconds(30))
                    .build();

            HttpResponse<Stream<String>> response;
            CompletableFuture<HttpResponse<Stream<String>>> responseFuture =
                    client.sendAsync(request, HttpResponse.BodyHandlers.ofLines());

            responseFuture.thenAccept(ASyncHandlerClient::handleResponse);

            System.out.println("Tem Jobs to do besides handling the response.");
            int jobs = 0;
            while (jobs++ <  10) {
                TimeUnit.SECONDS.sleep(1);
                System.out.printf("Job %d ", jobs);
            }
        } catch (IOException | URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void handleResponse(HttpResponse<Stream<String>> response) {

        if (response.statusCode() == HTTP_OK) {
            response.body()
                    .filter(s -> s.contains("<h1>"))
                    .map(s -> s.replaceAll("<[^>]*>", "").strip())
                    .forEach(System.out::println);
        } else {
            System.out.println("Error reading response " + response.uri());
        }
    }

}
