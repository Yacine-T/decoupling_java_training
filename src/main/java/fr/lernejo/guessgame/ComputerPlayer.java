package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class ComputerPlayer implements Player {

    Logger log = LoggerFactory.getLogger("player");
    Scanner sc = new Scanner(System.in);
    long inf = Long.MIN_VALUE;
    long sup = Long.MAX_VALUE;

    @Override
    public long askNextGuess() {
        long answer = (this.inf + this.sup)/2;
        return answer;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (!lowerOrGreater)
        {
            log.log("smaller !");
            this.sup = (this.inf + this.sup)/2;
        }
        else
        {
            log.log("bigger");
            this.inf = (this.inf + this.sup)/2;
        }
    }
}
