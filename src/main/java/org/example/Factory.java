package org.example;

class Factory {
    private int id;
    private String name;
    private String city;
    private int yearFounded;
    private int employees;
    private double profit; // in million USD

    public Factory(int id, String name, String city, int yearFounded, int employees, double profit) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.yearFounded = yearFounded;
        this.employees = employees;
        this.profit = profit;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCity() { return city; }
    public int getYearFounded() { return yearFounded; }
    public int getEmployees() { return employees; }
    public double getProfit() { return profit; }

    @Override
    public String toString() {
        return String.format("Factory{id=%d, name='%s', city='%s', year=%d, employees=%d, profit=%.1fM}",
                id, name, city, yearFounded, employees, profit);
    }
}
