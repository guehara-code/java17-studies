package dev.lpa;

import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.URI;

public class WebSocketClient {

    public static void main(String[] args) throws URISyntaxException {

        HttpClient client = HttpClient.newHttpClient();
        WebSocket webSocket = client.newWebSocketBuilder()
                .buildAsync(new URI("ws://localhost:8080"),
                        new WebSocket.Listener() {
                        }).join();
    }
}
