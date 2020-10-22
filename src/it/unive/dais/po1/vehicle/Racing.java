package it.unive.dais.po1.vehicle;

public class Racing {

    static public int race(Vehicle v1, Vehicle v2, double length) {
;

        v1.fullBreak();
        v2.fullBreak();
        double distanceV1 = 0, distanceV2=0;
        while(true) {
            distanceV1 += v1.getSpeed();
            distanceV2 += v2.getSpeed();
            if(distanceV1 >= length || distanceV2 >= length) {
                if(distanceV1 > distanceV2) return 1;
                else return 2;
            }
            v1.accelerate(Math.random()*10);
            v2.accelerate(Math.random()*10);
        }
    }

}
