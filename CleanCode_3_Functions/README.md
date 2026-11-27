# Clean Code in Java #3: Functions

Video: https://youtu.be/gC-IX4O8C6I

- `before/Checkout.java`: the checkout of CleanPlate in one long `placeOrder` function (four arguments, a boolean
  `express` flag, nested ifs, magic numbers, a `-1` error code and a hidden text message).
- `after/OrderPlacement.java`: the same checkout split into small functions that read from top to bottom (`Delivery`
  enum instead of the flag, `OrderRequest` argument object, `placeOrder` → `requireItems` / `totalOf` /
  `sendConfirmation`, `subtotalOf` / `applyPromo` / `deliveryFee`, an exception instead of `-1`, `tryPlacing` for the
  error handling).

Java 25 compact source files, run them directly:

```bash
cd before && java Checkout.java              # SMS to Lena… 26.69 / 26.69 / Cart is empty / -1.0
cd ../after && java OrderPlacement.java      # SMS to Lena… 26.69 / Total: 26.69 / Refused: Cart is empty
```
