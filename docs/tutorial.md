# Tutorial

This page is based on [Matplotlib: plotting](http://www.turbare.net/transl/scipy-lecture-notes/intro/matplotlib/matplotlib.html)
page in [scipy lecture notes](http://www.turbare.net/transl/scipy-lecture-notes/) 

Matplotlib page on scipy lecture notes shows step by step codes by python Matplotlib.
This page cites them, and add how to write in Matplotlib4j in **Java, Scala and Kotlin** for your understanding of Matplotlib4j.

So, let's start!

# Simple Plot

*[Original doc](http://www.turbare.net/transl/scipy-lecture-notes/intro/matplotlib/matplotlib.html#simple-plot)*

> In this section, we want to draw the cosine and sine functions on the same plot. 
> Starting from the default settings, we'll enrich the figure step by step to make it nicer.
> 
> First step is to get the data for the sine and cosine functions:

*Original in python:*
```python
import numpy as np

X = np.linspace(-np.pi, np.pi, 256)
C, S = np.cos(X), np.sin(X)
```

*Java:*
```java
List<Double> x = NumpyUtils.linspace(-Math.PI, Math.PI, 256);
List<Double> C = x.stream().map(xi -> Math.cos(xi)).collect(Collectors.toList());
List<Double> S = x.stream().map(xi -> Math.sin(xi)).collect(Collectors.toList());
```

*Scala*
```scala
import scala.jdk.CollectionConverters._

val x = NumpyUtils.linspace(-Math.PI, Math.PI, 256)
val C = x.asScala.map(xi => Math.cos(xi)).asJava
val S = x.asScala.map(xi => Math.sin(xi)).asJava
```

*Kotlin:*
```kotlin
val x = NumpyUtils.linspace(-Math.PI, Math.PI, 256)
val C = x.stream().map { xi -> Math.cos(xi!!) }.collect(Collectors.toList())
val S = x.stream().map { xi -> Math.sin(xi!!) }.collect(Collectors.toList())
```

> `X` is now a numpy array with 256 values ranging from -π to +π (included). 
> `C` is the cosine (256 values) and S is the sine (256 values).
