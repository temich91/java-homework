package edu.phystech.hw2.contact;

import java.lang.Comparable;

public record Contact(String username, String email) implements Comparable<Contact> {
    public static final String UNKNOWN_EMAIL = "unknown";

    public Contact {
        if (username.isBlank()) {
            throw new InvalidContactFieldException("username");
        }
        if ((email.isBlank()) || ((!email.endsWith("@gmail.com")) && (!email.equals(UNKNOWN_EMAIL)))) {
            throw new InvalidContactFieldException("email");
        }
    }

    public Contact(String username) {
        this(username, UNKNOWN_EMAIL);
    }


    public int compareTo(Contact o) {
        return this.username.length() - o.username.length();
    }
}
