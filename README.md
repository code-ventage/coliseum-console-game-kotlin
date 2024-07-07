# Juego de consola Coliseo

Este es un juego de consola que hicimos para nuestro proyecto universitario de **"Lenguajes de programación"**.

## Resumen

Este juego es un juego de consola sencillo que puedes jugar solo.

Primero necesitarás crear tu propio luchador y luego podrás luchar contra otros guerreros generados aleatoriamente.

Hay tres tipos de luchadores:
1. **guerrero**
2. **mago**
3. **ladrón**

Para ganar el juego, deberás derrotar al Jefe Final.

## Como jugar

Para jugar debe ejecutar en consola el siguiente comando:

```shell
java jar "\direccion al jar\coliseum.jar"
```

### 1- Crear un luchador

Se le pedira que proporcione un nombre para su luchador:

```shell
Hello, so you want to fight?
First, you need to pick a fighter.
Enter the name of the fighter you want to fight.
For example, if you want to fight the fighter named 'Pepe', you would enter 'Pepe'.
```

### 2- Posteriormente se le pedirá que elija un tipo de luchador:

```shell
Now, you need to pick a fighter.
We have the following fighters:
1. The Warrior
2. The Mage
3. The Thief
```
### 3- Luego, se le mostrara su luchador y comenzara el juego.

```shell
Name: Victor 
HP: ██████████████████ :: 189
DMG: 10
 ^^^^^
( - - )
/ | \\
| |  |
 _|_  
|   | 


Now, you are ready to fight.
								Name: Star Lord 
 								HP: █████████████ :: 138

                								 DMG: 18
                								  _____
                								 ( ~ ~ )
                								 // || \\
                								 || ||  ||
                								   _||_  
                								  ||  || 

Name: Victor 
HP: ██████████████████ :: 189
DMG: 10
 ^^^^^
( - - )
/ | \\
| |  |
 _|_  
|   | 

Now it's your turn.
Select a number between 1 and 10.
```
### 4- Para jugar debe entrar un número del 1 al 10, si este está entre el rango establecido, usted acertará un golpe.

```shell
You attack Star Lord.

Random Generated Number: 9

The Star Lord has attacked you!
								Name: Star Lord 
 								HP: ████████████ :: 128

                								 DMG: 18
                								  _____
                								 ( ~ ~ )
                								 // || \\
                								 || ||  ||
                								   _||_  
                								  ||  || 

Name: Victor 
HP: █████████████████ :: 171
DMG: 10
 ^^^^^
( - - )
/ | \\
| |  |
 _|_  
|   | 
```

### 5- Ya sabes como jugar!!

## Funcionalidades

Usamos Kotlin para crear este juego, por lo que puedes ver el código en las carpetas **`src/main/kotlin/**`**.

En el archivo `src/main/kotlin/services/ColiseumService.kt`, en la función `desapearDeadFighters()`, usamos expresiones lambda para eliminar los
luchadores muertos de la lista. De esta manera, utilizamos programación funcional para mejorar la legibilidad.

## Desarrolladores

- **Víctor Palmero Valdés**

- **Marcos Portales Ramos**

- **José Lázaro Díaz Estive**