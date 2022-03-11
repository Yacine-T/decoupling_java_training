package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long answer = this.player.askNextGuess();
        if(answer > this.numberToGuess)
        {
            this.player.respond(false);
            return false;
        }
        if (answer < this.numberToGuess)
        {
            this.player.respond(true);
            return false;
        }
        logger.log("found !!");
        return true;
    }

    public void loopUntilPlayerSucceed(long maxIteration) {
        int i = 0;
        while (!this.nextRound()){
            if (i == maxIteration)
            {
                logger.log("Sorry, you've reached the maximum number of attempt without finding the right answer.");
                return;
            }
            i++;
        }
        Date d = new Date(System.currentTimeMillis());
        DateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
        System.out.println("Time taken : " + sdf.format(d));
    }
}
