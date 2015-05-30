# Maven 

Maven nos permite la construccion de un arquetipo, esto nos es muy util ya que una vez que concebimos una arquitectura
repetitiva optimizaremos con ello la reutilizacion no de codigo, si no de la modularidad de los proyectos.


      mvn archetype:create-from-project -Darchetype.filteredExtensions=java

Nos movemos al directorio donde tenemos nuestra practica1. y ahí con linea de comando corremos:

     mvn archetype:create-from-project -Darchetype.filteredExtensions=java

Luego nos movemos a la carpeta target que tiene la estructura de este arquetipo

    cd target/generated-sources/archetype/

Vamos a editar el pom de esta carpeta, para que no quede "casado" cada proyecto con el nombre de "practica1", así debe quedar:

    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"      xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

      <groupId>com.certificatic.practicas</groupId>
      <artifactId>practica-ejb-archetype</artifactId>
      <version>1.0-SNAPSHOT</version>
      <packaging>maven-archetype</packaging>

      <name>practica-ejb-archetype</name>

      <build>
        <extensions>
          <extension>
            <groupId>org.apache.maven.archetype</groupId>
            <artifactId>archetype-packaging</artifactId>
            <version>2.2</version>
          </extension>
        </extensions>

        <pluginManagement>
          <plugins>
            <plugin>
              <artifactId>maven-archetype-plugin</artifactId>
              <version>2.2</version>
            </plugin>
          </plugins>
        </pluginManagement>
      </build>
    </project>


Luego corremos:
    mvn install

Listo, nos movemos a la carpeta que contiene a la practica1  y creamos nuestra practica2 apartir de este nuevo arquetipo que acabamos de crear:

    mvn archetype:generate -DarchetypeCatalog=local

Nos da las opciones que podemos tomar de nuestro repositorio

    [INFO] No archetype defined. Using maven-archetype-quickstart (org.apache.maven.archetypes:maven-archetype-quickstart:1.0)
    Choose archetype:
    1: local -> com.certificatic.practicas:practica-ejb-archetype (practica1-ejb-archetype)
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): :

Damos en opcion 1:

    Define value for property 'groupId': : com.certificatic.practicas
    Define value for property 'artifactId': : practica2-ejb
    Define value for property 'version':  1.0-SNAPSHOT: :
    Define value for property 'package':  com.certificatic.practica: :com.certificatic.practicas.practica2
    Confirm properties configuration:
    groupId: com.certificatic.practicas
    artifactId: practica2-ejb
    version: 1.0-SNAPSHOT
    package: com.certificatic.practicas.practica2
    Y: :

Esta listo para importarlo y trabajar

![](http://snag.gy/ylCHn.jpg)


###Agregar Testing sources

Vamos a agregar carpetas de recursos a nuestro proyecto de tal manera que quede asi:

![](http://snag.gy/QOQ44.jpg)
