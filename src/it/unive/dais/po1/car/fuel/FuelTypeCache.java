package it.unive.dais.po1.car.fuel;

import java.util.HashMap;
import java.util.Map;

/**
 * This class caches fuel types. Each fuel type is univocally identified by its name.
 *
 * @author Pietro Ferrara
 * @since 3.0
 */
public class FuelTypeCache {

    /**
     * Internal cache containing all the already instantiated fuel types
     */
    static private Map<String, FuelType> alreadyCreatedFuelTypes = new HashMap<>();

    /**
     * Returns the fuel type with the given name, or null if this does not exist
     *
     * @param name the name of the fuel type
     * @return the fuel type with the given name, or null if this does not exist
     */
    static public FuelType getFuelTypeFromName(String name) {
        return alreadyCreatedFuelTypes.get(name);
    }

    /**
     * Stores in the cache the given fuel type if there is no type with same name yet cached.
     *
     * @param type the type to be cached
     * @return true if the type has been added to the cache, false if there was already a type in the cache with the same name
     */
    static public boolean storeFuelType(FuelType type) {
        if(alreadyCreatedFuelTypes.get(type.getName())!=null)
            return false;
        else {
            alreadyCreatedFuelTypes.put(type.getName(), type);
            return true;
        }
    }
}
