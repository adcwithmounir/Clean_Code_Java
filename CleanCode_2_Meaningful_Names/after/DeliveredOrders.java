enum OrderStatus { PLACED, PREPARING, ON_THE_WAY, DELIVERED }

record Order(int id, String customer, OrderStatus status, double amount) {
    boolean isDelivered() {
        return status == OrderStatus.DELIVERED;
    }
}

final double COURIER_COMMISSION_RATE = 0.15;

Map<Integer, Order> ordersById = new HashMap<>();

void add(Order order) {
    ordersById.put(order.id(), order);
}

List<Order> deliveredOrders() {
    return ordersById.values().stream().filter(Order::isDelivered).toList();
}

double courierCommission() {
    double commission = 0;
    for (Order order : deliveredOrders()) {
        commission += order.amount() * COURIER_COMMISSION_RATE;
    }
    return commission;
}

void main() {
    add(new Order(101, "Lena", OrderStatus.DELIVERED, 42.00));
    add(new Order(102, "Sam", OrderStatus.PLACED, 18.50));
    add(new Order(103, "Ana", OrderStatus.DELIVERED, 26.00));
    IO.println("Delivered orders: " + deliveredOrders().size());
    IO.println("Courier commission: %.2f".formatted(courierCommission()));
}
