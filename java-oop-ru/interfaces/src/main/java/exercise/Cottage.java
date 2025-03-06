package exercise;

// BEGIN
public class Cottage implements Home{
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public String toString() {
        return floorCount + " этажный коттедж площадью " + getArea() + " метров";
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        if (another.getArea() > getArea()) {
            return -1;
        } else if (another.getArea() < getArea()) {
            return 1;
        } else {
            return 0;
        }
    }
}
// END
