package dfs;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        dfs(robot, 0, 0, 0, visited); //the start position is seen as the original point. facing up originally
    }

    public void dfs(Robot robot, int x, int y, int curDir, Set<String> visited) {
        visited.add(new String(x +","+ y));
        robot.clean();

        for(int i = 0; i < 4; i++) {
            int nextDir = (curDir + i) % 4; //moving direction, let's say we are facing right (1), nextDir will be 1 as well.
            int nextX = x + dx[nextDir]; //key point, next position depends on next direction!
            int nextY = y + dy[nextDir];
            if(!visited.contains(nextX+","+ nextY) && robot.move()) {
                //robot.move() not only checks wall but also moves
                dfs(robot, nextX, nextY, nextDir, visited);

                //go back to start cell
                robot.turnRight();
                robot.turnRight();
                robot.move();
                //go back to the original direction
                robot.turnRight();
                robot.turnRight();
            }
            //把机器人面向下一个方向！！！
            robot.turnRight();//because we purposely arranged dx, dy to be clockwise. If we are facing right, we will be facing down in the next iteration
        }
    }
    class Robot {
        public boolean move(){
            return true;
        }
        public void turnRight(){

        }
        public void turnLeft(){

        }
        public void clean(){

        }
    }
}
