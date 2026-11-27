# Clean Code in Java #2: Meaningful Names

Video: https://youtu.be/4NWIWwIVK88

- `before/Dlv.java`: delivered orders and courier commission, with names that break the rules (`OrdInfo`, `strCust`,
  `st == 3`, an `orderList` that is a map, `fetch` / `retrieveTot`, a bare `0.15`).
- `after/DeliveredOrders.java`: the same logic with meaningful names (`OrderStatus`, `Order.isDelivered()`,
  `COURIER_COMMISSION_RATE`, `ordersById`, `deliveredOrders()`, `courierCommission()`).

Java 25 compact source files, run them directly:

```bash
cd before && java Dlv.java                # 2 10.20
cd ../after && java DeliveredOrders.java  # Delivered orders: 2 / Courier commission: 10.20
```
