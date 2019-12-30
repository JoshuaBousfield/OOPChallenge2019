package com.Beardly;

class Addition {
    private double price = 0;
    private String name;

    public Addition(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return this.name;
    }
}

class Lettuce extends Addition {
    public Lettuce() {
        super(.50, "Lettuce");
    }
}

class Bacon extends Addition {
    public Bacon() {
        super(1.50, "Bacon");
    }
}

class Cheese extends Addition {
    public Cheese() {
        super(1.00, "Cheese");
    }
}

class Tomato extends Addition {
    public Tomato() {
        super(.50, "Tomato");
    }
}

class Beetroot extends Addition {
    public Beetroot() {
        super(.50, "Beetroot");
    }
}

class Onion extends Addition {
    public Onion() {
        super(.50, "Onion");
    }
}

class Chips extends Addition {
    public Chips() {
        super(3.00, "Chips");
    }
}

class Drink extends Addition {
    public Drink() {
        super(2.5, "Drink");
    }
}

class NoAddition extends Addition {
    public NoAddition() {
        super(0, "null");
    }
}

class TotalAdditions {
    private Addition addition1;
    private Addition addition2;
    private Addition addition3;
    private Addition addition4;
    private Addition addition5;
    private Addition addition6;
    private int i = 1;

    public TotalAdditions(Addition addition1, Addition addition2, Addition addition3, Addition addition4, Addition addition5, Addition addition6) {
        this.addition1 = addition1;
        this.addition2 = addition2;
        this.addition3 = addition3;
        this.addition4 = addition4;
        this.addition5 = addition5;
        this.addition6 = addition6;
    }

    public TotalAdditions(Addition addition1, Addition addition2, Addition addition3, Addition addition4) {
        this.addition1 = addition1;
        this.addition2 = addition2;
        this.addition3 = addition3;
        this.addition4 = addition4;
    }

    public TotalAdditions() {
        this.addition1 = new Drink();
        this.addition2 = new Chips();
        this.addition3 = new NoAddition();
        this.addition4 = new NoAddition();
    }

    public double healthyAdditionCost() {
        double additions = additionCost() + addition5.getPrice() + addition6.getPrice();
        if (addition5.getName() != "null"){ System.out.println("Addition " + i + ":" + addition5.getName() + " $" + addition5.getPrice()); i++; }
        if (addition6.getName() != "null"){ System.out.println("Addition " + i + ":" + addition6.getName() + " $" + addition6.getPrice()); i++; }
        return additions;
    }

    public double additionCost() {
        if (addition1.getName() != "null"){ System.out.println("Addition " + i + ":" + addition1.getName() + " $" + addition1.getPrice()); i++; }
        if (addition2.getName() != "null"){ System.out.println("Addition " + i + ":" + addition2.getName() + " $" + addition2.getPrice()); i++; }
        if (addition3.getName() != "null"){ System.out.println("Addition " + i + ":" + addition3.getName() + " $" + addition3.getPrice()); i++; }
        if (addition4.getName() != "null"){ System.out.println("Addition " + i + ":" + addition4.getName() + " $" + addition4.getPrice()); i++; }
        return (addition1.getPrice() + addition2.getPrice() + addition3.getPrice() + addition4.getPrice());
    }
}

public class Hamburger {
    private String rollType;
    private String meatType;
    private double price;
    private String name;

    public Hamburger(String rollType, String meatType, double price, String name) {
        this.rollType = rollType;
        this.meatType = meatType;
        this.price = price;
        this.name = name;
    }

    public double billSpecial() {
        double billTotalAdditions = new TotalAdditions(new Cheese(), new NoAddition(), new NoAddition(), new NoAddition()).additionCost();
        double total = calculateTotalPrice(billTotalAdditions);
        System.out.println("Ordering the bill special, that comes to $" + total + "\n");
        return total;
    }

    public double bobSpecial() {
        double bobTotalAdditions = new TotalAdditions(new Bacon(), new NoAddition(), new NoAddition(), new NoAddition()).additionCost();
        double total = calculateTotalPrice(bobTotalAdditions);
        System.out.println("Ordering the Bob Special cost is $" + total + "\n");

        return total;
    }

    public double calculateTotalPrice(double totalAdditions) {
        System.out.println("Base price of burger: $" + this.price);
        double totalPrice =  (this.price + totalAdditions);
        System.out.println("Total cost for " + getName() + " is: $" + totalPrice);
        return totalPrice;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

class HealthyBurger {
    Hamburger hamburger = new Hamburger("Rye", "beef", 5.00, "Healthy Burger");
    public double orderHealthyBurger(Addition addition1, Addition addition2, Addition addition3, Addition addition4,
                              Addition addition5, Addition addition6) {
        double additions = new TotalAdditions(addition1, addition2, addition3, addition4, addition5, addition6).healthyAdditionCost();
        return hamburger.calculateTotalPrice(additions);
    }
}

class DeluxeBurger {
    Hamburger hamburger = new Hamburger("white", "beef", 3.00, "Deluxe Burger");
    TotalAdditions totalAdditions = new TotalAdditions();

    public double orderDeluxe() {
        double totalCost = hamburger.calculateTotalPrice(totalAdditions.additionCost());
        return totalCost;
    }
}
