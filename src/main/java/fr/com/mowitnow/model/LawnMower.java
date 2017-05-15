package fr.com.mowitnow.model;


import java.util.List;

/**
 * Created by ruhan.silva on 15/05/2017.
 */
public class LawnMower implements Mower {

    private final int MAX_COLUMN;
    private final int MAX_LINE;
    private final int MIN_LINE_COLUMN = 0;

    private int currentLine;
    private int currentColumn;
    private Orientation sense;
    private final char AVANCE = 'A';
    private final char DROITE = 'D';
    private final char GAUCHE = 'G';


    private List<String> commands;


    public LawnMower(String[] dimension, List commands) {
        MAX_LINE = Integer.valueOf(dimension[0]);
        MAX_COLUMN = Integer.valueOf(dimension[1]);
        this.commands = commands;
    }

    public void run() {

        while (!commands.isEmpty()) {

            String startingPoint = commands.get(0);
            String mowerCoordinates[] = startingPoint.split(" ");
            commands.remove(startingPoint);

            char[] instructions = commands.get(0).toCharArray();
            commands.remove(0);


            currentLine = Integer.valueOf(mowerCoordinates[0]);
            currentColumn = Integer.valueOf(mowerCoordinates[1]);
            sense = Orientation.findByName("" + mowerCoordinates[2]);

            for (char i : instructions)
                switch (i) {
                    case AVANCE:
                        move();
                        break;

                    case DROITE:
                        turnRight();
                        break;

                    case GAUCHE:
                        turnLeft();
                        break;
                    default:
                        System.out.println(" \n Bad instruction: " + i);
                        break;


                }
            System.out.println(this.toString());
        }


    }

    public void turnLeft() {
        sense = sense.turnTo(Orientation.LEFT);
    }

    public void turnRight() {
        sense = sense.turnTo(Orientation.RIGHT);
    }

    public void move() {

        switch (sense) {
            case N:
                if (isNorthAndEastPositionValid(currentColumn))
                    currentColumn++;

                break;


            case E:

                if (isNorthAndEastPositionValid(currentLine))
                    currentLine++;

                break;

            case W:

                if (isWestAndSouthPositionValid(currentLine))
                    currentLine--;

                break;

            case S:

                if (isWestAndSouthPositionValid(currentColumn))
                    currentColumn--;

                break;


        }

    }


    private boolean isNorthAndEastPositionValid(int index) {
        return index + 1 <= this.MAX_COLUMN;


    }

    private boolean isWestAndSouthPositionValid(int index) {

        return index - 1 >= this.MIN_LINE_COLUMN;


    }

    public String toString() {
        return this.currentLine + "," + this.currentColumn + " " + sense;
    }

}
