package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {

        if (args[0].equals("-interactive")) {
            Simulation s = new Simulation(new HumanPlayer());
            SecureRandom sr = new SecureRandom();
            s.initialize(sr.nextInt(101));
            s.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }

        else if (args[0].equals("-auto")) {
            Simulation s = new Simulation(new ComputerPlayer());
            s.initialize(Long.parseLong(args[1]));
            s.loopUntilPlayerSucceed(1000);
        }
        else
        {
            System.out.println("Please enter one of the following argument when you launch the program : \n");
            System.out.println("1/ -interacive : guess the age of the captain by yourself in limit of attempt given by the computer. \n");
            System.out.println("2/ -auto : enter the age of the captain and let the computer to guess it in the thousand limit of attempt. \n");
        }
    }


}
