# Battleship Java
This java program is a 1-player Battleship game. It is played on a 10x10 grid representing the ocean and containing ships. Each cell in the grid is identified by a letter representing a column and a number representing a row. Ships are comprised of a sequence of contiguous cells, either all in the same row or all in the same column. There are five ships having different lengths.

- Carrier, length 5
- Battleship, length 4
- Cruiser, length 3
- Submarine, length 3
- Destroyer, length 2

The ships are placed in random locations. Two ships cannot contain the same cell.

>The picture below gives one possible setup of the game board (taken directly from Dr. Foust's [project description](https://cs.harding.edu/gfoust/classes/comp3450/project05.html)).

<img width="500" alt="Screen Shot 2022-06-09 at 11 17 11 PM" src="https://user-images.githubusercontent.com/83131937/172995332-9364079e-0528-49c6-8c71-434f82db2cd2.png">

When the game begins, the player does not know where the ships are on the board. The player may “shoot” in different cells in an attempt to hit one of the ships. Cells of the gameboard are identified by their column letter and row number—e.g., “B9” or “H4”. After each shot, the game responds by reporting which ship was hit by the shot, or that no ship was hit by the shot. If a ship has been hit in all of its cells, it sinks. You must sink all the ships to win the game.

## Demo
![battleship-java-demo](https://user-images.githubusercontent.com/83131937/172994940-3c7fb8b0-e766-43b2-8cc2-bee6572c6617.gif)

## The Program
This is a console application with no UI (no prompts, etc.). The application will be defined simply in terms of the input and output.

### Input
The input to the program will begin with five groups of three letters. These five groups represent the positions of the five ships in this order: carrier, battleship, cruiser, submarine, and destroyer. The first character will be a column letter; the second character will be a row number; and the third character will be either the letter H or the letter V representing either Horizontal or Vertically, respectively. The first two characters define the upper-left corner of the ship, and the third character defines whether the ship proceeds to the right (for H) or down (for V). The input that defines the board in the picture above would be the following.

>F7H B1V D6V F3H I3V

You do not need to perform any input validation; you may assume that the input is in the correct format and describes valid positions for the ships.

Following these five groups of three characters, there will come zero or more groups of two characters representing shots. Each two characters will be either the column letter and row number of a cell, or else “Q0” indicating that the user quits. You may assume that the input is in the correct format and either describes valid cells or is the signal to quit.

Because the cells will always be represented as a single word, you can use the java.util.Scanner.next() method to read in the user's guesses. Use the java.lang.String.charAt() method to access the individual characters.

You do not need to perform any data validation for this project; you may assume all guesses are valid. However, you should allow the letter for the column to be either upper- or lowercase. The java.lang.Character class has a static method named toLowerCase that should help with that.

### Output
The output for your program may be described by the following pattern, where BN is a representation of the gameboard after N shots have been fired, and SN is a description of shot N. When the game finishes (because the player either won or quit) there will be a description M of the result of the game.

Each gameboard representation should match the following pattern, where each letter C is replaced with either X, O, or a period (.). The letter X means the player has shot there and it was a hit. The letter Y means the player has shot there and it was a miss. The period means the player has not yet shot there.

>  ABCDEFGHIJ  
0 CCCCCCCCCC  
1 CCCCCCCCCC  
2 CCCCCCCCCC  
3 CCCCCCCCCC  
4 CCCCCCCCCC  
5 CCCCCCCCCC  
6 CCCCCCCCCC  
7 CCCCCCCCCC  
8 CCCCCCCCCC  
9 CCCCCCCCCC  

A shot description always begins with the column letter and row number of the shot, followed by a colon, followed by a description of the result. If the shot was a miss, you should just output the word "Miss". For example, if a shot at column J row 5 was a miss, the output would look like the following.

>J5: Miss

If the show was a hit, you should output the word "Hit" followed by the name of the ship that was hit. For example, if a shot at column J row 5 hit the Carrier, the output would look like the following.

>J5: Hit Carrier

If the ship that was hit has been sunk you should output "You sank my" and the name of the ship. For example, if a shot at column J row 5 hit the Carrier, and the Carrier was sunk, the output would look like the following.

>J5: Hit Carrier  
You sank my Carrier

Note that your output should match mine exactly. You should output columns using capital letters regardless of what case they were entered by the user.

There is no reason for a player to shoot in a cell where he has shot previously. However, should that occur, your output should be the same. If there is no ship there, output "Miss". If there is a ship there, output "Hit" and the name of the ship; additionally, if the ship is sunk, output "You sank my" and the name of the ship even _if this was not the shot that sunk it_.

### Game Over
The game should end when all ships are sunk. Your program should print the message "You won in N turns", where N is the number of shots it took to sink all ships. Note that you will print the final gameboard before this message (showing that all ships have been sunk).

Additionally, the player may enter a shot of "Q0" to indicate a forfeit. In this case the game should end immediately and the player loses. The program should print the message "You lost".
