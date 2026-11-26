record CartItem(String name, double unitPrice, int quantity) {
    double subtotal() {
        return unitPrice * quantity;
    }
}

enum DeliveryZone {
    CITY(2.99), SUBURB(4.99);

    final double fee;

    DeliveryZone(double fee) {
        this.fee = fee;
    }
}

final double PROMO_RATE = 0.10;
final double PROMO_MINIMUM = 20.00;
final double FREE_DELIVERY_MINIMUM = 40.00;

double itemsTotal(List<CartItem> items) {
    double total = 0;
    for (CartItem item : items) {
        total += item.subtotal();
    }
    return total;
}

double withPromo(double total, boolean hasPromoCode) {
    if (hasPromoCode && total > PROMO_MINIMUM) {
        return total - total * PROMO_RATE;
    }
    return total;
}

double deliveryFee(double total, DeliveryZone zone) {
    return total >= FREE_DELIVERY_MINIMUM ? 0 : zone.fee;
}

double orderTotal(List<CartItem> items, DeliveryZone zone, boolean hasPromoCode) {
    double total = withPromo(itemsTotal(items), hasPromoCode);
    return roundToCents(total + deliveryFee(total, zone));
}

double roundToCents(double amount) {
    return Math.round(amount * 100) / 100.0;
}

void main() {
    var dinner = List.of(new CartItem("Margherita", 12.50, 2), new CartItem("Tiramisu", 6.00, 1));
    IO.println("Dinner for two: %.2f".formatted(orderTotal(dinner, DeliveryZone.SUBURB, true)));
    var party = List.of(new CartItem("Margherita", 12.50, 4));
    IO.println("Office party: %.2f".formatted(orderTotal(party, DeliveryZone.SUBURB, true)));
}
