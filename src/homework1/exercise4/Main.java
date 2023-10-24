package homework1.exercise4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sphere sphere = new Sphere(2, 1, 2, 1);
        System.out.println("Spherical 1 coordinates(" + Arrays.toString(sphere.getXYZ()) + ") and radius " + sphere.getRadius());
        System.out.println("Lateral area: " + sphere.getArea());
        System.out.println("Volume area: " + sphere.getVolume());
        System.out.println();

        Sphere sphere2 = new Sphere(2, 2, 1, 1);
        System.out.println("Spherical 2 coordinates(" + Arrays.toString(sphere2.getXYZ()) + ") and radius " + sphere2.getRadius());
        System.out.println(sphere.getInteract(sphere2));

        Sphere sphere3 = new Sphere(1, 1, 0, 0);
        System.out.println("Spherical 3 coordinates(" + Arrays.toString(sphere3.getXYZ()) + ") and radius " + sphere3.getRadius());
        System.out.println(sphere.getInteract(sphere3));
    }
}
