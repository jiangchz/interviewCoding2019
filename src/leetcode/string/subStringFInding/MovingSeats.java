package leetcode.string.subStringFInding;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.List;

public class MovingSeats {
    public static int minMoves(String source) {
        int totalSeats = source.length();
        char[] chars = source.toCharArray();
        int minMove = 0;
        //find all the used seats
        List<Integer> usedSeats = new ArrayList<>();
        for (int i = 0; i < totalSeats; i++) {
            if (chars[i] == 'x') {
                usedSeats.add(i);
            }
        }

        private boolean isDungeonSolvable(final Room startingRoom) {

            Queue<Room> roomToVisit = new LinkedList<>();

            roomToVisit.add(startingRoom);

            while(!roomToVisit.isEmpty()) {
                Room currentRoom = queue.poll();

                if (currentRoom.hasTreasure()) {
                    return true;
                }

                if (Door door : currentRoom.getDoors()) {
                    for (Room connectedRoom : door.getRooms) {
                        if (connectedRoom == currentRoom) {
                            continue;
                        }
                        roomToVisit.add(connectedRoom);
                    }
                }

            }

            return false;
        }

        if (usedSeats.size() <= 1) {
            return 0;
        }

        int median = usedSeats.size() / 2;
        int medianPosition = usedSeats.get(median);
        int offset = 1;
        int move = 0;
        for (int i = 0; i < median; i++) {
            int currentMove = medianPosition - usedSeats.get(i) - offset;
            move += currentMove;
            offset++;
        }

        offset = 1;
        for(int i = median + 1; i < usedSeats.size(); i++) {
            int currentMove =  usedSeats.get(i) - medianPosition - offset;
            move += currentMove;
            offset++;
        }

        return move;

    }

    //ref: https://leetcode.com/discuss/interview-question/algorithms/125002/minimum-number-of-jumps











    /*
    There is a row of seats. Assume that it contains N
    seats adjacent to each other. There is a group of people
    who are already seated in that row randomly. i.e.
     some are sitting together & some are scattered.
    An occupied seat is marked with a character 'x'
     and an unoccupied seat is marked with a dot ('.')

    Now your target is to make the whole group sit together i.e. next to each other, without having any vacant
    seat between them in such a way that the total number of hops or jumps to move them should be minimum.

Example

Here is the row having 15 seats represented by the String (0, 1, 2, 3, ......... , 14) -

          . . . . x . . x x . . . x . .
     */
}
