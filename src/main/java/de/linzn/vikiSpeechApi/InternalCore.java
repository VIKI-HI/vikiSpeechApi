package de.linzn.vikiSpeechApi;

import com.darkprograms.speech.synthesiser.Synthesiser;
import javazoom.jl.player.Player;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class InternalCore {

    private static byte[] readBytes(InputStream input) throws IOException {
        byte[] buffer = new byte[8192];
        int bytesRead;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        System.out.println("receivedBytes: " + output.toByteArray().length);
        return output.toByteArray();
    }

    public byte[] request_voice_stream(String voiceTest) {
        String language = "de-de";
        byte[] bytes = null;
        Synthesiser synth = new Synthesiser(language);
        try {
            InputStream is = synth.getMP3Data(voiceTest);
            bytes = this.readBytes(is);
            System.out.println("voiceSize: " + bytes.length);
            //TODO Use any Java MP3 Implementation to play back the AudioFile from the InputStream.
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Error");
            e.printStackTrace();
        }
        return bytes;
    }

    public boolean play_voice_stream(byte[] bytes) {
        try {
            Player player = new Player(new ByteArrayInputStream(bytes));
            player.play();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
