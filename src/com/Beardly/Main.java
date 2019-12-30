package com.Beardly;

public class Main {

    public static void main(String[] args) {
       TotalAdditions totalAdditions = new TotalAdditions(new Cheese(), new NoAddition(), new Lettuce(), new NoAddition());
       Hamburger hamburger = new Hamburger("white", "beef", 4.00, "bill burger");

       double price = hamburger.calculateTotalPrice(totalAdditions.additionCost());
       System.out.println("Total cost: $" + price + "\n");

        hamburger.bobSpecial();
        hamburger.billSpecial();

        System.out.println("\n");
        HealthyBurger healthyBurger = new HealthyBurger();
        healthyBurger.orderHealthyBurger(new Cheese(), new Onion(), new Bacon(), new Lettuce(), new Tomato(), new Beetroot());

        System.out.println("\n");
        DeluxeBurger deluxeBurger = new DeluxeBurger();
        deluxeBurger.orderDeluxe();
        System.out.println("useless comment");
    }
}
