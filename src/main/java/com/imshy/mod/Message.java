package com.imshy.mod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Message {
    private final String message;
    private final String[] words;

    // all lowercase
    private final List<String> MEAN_MESSAGES = new ArrayList<String>(
            Arrays.asList("l", "loser", "bad")
    );

    public Message(String message) {
        this.message = message;
        this.words = message.split(" ");

    }

    public String getMessage() {
        return message;
    }

    public String[] getWords() {
        return words;
    }

    public boolean isDerogatory() {
        try {
            getDerogatoryWord();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    private String getDerogatoryWord() {
        final String[] words = message.split(" ");
        System.out.println(Arrays.toString(words));
        for (String word : words)
            if (isWordDerogatory(word))
                return word;
        throw new NoSuchElementException("No derogatory word found in phrase");
    }

    private boolean isWordDerogatory(String word) {
        return MEAN_MESSAGES.contains(word.toLowerCase());
    }

    public String getSender() {
        return unformatName(words[0]);
    }

    private String unformatName(String name) {

        String unformatted = name;
        while(unformatted.contains("[") && unformatted.contains("]")) {
            //removes ranks that are formatted as [rank]
            unformatted = unformatted.substring(unformatted.indexOf("]")+1);
        }
        // only keeps letters and numbers
        unformatted = unformatted.replaceAll("[^a-zA-Z0-9]", "");
        return unformatted;

    }

}
