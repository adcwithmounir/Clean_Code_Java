# 🧹 Clean Code in Java

Source code of the YouTube series **Clean Code in Java** by **ADC with Mounir**.

Every episode takes one topic of clean code and applies it to the same app, **CleanPlate** 🍽️, a small
food-delivery app (customers, restaurants, couriers, orders, delivery fees). Each lab starts from code that works
but is hard to read, then cleans it up step by step: one small change, its explanation, then the next one.

> "Clean your plate": finish your meal. Here, it means leaving the code cleaner than you found it.

## 📚 Episodes

| # | Episode | Code | Status |
|:-:|---|---|:-:|
| 1 | Clean Code | [`CleanCode_1_Clean_Code/`](CleanCode_1_Clean_Code/) | ✅ |
| 2 | Meaningful Names | [`CleanCode_2_Meaningful_Names/`](CleanCode_2_Meaningful_Names/) | ✅ |
| 3 | Functions | [`CleanCode_3_Functions/`](CleanCode_3_Functions/) | ✅ |
| 4 | Comments | `CleanCode_4_Comments/` | 🔜 |
| 5 | Formatting | `CleanCode_5_Formatting/` | 🔜 |
| 6 | Objects and Data Structures | `CleanCode_6_Objects_And_Data_Structures/` | 🔜 |
| 7 | Error Handling | `CleanCode_7_Error_Handling/` | 🔜 |
| 8 | Boundaries | `CleanCode_8_Boundaries/` | 🔜 |
| 9 | Unit Tests | `CleanCode_9_Unit_Tests/` | 🔜 |
| 10 | Classes | `CleanCode_10_Classes/` | 🔜 |
| 11 | Systems | `CleanCode_11_Systems/` | 🔜 |
| 12 | Emergence | `CleanCode_12_Emergence/` | 🔜 |
| 13 | Concurrency | `CleanCode_13_Concurrency/` | 🔜 |
| 14 | Successive Refinement | `CleanCode_14_Successive_Refinement/` | 🔜 |
| 15 | Smells and Heuristics | `CleanCode_15_Smells_And_Heuristics/` | 🔜 |
| 16 | Review & Practice Questions | — (no lab) | 🔜 |

✅ Available · 🔜 Coming soon

## 🗂️ Layout of an episode

```
CleanCode_N_<Topic>/
  before/   the code as it starts in the video: it works, but it is messy
  after/    the same behaviour, cleaned up as in the video
```

Plain Java files, no package, no build tool: each folder compiles and runs on its own.

## ▶️ Run it

Requirements: **Java 25** (the labs use compact source files: `void main()`, `IO.println`, run directly with `java File.java`).

```bash
cd CleanCode_1_Clean_Code/after
java OrderTotal.java
```

Run `before/` and `after/` side by side: the output is the same, only the code got cleaner.

### 🧪 Tests (JUnit 5)

Episodes with tests use **JUnit 5** through the standalone launcher, no build tool needed. Download
`junit-platform-console-standalone-1.11.4.jar` from Maven Central into `lib/`, then:

```bash
javac -cp ../../lib/junit-platform-console-standalone-1.11.4.jar -d out *.java
java -jar ../../lib/junit-platform-console-standalone-1.11.4.jar -cp out --scan-classpath
```

## 📖 Inspired by

*Clean Code: A Handbook of Agile Software Craftsmanship* — Robert C. Martin (Prentice Hall).
All explanations, examples and code in this repository and in the videos are original.

## 🎬 The series

YouTube channel: **ADC with Mounir** — playlist *Clean Code in Java*.

## 📄 License

[MIT](LICENSE)
