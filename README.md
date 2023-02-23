<div id="top"></div>

![Java](https://img.shields.io/badge/-Java-000000?style=flat&logo=Java&logoColor=007396)
![Java](https://img.shields.io/badge/version-0.0.1-blue)
![Java](https://img.shields.io/badge/tests-100%25-green)
![Java](https://img.shields.io/badge/build-pasing-brightgreen)
![Java](https://img.shields.io/badge/release%20date-feb%202023-orange)


<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/kalextaday/jfilemanager">
    <img src="resources/logo.png" alt="Logo" width="" height="250">
  </a>

<h3 align="center">Kevin Taday ⭐</h3>

  <p align="center">
    Library for file manager !
    <br />
    <a href="#"><strong>Landing »</strong></a>
    <br />
    <br />
    <a href="#">Ver Demo</a>
    ·
    <a href="#">Reportar Bug</a>
  </p>
</div>


<!-- TABLE OF CONTENTS -->
<details>
  <summary>TABLE OF CONTENTS</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
    </li>
    <li>
      <a href="#implementation-in-your-project">Implementation in your project</a>
      <ul>
        <li><a href="#dependencies">Dependencies</a></li>
        <li><a href="#implementation-in-code">Implementation in code</a></li>
      </ul>
    </li>
    <li>
      <a href="#contributing">Contributing</a>
      <ul>
        <li><a href="#prerequisites">Contributors</a></li>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#license">License</a></li>
    <li><a href="#changelog">ChangeLog</a></li>
    <li><a href="#contact">FAQ</a></li>
  </ol>
</details>

---
## About The Project 💼 ️


Library for file manager

<p align="right">(<a href="#top">ir arriba</a>)</p>


## Getting Started ⚡

---
For init in this project you need to install the next tools:

## Implementation in your project

---

### Dependencies
- In maven
~~~xml
<dependency>
  <groupId>io.github.kalextaday</groupId>
  <artifactId>jfilemanager</artifactId>
  <version>0.0.1</version>
  <type>pom</type>
</dependency>
~~~

- In Gradle Grovy
~~~groovy
implementation 'io.github.kalextaday:jfilemanager:0.0.1'
~~~

- In Gradle Kotlin
~~~kotlin
implementation (io.github.kalextaday:jfilemanager:0.0.1)
~~~

### Implementation in code
- In Spring Boot
~~~java
@Configuration
public class YourClassConfig {

    @Bean
    public ManageFiles manageFiles() {
        return new ManageFiles();
    }
}
~~~

- In Java without any framework
~~~java
public class YourClassConfig {
    
  public VoDirectory yourNameMethod() {
    ManageFiles manageFiles = new ManageFiles();
    VoDirectory voDirectory = manageFiles.getContentDirectory("F:\\DOCUMENTOS/CV");
    // Your Business logic
    return voDirectory;
  }
}
~~~

## Contributing

---

Contributions are what make the project community such an amazing place to learn, inspire, and create. Any contribution you make is greatly appreciated.

### Contributors

- Kevin Taday

### Prerequisites
- Install jdk version 8
- Install IDE for development in java (<a href="https://netbeans.apache.org/download/nb112/nb112.html">Netbeans</a> o <a href="https://www.jetbrains.com/es-es/idea/download/">IntelliJ Idea</a> o <a href="https://code.visualstudio.com/download">VS Code</a>), preference INTELLIJ IDEA community version or ultimate

### Installation

1. Clone repository
~~~
git clone https://github.com/kalextaday/jfilemanager.git
~~~
2. Compile with dependencies
~~~
./gradlew build
~~~

<p align="right">(<a href="#top">ir arriba</a>)</p>

## License

---

GNU GENERAL PUBLIC LICENSE


## ChangeLog

---
- 0.0.1
  - First version in maven central


## FAQ

---

