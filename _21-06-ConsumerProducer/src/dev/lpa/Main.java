package dev.lpa;


class MessageRepository {

    private String message;
    private boolean hasMessage = false;

    public synchronized String read() {

        while (!hasMessage) {

        }
        hasMessage = false;
        return message;
    }

    public synchronized void write(String message) {

        while (hasMessage) {

        }
        hasMessage = true;
        this.message = message;
    }

}

class MessageWriter implements Runnable {

    private MessageRepository outgoingMessage;
    private final String test = """
            
      
            """
    @Override
    public void run() {

    }
}

public class Main {

    public static void main(String[] args) {

    }

}
