package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;


public class GameTest {

    @Test
    void shouldEmptyPlayers() {
        Game players = new Game();

        Collection<Player> actual = players.findAll();
        Collection<Player> expected = List.of();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldRegisterOnePlayer() {
        Player player1 = new Player(1, "Sergey", 1);
        Game players = new Game();

        players.register(player1);

        Collection<Player> actual = players.findAll();
        Collection<Player> expected = List.of(player1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldRegisterManyPlayers() {
        Player player1 = new Player(1, "Sergey", 20);
        Player player2 = new Player(2, "Petr", 15);
        Player player3 = new Player(3, "Oleg", 30);
        Player player4 = new Player(4, "Masha", 10);
        Player player5 = new Player(5, "Katya", 12);
        Player player6 = new Player(6, "Alina", 15);
        Player player7 = new Player(7, "Ivan", 2);
        Game players = new Game();

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);
        players.register(player7);

        Collection<Player> actual = players.findAll();
        Collection<Player> expected = List.of(player1, player2, player3, player4, player5, player6, player7);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldRoundRegisteredPlayers() {
        Player player1 = new Player(1, "Sergey", 20);
        Player player2 = new Player(2, "Petr", 15);
        Player player3 = new Player(3, "Oleg", 30);
        Player player4 = new Player(4, "Masha", 10);
        Player player5 = new Player(5, "Katya", 12);
        Player player6 = new Player(6, "Alina", 15);
        Player player7 = new Player(7, "Ivan", 2);
        Game players = new Game();

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);
        players.register(player7);

        int actual = players.round("Sergey", "Petr");
        int expected = 1;

        Assertions.assertEquals(actual, expected);

        int actual1 = players.round("Ivan", "Oleg");
        int expected1 = 2;

        Assertions.assertEquals(actual1, expected1);

        int actual2 = players.round("Petr", "Alina");
        int expected2 = 0;

        Assertions.assertEquals(actual2, expected2);
    }

    @Test
    void shouldRoundNotRegisteredPlayers() {
        Player player1 = new Player(1, "Sergey", 20);
        Player player2 = new Player(2, "Petr", 15);
        Player player3 = new Player(3, "Oleg", 30);
        Player player4 = new Player(4, "Masha", 10);
        Player player5 = new Player(5, "Katya", 12);
        Player player6 = new Player(6, "Alina", 15);
        Player player7 = new Player(7, "Ivan", 2);
        Game players = new Game();

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);
        players.register(player7);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round("Vasiliy", "Sergey"); // Vasiliy = null, Sergey = 20
        });

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round("Ivan", "Vladimir"); // Ivan = 2, Vladimir = null
        });

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round("Vasiliy", "Vladimir"); // Vasiliy = null, Vladimir = null
        });

    }

}

