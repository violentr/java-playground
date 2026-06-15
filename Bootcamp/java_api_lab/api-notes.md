# Index Cards

One-line notes from [Habit 3](habits.md).

Format: **When I need to ___, I use ___.**

---

## Week 01–02: Type System (Ch 4)

| Date       | When I need to...                    | I use...                                                              |
|------------|--------------------------------------|-----------------------------------------------------------------------|
| 09/06/2026 | Make HTTP request                    | `HttpRequest.newBuilder().build()` & send with `HttpClient`           |
| 10/06/2026 | Type-safe reusable container         | `class Box<T>`, `List<String>`, `new Box<>(...)` (diamond)            |
| 11/06/2026 | Handle a nullable value safely       | `Optional.ofNullable(x).map(...).orElse(...)`                         |
| 11/06/2026 | Lazy default when Optional is empty  | `optional.orElseGet(() -> new User("default"))`                       |
| 15/06/2026 | Filter/map a list in a chain         | `list.stream().filter(...).map(...).toList()`                         |
| 15/06/2026 | Pass short logic into a method       | lambda: `p -> p.getName().startsWith("J")`                            |
| 15/06/2026 | Shorthand for a simple lambda        | method reference: `User::getName`, `System.out::println`              |
| 15/06/2026 | Store a reusable boolean check       | `Predicate<T> p = x -> ...; p.test(x)`                                |
| 15/06/2026 | Run an action on each item           | `list.forEach(...)` or `stream().forEach(...)`                        |


## Week 03–04: Collections (Ch 8)

| Date | When I need to... | I use... |
|------|-------------------|----------|
|      |                   |          |

## Week 05–06: Data Formats (Ch 9)

| Date | When I need to... | I use... |
|------|-------------------|----------|
|      |                   |          |

## Week 07–08: I/O (Ch 10)

| Date | When I need to... | I use... |
|------|-------------------|----------|
|      |                   |          |

## Week 09–10: Concurrency (Ch 6)

| Date | When I need to... | I use... |
|------|-------------------|----------|
|      |                   |          |

## Week 11–12: Platform (Ch 11–13)

| Date | When I need to... | I use... |
|------|-------------------|----------|
|      |                   |          |
