package org.example.SpringMVCApp.util;

public enum Postgres {
    URL("jdbc:postgresql://localhost:5432/my_db"),
    USER_NAME("postgres"),
    PASSWORD("postgres"),
    DRIVER("org.postgresql.Driver");

    private final String init;

    Postgres(String init) {
        this.init = init;
    }

    public String get() {
        return init;
    }
}
