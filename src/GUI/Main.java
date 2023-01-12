package GUI;

import snakes.Bot;
import snakes.BotLoader;

import java.util.ArrayList;

public class Main {
    private static STATE gameState;

    public static void main(String[] args) {
        gameState = STATE.MENU;
        if (gameState == STATE.MENU) {
            GameMainMenu gameMainMenu = new GameMainMenu();
        }
        else if (gameState == STATE.GAMEMODE) {
            GameMainMenu gameMainMenu = new GameMainMenu();
        }
        else if (gameState == STATE.CHOOSEBOT) {
            ChooseBotMenu chooseBot = new ChooseBotMenu();
        }
        else if (gameState == STATE.AI) {

        }
    }
}
