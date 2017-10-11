package de.linzn.vikiSpeechApi;


public class App {
    public App() {
        byte[] bytes = VikiSpeechAPI.requestVoiceStream("Hallo ich bin Viki. Wie geht es dir? Ich hoffe ich kann dir helfen!");
        VikiSpeechAPI.playVoiceStream(bytes);
    }

    public static void main(String[] args) {
        new App();
    }


}