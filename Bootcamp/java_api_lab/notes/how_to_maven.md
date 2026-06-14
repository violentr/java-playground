# How to Maven

Maven builds Java projects from `pom.xml`: compile, test, package JARs, and download dependencies.

Working example in this repo: [`mvn_demo/first-maven-app/`](../mvn_demo/first-maven-app/).

## Prerequisites

- JDK installed (`java -version`)
- Maven installed (`brew install maven` → `mvn -v`)

Run all commands from the project root (where `pom.xml` lives).

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

Lifecycle runs phases in order: `compile` → `test` → `package`.

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

**After `mvn package`:**

```bash
# Runnable JAR (needs Main-Class in manifest — see exec plugin below)
java -jar target/my-app-1.0-SNAPSHOT.jar

# Or run a class directly with classpath
java -cp target/classes com.example.App
```

**Run without packaging** (add plugin to `pom.xml`):

```xml
<plugin>
  <groupId>org.codehaus.mojo</groupId>
  <artifactId>exec-maven-plugin</artifactId>
  <version>3.5.0</version>
  <configuration>
    <mainClass>com.example.App</mainClass>
  </configuration>
</plugin>
```

```bash
mvn exec:java
```

---

## Useful one-liners

```bash
mvn -q test                    # quiet test run
mvn dependency:tree            # show dependency tree (debug conflicts)
mvn clean compile -X           # verbose compile (debug build issues)
```

---

## Maven vs manual build

| Step | Manual | Maven |
|------|--------|-------|
| Compile | `javac ...` | `mvn compile` |
| Run tests | set up JUnit classpath by hand | `mvn test` |
| Package JAR | `jar cfm ...` | `mvn package` |
| Add library | download JAR, set `-cp` | add `<dependency>` |

See also: [create_jar_files.md](create_jar_files.md), [how-to-gradle.md](how-to-gradle.md).

---

## Common mistakes

- **Wrong directory** — run `mvn` where `pom.xml` is, not from a parent folder
- **Dependency not found in IDE** — reimport Maven project or run `mvn compile`
- **Java version mismatch** — set `<maven.compiler.release>` to match your JDK
- **Editing `target/`** — always edit `src/`; `target/` is regenerated on each build
- **Forgetting tests location** — tests go in `src/test/java`, not next to main code
