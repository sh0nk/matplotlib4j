# matplotlib4j

A simplest library to make matplotlib feasible on your java project. Of course it is able to be imported to scala project as below. The API is designed as similar to the original matplotlib's.

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

Another example to draw **Contour**

![Screenshot](https://user-images.githubusercontent.com/6478810/31847390-d2422f2a-b656-11e7-9fca-d503cd70a253.png)

```java
List<Double> x = NumpyUtils.linspace(-1, 1, 100);
List<Double> y = NumpyUtils.linspace(-1, 1, 100);
NumpyUtils.Grid<Double> grid = NumpyUtils.meshgrid(x, y);

List<List<Double>> zCalced = grid.calcZ((xi, yj) -> Math.sqrt(xi * xi + yj * yj));

Plot plt = Plot.create();
ContourBuilder contour = plt.contour().add(x, y, zCalced);
plt.clabel(contour).inline(true).fontsize(10);
plt.title("contour");
plt.legend().loc("upper right");
plt.show();
```

### Pyenv support

It is possible to choose a python environment to run matplotlib with `pyenv` and `pyenv-virtualenv` support. Create `Plot` object by specifying existing names as follows.

```java
// with pyenv name
Plot plt = Plot.create(PythonConfig.pyenvConfig("anaconda3-4.4.0"));
// with pyenv and virtualenv name
Plot plt = Plot.create(PythonConfig.pyenvVirtualenvConfig("anaconda3-4.4.0", "env_plot"));
```

## Dependency

* Java 8
* Python with Matplotlib installed

It may work with almost all not too old `Python` and `Matplotlib` versions, but no guarantee. It has been tested with 

* Python 2.7.10
* Matplotlib 1.3.1

## Configure on your project

Currently this project is not registered on a public repository. It is required to publish to your maven local repository first.

```bash
./gradlew publishToMavenLocal
```

Then import to your project.

**Maven**

```xml
<dependency>
    <groupId>com.github.sh0nk</groupId>
    <artifactId>matplotlib4j</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

**Gradle**

Make sure that `mavenLocal()` is defined in repositories on your `build.gradle`.

```groovy
compile 'com.github.sh0nk:matplotlib4j:1.0.0-SNAPSHOT'
```