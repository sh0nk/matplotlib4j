# matplotlib4j

A simplest way to make matplotlib feasible on your java project. Of course it is able to be imported to scala project as below. The API is designed as similar to the original matplotlib's.

![Screenshot](https://user-images.githubusercontent.com/6478810/31043250-bdacdd12-a5f3-11e7-88ee-0e91c851c6f7.png)

## How to use

Here is an example. Find more examples on `MainTest.java`

```java
    Plot plt = Plot.create();
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

Currently this project is not registered on a public repository. It is required to publish to your maven local repository first.

```bash
./gradlew publishToMavenLocal
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

Make sure that `mavenLocal()` is defined in repositories on your `build.gradle`.

```groovy
compile 'com.github.sh0nk.matplotlib4j:matplotlib4j:1.0.0-SNAPSHOT'
```