# Java Graphics Math and Physics Library
> Java Library for Computer Graphics Math/Physics. Math and Physics tools for 2D graphic applications.

I have been developing many games using Unity and other popular game engines. However, I have recently started thinking about creating my own game engine which inspired this project to come into play. JGMP is a math and physics library written in Java for any Java Graphics API Developers including myself to aid in their development.



## Features
- 2D Vectors
- 2D Shapes (2D Circle, 2D Rectangle, 2D Ray)
- 2D Collision Check Helper (collision checking between 2 shapes)
- Float Mathematics Helper
- Kinematics and Dynamics Models
- Universal Gravity Force Model
- Object Velocity Model

## Documentation
`com/boole/math/helpers/` contains many helpful tools and utilities (float management and collision detection) <br>
`com/boole/math/shapes/` contains many shape models with useful utilities. <br>
`com/boole/math/vectors/` contains vector math model with a lot of vector mathematics and linear algebra functions. <br>
`com/boole/physics/` contains many useful 2D kinematics models for 2d game physics.

You can learn more about the library through the [documentation](https://booleancube.github.io/projects/jgmp/main.html) <br>
You can also find a simple wiki page [here](https://github.com/BooleanCube/jgmp/wiki)

## Installation
[![](https://jitpack.io/v/BooleanCube/jgmp.svg)](https://jitpack.io/#BooleanCube/jgmp)

Latest Releases: https://github.com/BooleanCube/jgmp/releases

Replace `VERSION` with the latest release in Jitpack. If you want to use SNAPSHOTS, please follow the instructions on the [Jitpack page](https://jitpack.io/#BooleanCube/jgmp)

### Maven
#### Dependency
```xml
<dependencies>
    <dependency>
        <groupId>com.github.BooleanCube</groupId>
        <artifactId>jgmp</artifactId>
        <version>VERSION</version>
    </dependency>
</dependencies>
```
#### Repository
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

### Gradle
#### Dependency
```gradle
dependencies {
    implementation 'com.github.BooleanCube:jgmp:VERSION'
}
```
#### Repository
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

----

*Created by BooleanCube :]*
