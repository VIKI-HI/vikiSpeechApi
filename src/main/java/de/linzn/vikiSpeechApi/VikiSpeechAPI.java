package de.linzn.vikiSpeechApi;

public class VikiSpeechAPI {

    public static byte[] requestVoiceStream(final String voiceText) {
        return new InternalCore().request_voice_stream(voiceText);
    }

    public static boolean playVoiceStream(final byte[] bytes) {
        return new InternalCore().play_voice_stream(bytes);
    }
}
