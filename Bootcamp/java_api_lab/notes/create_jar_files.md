# Create JAR Files

A JAR file is a ZIP archive that holds compiled `.class` files and optional metadata. You can build one by hand to see how `java -jar` and the classpath work.

## Prerequisites

- A compiled class, e.g. `myapp/Main.class` (from `javac myapp/Main.java`)
- Working directory: `java_api_lab/`

## Option A — Runnable JAR (with manifest)

Use this when you want `java -jar myapp.jar`.

### 1. Create `META-INF/MANIFEST.MF`

The manifest tells the JVM which class contains `main`. It must end with a **blank line**.

```text
Manifest-Version: 1.0
Created-By: 9.0.1 (Oracle Corporation)
Main-Class: myapp.Main

```

`Main-Class` is the fully qualified name of the class with the `main` method (package + class, no `.class` suffix).

### 2. Build the JAR

From `java_api_lab/`, include the manifest, your classes, and any package directories:

```bash
# Manual ZIP approach (same structure as jar)
zip -r app.zip META-INF myapp
mv app.zip myapp.jar

# Or use the jar tool (preferred)
jar cfm myapp.jar META-INF/MANIFEST.MF myapp/Main.class
```

Expected layout inside `myapp.jar`:

```text
META-INF/
  MANIFEST.MF
myapp/
  Main.class
```

### 3. Run

```bash
java -jar myapp.jar
```

The JVM reads `Main-Class` from the manifest and starts that class.

---

## Option B — JAR without a manifest

Without `Main-Class` in the manifest, `java -jar` will fail. Put the JAR on the classpath and name the entry class explicitly:

```bash
java -cp myapp.jar myapp.Main
```

- `-cp myapp.jar` — treat the JAR as a folder of classes
- `myapp.Main` — fully qualified class name (second argument), not a `.class` file path

### Finding the entry class inside an unknown JAR

If you do not know the package or class name, inspect the archive:

```bash
# List contents
jar tf myapp.jar

# Or extract and browse
unzip myapp.jar -d extracted/
find extracted -name "*.class"
```

Use the path under `extracted/` to derive the class name: `extracted/myapp/Main.class` → `myapp.Main`.

---

## Quick reference

| Goal | Command |
|------|---------|
| Run with manifest | `java -jar myapp.jar` |
| Run without manifest | `java -cp myapp.jar myapp.Main` |
| Create JAR with manifest | `jar cfm myapp.jar META-INF/MANIFEST.MF myapp/Main.class` |
| List JAR contents | `jar tf myapp.jar` |

## Common mistakes

- **Missing blank line** at the end of `MANIFEST.MF` — manifest may be ignored
- **Wrong `Main-Class`** — must match package + class (e.g. `myapp.Main`, not `Main` or `myapp/Main.class`)
- **Classes not at JAR root** — `myapp/Main.class` must appear as `myapp/Main.class` inside the archive, not nested under an extra folder
- **Using `-jar` without a manifest** — use `-cp` and the class name instead
