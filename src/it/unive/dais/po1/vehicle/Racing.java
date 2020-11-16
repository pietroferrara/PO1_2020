package it.unive.dais.po1.vehicle;

import it.unive.dais.po1.car.Car;
import it.unive.dais.po1.car.Truck;

public class Racing {

    /**
     *
     * @param v1
     * @param v2
     * @param length
     * @return 1 if the winner is the first vehicle, 2 if it is the second vehicle, -1 if an error occurred
     */
    public int race(Vehicle v1, Vehicle v2, double length) {
        try {
            v1.fullBreak();
            v2.fullBreak();
            double distanceV1 = 0, distanceV2 = 0;
            while (true) {
                distanceV1 += v1.getSpeed();
                distanceV2 += v2.getSpeed();
                if (distanceV1 >= length || distanceV2 >= length) {
                    if (distanceV1 > distanceV2) return 1;
                    else return 2;
                }
                v1.accelerate(Math.random() * 10);
                v2.accelerate(Math.random() * 10);

            }
        }
        catch(NegativeSpeedException e) {
            System.err.println("A negative exception happened");
            return -1;
        }
        finally {
            v1.fullBreak();
            v2.fullBreak();
        }
    }

}
