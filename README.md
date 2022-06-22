# Escuela Colombiana de Ingeniería Julio Garavito

## Arquitecturas de Software (ARSW)

### :pushpin: Daniel Felipe Hernández Mancipe

<br/>

# :hammer_and_wrench: Picas y famas

[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://powerful-ocean-36245.herokuapp.com/)

El proyecto es una implementación del famoso juego de picas y famas. Las reglas son:

- El usuario ingresará un numero de `n` digitos. `n` es ingresado por el usuario también.

- Una vez ingresado se compara cada digito que el usuario ingreso con otro numero generado aleatoriamente.

- Si el numero esta pero en posicion diferente es pica, pero si el numero esta en la misma posicion es Fama.

- El usuario solamente gana si logra adivinar el numero, es decir si consigue `n` famas.

- Adicionalmente el usuario tiene `2n` intentos, si no lo logra en los `2n`, perdera el juego.

**Nota:** El servidor es **concurrente**.

Se puede notar que el server puede manejar sesiones de juego independientes:

Primero se ingresan valores distintos:

![](../media/1.png?raw=true)

Debido a eso cada un browser tiene 8 intentos y el otro 10:

![](../media/2.png?raw=true)

Cada browser maneja su información independiente:

![](../media/3.png?raw=true)

Ingresando el número aleatorio:

![](../media/4.png?raw=true)

Pantalla final:

![](../media/5.png?raw=true)

## Getting Started

### Prerequisites

- Java >= 11.x
- Maven >= 3.x
- Git >= 2.x
- JUnit 4.x

### Installing

Simplemente clone el repositorio:

```
git clone https://github.com/danielhndz/ARSW-picas-y-famas.git
```

Luego compile el proyecto con maven:

```
mvn compile
```

Si salió bien, debería tener un **BUILD SUCCESS** verde.

### Using

```
mvn exec:java -Dexec.mainClass="edu.escuelaing.arsw.labs.picasyfamas.App"
```

## Built With

- [Maven](https://maven.apache.org/) - Dependency Management
- [Git](https://git-scm.com/) - Version Management
- [JUnit4](https://junit.org/junit4/) - Unit testing framework for Java

## Design Metaphor

- Autor: Daniel Hernández
- Última modificación: 22/06/2022

### Class Diagram

Se sigue el patrón MVC, donde [AppControler](/src/main/java/edu/escuelaing/arsw/labs/picasyfamas/controller/AppController.java) es el controlador de las peticiones HTTP, se crea una instancia de esta clase por cada sesión HTTP que se conecta al servidor, esto garantiza la concurrencia. [Service](/src/main/java/edu/escuelaing/arsw/labs/picasyfamas/service/Service.java) maneja toda la lógica del juego como tal.

![](../media/class_diagram.png?raw=true)

## Authors

- **Daniel Hernández** - _Initial work_ - [danielhndz](https://github.com/danielhndz)

## License

This project is licensed under the GPLv3 License - see the [LICENSE.md](LICENSE.md) file for details

## Javadoc

Para generar Javadocs independientes para el proyecto en la carpeta `/target/site/apidocs` ejecute:

```
mvn javadoc:javadoc
```
