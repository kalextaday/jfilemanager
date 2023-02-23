<div id="top"></div>

![HTML5](https://img.shields.io/badge/-HTML5-000000?style=flat&logo=HTML5)
![Java](https://img.shields.io/badge/-Java-000000?style=flat&logo=Java&logoColor=007396)
![SQL](https://img.shields.io/badge/-SQL-000000?style=flat&logo=MySQL)

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/kalextaday/jfilemanager">
    <img src="resources/logo.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">Kevin Taday ⭐</h3>

  <p align="center">
    Library for file manager !
    <br />
    <a href="https://desarrollo-risknadim.emagic.fin.ec/blog/intern/landing/html/index.html"><strong>Landing »</strong></a>
    <br />
    <br />
    <a href="https://test-risknadim.emagic.fin.ec/prueba-cliente/login">Ver Demo</a>
    ·
    <a href="https://soporte.emagic.fin.ec/admin/">Reportar Bug</a>
    ·
    <a href="https://soporte.emagic.fin.ec/admin/">Solicitar Funcionalidad</a>
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
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">FAQ</a></li>
  </ol>
</details>

---
## About The Project 💼 ️


Sistema de Gestión de Riesgos

<p align="right">(<a href="#top">ir arriba</a>)</p>


## Getting Started ⚡

---

Para iniciar en este proyecto es necesario lo siguiente 

### Prerequisites
- Tener instalado el jdk de java 8 
- Tener instalado un ide para desarrollo en java (<a href="https://netbeans.apache.org/download/nb112/nb112.html">Netbeans</a> o <a href="https://www.jetbrains.com/es-es/idea/download/">IntelliJ Idea</a> o <a href="https://code.visualstudio.com/download">VS Code</a>)
- Tener instalado una herramienta de conexión de base de datos (<a href="https://dbeaver.io/download/">dbeaver</a> o <a href="https://www.jetbrains.com/es-es/datagrip/">Datagrip</a>)

### Installation

1. Clonar el repositorio
~~~
git clone https://gitlab.com/emagic-s.a/risknadim/awm_gestion_riesgos_admin.git
~~~
2. Ubicar el archivo settings.xml para la descarga de dependencias de maven en la carpeta `C:\Users\{usuario}\.m2`
3. Una vez clonado el repositorio descomentar el Ambiente sobre el que se desea trabajar del Archivo __EstadosConfig.java__  por ejemplo:

```java
   // AMBIENTE("DESARROLLO LOCAL - SISTEMA DE GESTIÓN FINANCIERA", "dev", 0),//Activar DESARROLLO - LOCAL
```
```java
   AMBIENTE("DESARROLLO LOCAL - SISTEMA DE GESTIÓN FINANCIERA", "dev", 0),//Activar DESARROLLO - LOCAL
```
4. Compilar con dependencias el proyecto maven `awm_gestion_riesgos_admin` 
~~~
mvn install
~~~

<p align="right">(<a href="#top">ir arriba</a>)</p>

## Roadmap

---
- [x] acm_coredb
- [x] acm_utilidades
- [x] acm_awm_gestion_riesgo_adm
- [x] acm_awm_gestion_riesgo_configuracion
- [x] acm_awm_gestion_riesgo_super
- [x] acm_awm_gestion_riesgo_user

## Contributing

---

Las contribuciones son lo que hace que la comunidad del proyecto sea un lugar increíble para aprender, inspirar y crear. Cualquier contribución que hagas es muy apreciada .


### New features
1. Bifurcar el proyecto desde la rama master
```shell
git checkout master
```
2. Crea tu rama para la nueva funcionalidad con el siguiente formato: __git checkout -b ticket/feature/{id ticket}-{nombre corto acerca del ticket}__.

Ejemplo:
```shell
git checkout -b ticket/feature/RUU-U4J-19O-modulo-providencias
```
3. Confirma tus cambios respondiendo las siguientes preguntas: __que, para, donde__

Ejemplo:
```shell
git commit -m "agregacion de modulo de providencias para deteccion de personas deudoras en Sistema de Lavado de Activos"
```
4. Sube la rama

Ejemplo:
```shell
git push origin ticket/feature/RUU-U4J-19O-modulo-providencias
```

### Fixes
1. Bifurcar el proyecto desde la rama master
```shell
git checkout master
```
2. Crea tu rama para arreglar el problema con el siguiente formato: __git checkout -b ticket/fix/{id ticket}-{nombre corto acerca del ticket}__

Ejemplo:
```shell
git checkout -b ticket/fix/QWE-RTY-19O-reporte-lavado-activos
```
3. Confirma tus cambios respondiendo las siguientes preguntas: __que, donde__

Ejemplo:
```shell
git commit -m "arreglo de reporte de lavado de activos en el modulo de providencias"
```
4. Sube la rama

Ejemplo:
```shell
git push origin ticket/fix/QWE-RTY-19O-reporte-lavado-activos
```

### Upgrade
1. Bifurcar el proyecto desde la rama master
```shell
git checkout master
```
2. Crea tu rama para hacer una mejora con el siguiente formato: __git checkout -b ticket/upgrade/{id ticket}-{nombre corto acerca del ticket}__

Ejemplo:
```shell
git checkout -b ticket/upgrade/ASD-FGH-19O-matriz-riesgo-operativo
```
3. Confirma tus cambios respondiendo las siguientes preguntas: __que, donde__

Ejemplo:
```shell
git commit -m "actualizacion de matrices en modulo de riesgo operativo"
```
4. Sube la rama

Ejemplo:
```shell
git push origin ticket/upgrade/ASD-FGH-19O-matriz-riesgo-operativo
```

### Releases
1. Bifurcar el proyecto desde la rama master
```shell
git checkout master
```
2. Crea tu rama para hacer una mejora con el siguiente formato: __git checkout -b release/{version}__

Ejemplo:
```shell
git checkout -b release/3.2.9
```
3. (Opcional) Si pide confirmacion de cambios, hacerlo con el siguiente formato: "merge con {nombre-rama}"

Ejemplo:
```shell
git commit -m "merge con ticket/upgrade/ASD-FGH-19O-matriz-riesgo-operativo"
```
4. Sube la rama

Ejemplo:
```shell
git push origin release/3.2.9
```
5. Para subir a produccion __(risknadim/coacs)__ hacerlo desde la rama release

### Others

Si tiene una sugerencia que mejoraría esto, bifurque el repositorio y cree una solicitud de extracción. También puede simplemente abrir un problema con la etiqueta "mejora". ¡Gracias de nuevo!

1. Bifurcar el proyecto desde la rama master
```shell
git checkout master
```
2. Crea tu rama para hacer una mejora o corrección sin ticket con el siguiente formato: __git checkout -b mejora/{nombre corto acerca del ticket}__

Ejemplo:
```shell
git checkout -b mejora/corrección-manejo-sesion
```
3. Confirma tus cambios respondiendo las siguientes preguntas: __que, para, donde__

Ejemplo:
```shell
git commit -m "correccion de sesion de usuario para sesiones en el sistema de reporteria"
```
4. Sube la rama

Ejemplo:
```shell
git push origin mejora/corrección-manejo-sesion
```
5. Solicita un pull request

### Contributors

- Luis Ushiña
- Guillermo Herrera
- Kevin Taday
- Galo Pichucho
- Miguel Guaño

## License

---

Todos los derechos reservados - 2022

## FAQ

---

### NOTA IMPORTANTE:

1. Agregar configuración de CI/CD pertinente para cada ambiente, por ejemplo para un ambiente de desarrollo sería:

~~~
variables:
  MAVEN_CLI_OPTS: "--batch-mode --errors --fail-at-end --show-version"

cache:

stages:
  - build

build-job:
  stage: build
  only:
  - risknadim/desarrollo
  tags:
    - desarrollo
  script:
    - mvn install:install-file -Dfile=lib/primefaces-8.0.5.jar -DgroupId=org.primefaces -DartifactId=primefaces -Dversion=8.0.5 -Dpackaging=jar -DgeneratePom=true
    - "mvn package"
    - "sudo rm -rf /opt/tomcat/webapps/desarrollo-superadmin.war"
    - "sudo rm -rf /opt/tomcat/webapps/desarrollo-cliente.war"
    - "sudo rm -rf /opt/tomcat/webapps/desarrollo-administracion.war"
    - "sudo cp /home/gitlab-runner/builds/mX5R2py_/0/risknadim/awm_gestion_riesgos_admin/awm_gestion_riesgo_super/target/awm_gestion_riesgo_super-1.0-SNAPSHOT.war /opt/tomcat/webapps/desarrollo-superadmin.war"
    - "sudo cp /home/gitlab-runner/builds/mX5R2py_/0/risknadim/awm_gestion_riesgos_admin/awm_gestion_riesgo_user/target/awm_gestion_riesgo_user-1.0-SNAPSHOT.war /opt/tomcat/webapps/desarrollo-cliente.war"
    - "sudo cp /home/gitlab-runner/builds/mX5R2py_/0/risknadim/awm_gestion_riesgos_admin/awm_gestion_riesgo_adm/target/awm_gestion_riesgo_adm-1.0-SNAPSHOT.war /opt/tomcat/webapps/desarrollo-administracion.war"
    - "sudo cp /home/gitlab-runner/builds/mX5R2py_/0/risknadim/awm_gestion_riesgos_admin/awm_gestion_riesgo_super/target/awm_gestion_riesgo_super-1.0-SNAPSHOT.war /home/blue14/wars/desarrollo-superadmin.war"
    - "sudo cp /home/gitlab-runner/builds/mX5R2py_/0/risknadim/awm_gestion_riesgos_admin/awm_gestion_riesgo_user/target/awm_gestion_riesgo_user-1.0-SNAPSHOT.war /home/blue14/wars/desarrollo-cliente.war"
    - "sudo cp /home/gitlab-runner/builds/mX5R2py_/0/risknadim/awm_gestion_riesgos_admin/awm_gestion_riesgo_adm/target/awm_gestion_riesgo_adm-1.0-SNAPSHOT.war /home/blue14/wars/desarrollo-administracion.war"
    - "sudo systemctl restart tomcat"
~~~

2. Los cambios en los archivos __.gitlab-ci.yml__ , __EstadosConfig.java__ , __IExcelDepurador__ no deberían ser enviados al repositorio central NUNCA!

---


### Update Gitlab
- Actualización del runner
