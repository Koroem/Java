package org.example;

public class Main {

        public static void main(String[] args) {
            int n = 3;
            Memory memory = new Memory(n);
            Map map = new Map(n);
            Supervisor supervisor = new Supervisor();

            Robot Robo1 = new Robot("Robot1", map, memory, n,false);
            Robot Robo2= new Robot("Robot2", map, memory, n,false);
            Robot Robo3= new Robot("Robot3", map, memory, n,false);
            Robot Robo4= new Robot("Robot4", map, memory, n,false);
            Robot Robo5= new Robot("Robot5", map, memory, n,true);

            supervisor.addRobot(Robo1);
            supervisor.addRobot(Robo2);
            supervisor.addRobot(Robo3);
            supervisor.addRobot(Robo4);
            supervisor.addRobot(Robo5);


            supervisor.start();


        }

}