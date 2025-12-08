package org.example;

class Task {
    private int number;
    private String description;

    public Task(int number, String description) {
        this.number = number;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%d. %s", number, description);
    }
}
