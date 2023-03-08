package Compulsory;

public class Main {
    // public Location(String name, LocationType type, int x, int y)
    // public Road(Location startLocation, Location endLocation, RoadType type, int speedLimit)
    public static void main(String[] args) {
        Location l1 = new Location("Paris", LocationType.CITY, 0, 0);
        Location l2 = new Location("Amsterdam", LocationType.CITY, 20, 25);
        Location l3 = new Location("Otopeni", LocationType.AIRPORT, 35, 40);
        Location l4 = new Location("OMW", LocationType.GAS_STATION, 235, 450);

        Road r1 = new Road(l1, l2, RoadType.HIGHWAY, 300);
        Road r2 = new Road(l1, l3, RoadType.EXPRESS, 100);
        Road r3 = new Road(l1, l4, RoadType.EXPRESS, 250);
        Road r4 = new Road(l2, l3, RoadType.COUNTRY, 175);
        Road r5 = new Road(l2, l4, RoadType.COUNTRY, 80);

        System.out.print(l1.toString());
        System.out.print(l2.toString());
        System.out.print(l3.toString());
        System.out.print(l4.toString());
        System.out.print(r1.toString());
        System.out.print(r2.toString());
        System.out.print(r3.toString());
        System.out.print(r4.toString());
        System.out.print(r5.toString());
    }
}