package homework1.exercise4;

public class Sphere {
    private double radius;
    private double x;
    private double y;
    private double z;

    public Sphere(double radius, double x, double y, double z) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getRadius() {
        return radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double[] getXYZ() {
        return new double[]{x,y,z};
    }

    public double getArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public double getVolume() {
        return (4 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public String getInteract(Sphere that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        double dz = this.z - that.z;

        double distanceSquared = dx * dx + dy * dy + dz * dz;
        double sumRadiusSquared = (this.radius + that.radius) * (this.radius + that.radius);

        if (distanceSquared > sumRadiusSquared)
            return "The 2 spheres do not touch each other";
        else if (distanceSquared == sumRadiusSquared)
            return "The 2 spheres are in external contact";
        else if (distanceSquared < Math.pow(Math.max(this.radius, that.radius), 2))
            if (this.radius > that.radius)
                return "Sphere 1 includes sphere 2";
            else
                return "Sphere 2 includes sphere 1";
        else
            return "The 2 spheres are in Internal exposure";
    }

}
