record CartItem(String name, double price, int quantity) {
    double subtotal() {
        return price * quantity;
    }
}

record Customer(String name, boolean student) {}

// TODO: read these offers from the restaurant settings once the admin page exists.
final String WELCOME_CODE = "WELCOME10";
final double WELCOME_RATE = 0.10;
final double WELCOME_MINIMUM = 20.00;
final double STUDENT_RATE = 0.05;

double discountFor(Customer customer, List<CartItem> items, String promoCode) {
    double subtotal = subtotalOf(items);
    // Offers never stack: when the welcome offer applies, it replaces the student rate.
    if (isWelcomeOffer(promoCode, subtotal)) {
        return subtotal * WELCOME_RATE;
    }
    return customer.student() ? subtotal * STUDENT_RATE : 0;
}

double subtotalOf(List<CartItem> items) {
    return items.stream().mapToDouble(CartItem::subtotal).sum();
}

boolean isWelcomeOffer(String promoCode, double subtotal) {
    return WELCOME_CODE.equals(promoCode) && subtotal >= WELCOME_MINIMUM;
}

void main() {
    List<CartItem> cart = List.of(new CartItem("Margherita", 9.50, 2), new CartItem("Tiramisu", 4.00, 1));
    Customer lena = new Customer("Lena", false);
    Customer sam = new Customer("Sam", true);
    IO.println("Lena, welcome code: %.2f".formatted(discountFor(lena, cart, WELCOME_CODE)));
    IO.println("Sam, student: %.2f".formatted(discountFor(sam, cart, null)));
    IO.println("Sam, both: %.2f".formatted(discountFor(sam, cart, WELCOME_CODE)));
}
