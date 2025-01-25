# Mario_bros_java

## Description

"Mario Game: The Adventure Begins" is a platformer game where the player controls Mario as he navigates various levels, avoids enemies, collects coins, and aims to finish the game with as many victories as possible. The game is structured using the Model-View-Controller (MVC) design pattern, with dynamic data structures, a focus on object-oriented principles, and an intuitive graphical user interface. It closely follows the structure and mechanics of the original "Mario Bros" game while adding unique elements to enhance the experience.

## Features

- **Interactive Menu**: Upon running the game, the player has a window displaying the game title and two buttons: "Start Game" and "Exit." Clicking "Start Game" launches the game, while "Exit" closes the program.

- **Player Controls**:  
  - **Right Arrow Key**: Move Mario right.  
  - **Left Arrow Key**: Move Mario left.  
  - **Spacebar**: Make Mario jump.  

- **Game Mechanics**:  
  - **Mario**: Mario has two states — walking and dead. Mario dies when touching a Goomba.  
  - **Goomba**: The enemy also has two states — alive (when Mario hasn't jumped on it) and squashed (when Mario jumps on it).  
  - **Coins**: When Mario touches a coin, it disappears, and the coin counter increments.

- **Counters**:  
  - **Coins Collected**: Displays the total coins Mario has collected.  
  - **Total Games Played**: Tracks how many games have been played.  
  - **Games Won**: Tracks the number of games Mario has won.

- **Victory Screen**: At the end of the game, a victory screen appears, notifying the player of their success. Closing the victory screen will return the player to the main menu.

- **MVC Architecture**:  
  - **Model**: Includes the "ElementoJuego," "Nodo," and "ListaEnlazada" classes for handling dynamic game data.  
  - **View**: Handles game display elements like menus, characters, and objects. Includes classes like "Enemigo," "Imagenes," "Juego," and "VistaJuego."  
  - **Controller**: Manages game logic, including searching and sorting algorithms through the "Buscador," "ContadorRecursivo," and "Ordenador" classes.

- **Data Structures**: The game uses linked lists to manage dynamic data such as enemies and coins, avoiding static arrays or collections like ArrayList.

- **Object-Oriented Design**:  
  - **Encapsulation**: Data is encapsulated within classes, and methods allow interaction with the data.  
  - **Inheritance**: The "ElementoJuego" interface is implemented by classes like "Jugador" (Player), "Enemigo" (Enemy), and "Moneda" (Coin).

- **Algorithms**:  
  - **Sorting**: The game implements a bubble sort algorithm in the "Ordenador" class to quickly order items.  
  - **Searching**: A sequential search is used to locate game elements by their coordinates.  
  - **Recursion**: The "ContadorRecursivo" class uses recursion to count elements in the linked list.

- **Interface**: The game offers an attractive graphical interface with buttons, counters, and information such as coins and games played.

## Installation

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/aurorabogantes/Mario_bros_java.git
2. Install necessary dependencies (e.g., Java Development Kit (JDK)).
3. Compile and run the program:
   ```bash
   javac Main.java
   java Main

## Usage

- After launching the game, you will be presented with the main menu.
- Click "Start Game" to begin, or "Exit" to close the game.
- Use the arrow keys to move Mario and the spacebar to make him jump.
- Enjoy the game and track your progress with the in-game counters.
- At the end of the game, the victory screen will appear, and you can return to the main menu after closing it.

## Contributing

Feel free to fork the repository, make improvements, and submit pull requests. If you encounter any bugs or have suggestions for new features, please open an issue.

##License

This project is licensed under MIT License - see the LICENSE file for details.

##Acknowledgements

- Special thanks to the developers of "Mario Bros" for inspiring this project.
- Thanks to Java Swing and AWT for providing the tools for creating the graphical interface.
