# Clean Code in Java #4: Comments

Video: https://youtu.be/CM_ZP4FmD8E

- `before/PromoRules.java`: the promo rules of CleanPlate, full of comments (a change journal, a mandated Javadoc,
  redundant and noise comments, a comment doing the job of a name, closing brace comments, a comment explaining a
  condition, commented-out code, a banner, comments on arguments, and a misleading "students always get 5 percent").
- `after/PromoDiscounts.java`: the same rules, rewritten so the code explains itself (`CartItem.subtotal()`, a
  `Customer` record instead of a boolean, named offers, `subtotalOf`, `isWelcomeOffer`, labelled output). Two comments
  are kept: a TODO and an explanation of intent ("offers never stack").

Java 25 compact source files, run them directly:

```bash
cd before && java PromoRules.java            # 2.30 / 1.15 / 2.30
cd ../after && java PromoDiscounts.java      # Lena, welcome code: 2.30 / Sam, student: 1.15 / Sam, both: 2.30
```

Inspired by *Clean Code: A Handbook of Agile Software Craftsmanship* — Robert C. Martin (Prentice Hall), chapter 4.
All explanations, examples and code are original.
