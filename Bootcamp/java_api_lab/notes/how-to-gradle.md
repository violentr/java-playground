# How to Gradle

Gradle is a build tool that runs **tasks** defined in build scripts. This lab uses it to compile Java, package JARs, and automate small workflows.

Working example in this repo: [`gradle-demo/`](../gradle-demo/).

## Prerequisites

- JDK installed (`java -version`)
- macOS with [Homebrew](https://brew.sh/) (for install below), or Gradle installed another way

## Install Gradle

```bash
brew install gradle
gradle -v
```

`gradle -v` prints the Gradle and JVM versions. New projects should prefer the **Gradle Wrapper** (`./gradlew`) so everyone uses the same Gradle version — `gradle init` creates it automatically.

---

## Create a new project

From the directory where you want the project:

```bash
cd java_api_lab
gradle init
```

Answer the prompts (application, Java, Groovy DSL, etc.) or accept defaults. Gradle generates:

| File / folder | Purpose |
|---------------|---------|
| `build.gradle` | Tasks and build logic for this project |
| `settings.gradle` | Project name and included modules |
| `gradlew`, `gradlew.bat` | Wrapper scripts — run Gradle without a global install |
| `gradle/wrapper/` | Wrapper JAR and pinned Gradle version |

Use the wrapper from the project root:

```bash
cd gradle-demo
./gradlew tasks
```

On Windows: `gradlew.bat tasks`.

---

## Simple custom task

Add a task to `build.gradle`. This matches [`gradle-demo/build.gradle`](../gradle-demo/build.gradle):

```groovy
description = "A basic Gradle Project"

tasks.register("helloGradle") {
    doLast {
        println "Hello Gradle!"
    }
}
```

Older Groovy style (still valid):

```groovy
task helloGradle {
    doLast {
        println "Hello Gradle!"
    }
}
```

- `description` — shown in task listings
- `doLast { }` — code that runs when the task executes
- Task name → run with `./gradlew helloGradle`

### Run one task

```bash
./gradlew helloGradle
```

Expected output:

```text
> Task :helloGradle
Hello Gradle!

BUILD SUCCESSFUL
```

### List tasks

```bash
# Summary of available tasks
./gradlew tasks

# Every task, including internal ones
./gradlew tasks --all
```

Built-in tasks (e.g. `build`, `clean`) appear when you apply plugins such as `java` or `application`. A minimal init project may only show your custom tasks until you add plugins.

---

## Gradle vs manual JAR build

| Step | Manual (see [create_jar_files.md](create_jar_files.md)) | Gradle |
|------|-----------------------------------------------------------|--------|
| Compile | `javac ...` | `./gradlew compileJava` (with `java` plugin) |
| Package JAR | `jar cfm ...` or `zip` | `./gradlew jar` |
| Run app | `java -jar app.jar` | `./gradlew run` (with `application` plugin) |

Gradle encodes those steps in `build.gradle` so you repeat one command instead of remembering flags and paths.

---

## Quick reference

| Goal | Command |
|------|---------|
| Check version | `gradle -v` or `./gradlew -v` |
| Create project | `gradle init` |
| Run a task | `./gradlew <taskName>` |
| List tasks | `./gradlew tasks` |
| List all tasks | `./gradlew tasks --all` |
| Run with stack trace on failure | `./gradlew <taskName> --stacktrace` |

---

## Common mistakes

- **Running from the wrong directory** — execute `./gradlew` from the project root (where `settings.gradle` lives)
- **Using global `gradle` instead of `./gradlew`** — wrapper keeps the build on Gradle 9.5.1 (or whatever is in `gradle/wrapper/gradle-wrapper.properties`)
- **Editing only `build.gradle` and forgetting to save** — Gradle reads the file on each run; unsaved changes are not picked up
- **Expecting `java -jar` behavior from a bare task** — custom tasks like `helloGradle` only run what you put in `doLast`; JAR output needs a `jar` task or the `java` plugin
