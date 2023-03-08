package Compulsory;

class Location{
    String name;
   LocationType type;
    long x;
    long y;
    /* constructor location */
    public Location(String name, LocationType type, int x, int y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "org.example.Location{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    /* getters and setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
}
class Road{
    double length;
   Location startLocation;
   Location endLocation;
    RoadType type;

    int speedLimit;

    /* constructor org.example.Road */

    public Road(Location startLocation, Location endLocation, RoadType type, int speedLimit) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.type = type;
        this.speedLimit = speedLimit;
        /* lungimea va fi distanta dintre start location si end location */
        this.length = calculateLength();
    }

    @Override
    public String toString() {
        return "org.example.Road{" +
                "length=" + length +
                ", startLocation=" + startLocation +
                ", endLocation=" + endLocation +
                ", type=" + type +
                ", speedLimit=" + speedLimit +
                '}';
    }

    /* calculare distanta intre 2 puncte */
    double calculateLength() {
        double x = endLocation.getX() - startLocation.getX();
       double y = endLocation.getY() - startLocation.getY();
        return Math.sqrt(x * x+ y * y);
    }
    /* getters and setters */
    public double getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }
}
