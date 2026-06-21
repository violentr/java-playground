# How to Maven

Maven builds Java projects from `pom.xml`: compile, test, package JARs, and download dependencies.

Working example in this repo: [`Bootcamp/pom.xml`](../../pom.xml) (run `mvn` from the `Bootcamp/` directory).

## Prerequisites

- JDK installed (`java -version`)
- Maven installed (`brew install maven` → `mvn -v`)

Run all commands from the project root (where `pom.xml` lives).

For this Bootcamp project:

```bash
cd /path/to/java-playground/Bootcamp
mvn compile
```

---

## List available goals and phases

Maven has no single `mvn list tasks` command (unlike Gradle's `gradle tasks`). Use the **help plugin** instead.

### Default lifecycle phases

These are the built-in phases you can run directly:

| Phase | What it does |
|-------|----------------|
| `validate` | Check project is valid |
| `compile` | Compile main source code |
| `test` | Run unit tests |
| `package` | Build JAR/WAR |
| `verify` | Run integration checks |
| `install` | Install artifact to local `~/.m2` repo |
| `deploy` | Deploy to remote repository |

Phases run in order: `compile` → `test` → `package` → `install` → `deploy`.

### Describe a lifecycle phase

```bash
mvn help:describe -Dcmd=compile
mvn help:describe -Dcmd=package -Ddetail
```

### See what plugins run for a phase (full build plan)

```bash
mvn help:describe -Dcmd=package -Ddetail -Dfull=true
```

Example output for this project:

```text
compile  → maven-compiler-plugin:compile
test     → maven-surefire-plugin:test
package  → maven-jar-plugin:jar
install  → maven-install-plugin:install
```

### List goals for a specific plugin

```bash
mvn help:describe -Dplugin=compiler -Ddetail
mvn help:describe -Dplugin=clean -Ddetail
mvn help:describe -Dplugin=surefire -Ddetail
mvn help:describe -Dplugin=jar -Ddetail
```

### List project profiles

```bash
mvn help:all-profiles
```

### General help

```bash
mvn --help
mvn help:system
```

---

## Create a new project

```bash
cd java_api_lab
mvn archetype:generate \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DarchetypeVersion=1.3 \
  -DgroupId=com.hyperskill \
  -DartifactId=first-maven-app \
  -DinteractiveMode=false
```

Generated layout:

| Path | Purpose |
|------|---------|
| `pom.xml` | Project config, dependencies, plugins |
| `src/main/java/` | Application code |
| `src/test/java/` | Tests |
| `target/` | Build output (auto-generated, safe to delete) |

---

## This repo's `pom.xml` (Bootcamp)

The Bootcamp `pom.xml` uses a flat layout (not the standard `src/main/java`):

| Setting | Value |
|---------|-------|
| Source root | `.` (entire Bootcamp folder) |
| Compiled classes | `out/` |
| Java version | 21 (`<maven.compiler.release>21</maven.compiler.release>`) |
| Plugins configured | `maven-compiler-plugin` only |

```bash
cd Bootcamp
mvn compile          # compiles **/*.java → out/
mvn clean compile    # deletes target/, then compiles
mvn package          # compile + test + build JAR in target/
```

---

## Minimal `pom.xml`

```xml
<groupId>com.example</groupId>
<artifactId>my-app</artifactId>
<version>1.0-SNAPSHOT</version>

<properties>
  <maven.compiler.release>21</maven.compiler.release>
</properties>

<dependencies>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

- **groupId** — org/namespace (e.g. `com.example`)
- **artifactId** — project name
- **version** — `SNAPSHOT` = work in progress

---

## Daily commands

| Goal | Command |
|------|---------|
| Compile | `mvn compile` |
| Run tests | `mvn test` |
| Build JAR | `mvn package` |
| Clean build output | `mvn clean` |
| Clean + build | `mvn clean package` |
| Install to local repo | `mvn install` |
| Skip tests | `mvn package -DskipTests` |
| Quiet output | `mvn -q compile` |
| Verbose debug log | `mvn compile -X` |

---

## Add a dependency

1. Add inside `<dependencies>` in `pom.xml`
2. Refresh/reimport in IDE, or run `mvn compile`

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.11.0</version>
</dependency>
```

Common scopes: **compile** (default), **test** (tests only), **provided** (server gives it at runtime).

Find coordinates at [search.maven.org](https://search.maven.org/).

---

## Run your app

### Option A — `java -cp` (works now, no plugin needed)

After `mvn compile`:

```bash
# Bootcamp example: run Main.java
java -cp out java_api_lab.week01_02_type_system.Main

# Standard layout example
java -cp target/classes com.example.App
```

### Option B — `exec-maven-plugin` (add to `pom.xml` first)

The exec plugin is **not** in Bootcamp's `pom.xml` yet. Add it to run via Maven:

```xml
<plugin>
  <groupId>org.codehaus.mojo</groupId>
  <artifactId>exec-maven-plugin</artifactId>
  <version>3.5.0</version>
  <configuration>
    <mainClass>java_api_lab.week01_02_type_system.Main</mainClass>
  </configuration>
</plugin>
```

Then:

```bash
mvn compile exec:java
```

Or override main class on the command line (no pom change):

```bash
mvn compile exec:java -Dexec.mainClass="java_api_lab.week01_02_type_system.Main"
```

### Option C — runnable JAR

After `mvn package`:

```bash
java -jar target/bootcamp-1.0-SNAPSHOT.jar
```

Requires `Main-Class` in the JAR manifest (configure `maven-jar-plugin` or use a shade plugin).

---

## Useful one-liners

```bash
mvn -q test                              # quiet test run
mvn dependency:tree                      # show dependency tree (debug conflicts)
mvn dependency:resolve                   # download dependencies
mvn clean compile -X                     # verbose compile (debug build issues)
mvn help:describe -Dcmd=package -Dfull=true   # list phases + bound plugin goals
mvn help:describe -Dplugin=compiler -Ddetail  # list compiler plugin goals
mvn help:all-profiles                    # list available profiles
mvn validate                             # quick sanity check of pom.xml
mvn -version                             # Maven + Java version info
```

---

## Maven vs manual build

| Step | Manual | Maven |
|------|--------|-------|
| Compile | `javac ...` | `mvn compile` |
| Run tests | set up JUnit classpath by hand | `mvn test` |
| Package JAR | `jar cfm ...` | `mvn package` |
| Add library | download JAR, set `-cp` | add `<dependency>` |
| List tasks | N/A | `mvn help:describe ...` (see above) |

See also: [create_jar_files.md](create_jar_files.md), [how-to-gradle.md](how-to-gradle.md).

---

## Common mistakes

- **Wrong directory** — run `mvn` where `pom.xml` is (`Bootcamp/`), not from `java_api_lab/notes/`
- **Dependency not found in IDE** — reimport Maven project or run `mvn compile`
- **Java version mismatch** — set `<maven.compiler.release>` to match your JDK
- **Editing `target/` or `out/`** — always edit source `.java` files; build dirs are regenerated
- **Forgetting tests location** — tests go in `src/test/java` (standard layout), not next to main code
- **Expecting `mvn list tasks`** — use `mvn help:describe` instead (Maven has no Gradle-style task list)
- **`mvn exec:java` fails** — add `exec-maven-plugin` to `pom.xml`, or use `java -cp out ...` after compile
