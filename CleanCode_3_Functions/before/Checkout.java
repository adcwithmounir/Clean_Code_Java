record Item(String name, double price, int quantity) {}

double placeOrder(String customer, List<Item> items, String promo, boolean express) {
    if (items.isEmpty()) {
        IO.println("Cart is empty");
        return -1;
    }
    double total = 0;
    for (Item item : items) {
        total += item.price() * item.quantity();
    }
    if (promo != null) {
        if (promo.equals("WELCOME10")) {
            total = total * 0.9;
        }
    }
    if (express) {
        total += 5.99;
    } else {
        if (total < 25) {
            total += 2.99;
        }
    }
    IO.println("SMS to " + customer + ": order confirmed, " + String.format("%.2f", total));
    return total;
}

void main() {
    List<Item> cart = List.of(new Item("Margherita", 9.50, 2), new Item("Tiramisu", 4.00, 1));
    IO.println(String.format("%.2f", placeOrder("Lena", cart, "WELCOME10", true)));
    IO.println(placeOrder("Sam", List.of(), null, false));
}
