# matplotlib4j

## How to use?

Here is an example. Find more examples on `MainTest.java`

```java
    Plot plt = new PlotImpl();
    plt.plot()
        .add(Arrays.asList(1.3, 2))
        .label("label")
        .linestyle("--");
    plt.xlabel("xlabel");
    plt.ylabel("ylabel");
    plt.text(0.5, 0.2, "text");
    plt.title("Title!");
    plt.legend();
    plt.show();
```

## Configure on your project

Currently this project is not registered on the public repository. It is required to publish to your maven repository first.

```bash
gradle publishToMavenLocal
```

Then import to your project.

**Maven**

```xml
<dependency>
    <groupId>com.github.sh0nk.matplotlib4j</groupId>
    <artifactId>matplotlib4j</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

**Gradle**

```groovy
compile 'com.github.sh0nk.matplotlib4j:matplotlib4j:1.0.0-SNAPSHOT'
```