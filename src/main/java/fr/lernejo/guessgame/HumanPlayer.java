package fr.lernejo.guessgame;

import fr.lernejo.logger.ConsoleLogger;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {

    Logger log = LoggerFactory.getLogger("player");
    Scanner sc = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        System.out.println("Enter a number please :");
        long answer = sc.nextLong();
        return answer;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (!lowerOrGreater)
        {
            log.log("Too high ! Try again, please.");
        }
        else
        {
            log.log("Two low ! Try again, please.");
        }

    }
}
