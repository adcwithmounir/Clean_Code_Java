# Clean Code in Java #1: Clean Code

Video: https://youtu.be/vUTNmloVt8g

- `before/Calc.java`: an order total that works but nobody can read (`calc(l, t, f)`, arrays of numbers, magic numbers).
- `after/OrderTotal.java`: the same logic, clean (`CartItem`, `DeliveryZone`, named constants, small methods), then
  the new rule of the lab: free delivery for orders over 40 euros.

Java 25 compact source files, run them directly:

```bash
cd before && java Calc.java          # 32.89
cd ../after && java OrderTotal.java  # Dinner for two: 32.89 / Office party: 45.00
```
