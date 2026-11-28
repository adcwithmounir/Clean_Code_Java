// Changes:
// 12-Mar  added WELCOME10 (Sam)
// 02-Apr  fixed rounding (Lena)
// 19-Apr  added students (Sam)

/** The cart item. */
record CartItem(String name, double price, int quantity) {}

// Returns the discount
double discount(List<CartItem> items, String code, boolean student) {
    double t = 0; // the total
    for (CartItem i : items) {
        t += i.price() * i.quantity();
    } // end for
    // welcome code and a cart of at least 20 euros
    if (code != null && code.equals("WELCOME10") && t >= 20) {
        return t * 0.10;
    }
    // if (code.equals("SUMMER15")) return t * 0.15;
    // students always get 5 percent
    if (student) {
        return t * 0.05;
    } // end if
    return 0; // return zero
}

// ////////////// main //////////////
void main() {
    List<CartItem> cart = List.of(new CartItem("Margherita", 9.50, 2), new CartItem("Tiramisu", 4.00, 1));
    IO.println("%.2f".formatted(discount(cart, "WELCOME10", false))); // Lena
    IO.println("%.2f".formatted(discount(cart, null, true))); // Sam
    IO.println("%.2f".formatted(discount(cart, "WELCOME10", true))); // Sam again
}
