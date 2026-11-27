record Item(String name, double price, int quantity) {
    double subtotal() {
        return price * quantity;
    }
}

enum Delivery { STANDARD, EXPRESS }

record OrderRequest(String customer, List<Item> items, String promoCode, Delivery delivery) {}

record Order(String customer, double total) {}

final double WELCOME_DISCOUNT = 0.10;
final double EXPRESS_FEE = 5.99;
final double STANDARD_FEE = 2.99;
final double FREE_DELIVERY_FROM = 25.00;

Order placeOrder(OrderRequest request) {
    requireItems(request.items());
    Order order = new Order(request.customer(), totalOf(request));
    sendConfirmation(order);
    return order;
}

void requireItems(List<Item> items) {
    if (items.isEmpty()) {
        throw new IllegalArgumentException("Cart is empty");
    }
}

double totalOf(OrderRequest request) {
    double amount = applyPromo(subtotalOf(request.items()), request.promoCode());
    return amount + deliveryFee(request.delivery(), amount);
}

double subtotalOf(List<Item> items) {
    return items.stream().mapToDouble(Item::subtotal).sum();
}

double applyPromo(double amount, String promoCode) {
    return "WELCOME10".equals(promoCode) ? amount * (1 - WELCOME_DISCOUNT) : amount;
}

double deliveryFee(Delivery delivery, double amount) {
    return switch (delivery) {
        case EXPRESS -> EXPRESS_FEE;
        case STANDARD -> amount < FREE_DELIVERY_FROM ? STANDARD_FEE : 0;
    };
}

void sendConfirmation(Order order) {
    IO.println("SMS to %s: order confirmed, %.2f".formatted(order.customer(), order.total()));
}

void tryPlacing(OrderRequest request) {
    try {
        Order order = placeOrder(request);
        IO.println("Total: %.2f".formatted(order.total()));
    } catch (IllegalArgumentException e) {
        IO.println("Refused: " + e.getMessage());
    }
}

void main() {
    List<Item> cart = List.of(new Item("Margherita", 9.50, 2), new Item("Tiramisu", 4.00, 1));
    tryPlacing(new OrderRequest("Lena", cart, "WELCOME10", Delivery.EXPRESS));
    tryPlacing(new OrderRequest("Sam", List.of(), null, Delivery.STANDARD));
}
