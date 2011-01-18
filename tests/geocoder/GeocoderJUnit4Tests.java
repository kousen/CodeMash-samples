package geocoder;

import static junit.framework.Assert.*;
import geocoder.Geocoder;
import geocoder.Location;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

public class GeocoderJUnit4Tests {
    @Test
    public void testLatLngJSR223() {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("groovy");
        engine.put("street", "1600 Pennsylvania Avenue");
        engine.put("city","Washington");
        engine.put("state", "DC");
        try {
            engine.eval(new FileReader("src/geocoder/geocode.groovy"));
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(38.898,
            Double.parseDouble((String) engine.get("lat")),0.001);
        assertEquals(-77.037,
            Double.parseDouble((String) engine.get("lng")),0.001);
    }
    
    @Test
    public void testGeocoder() {
        Location loc = new Location();
        loc.setState("1600 Pennsylvania Avenue");
        loc.setCity("Washington");
        loc.setState("DC");
        Geocoder geocoder = new Geocoder();
        geocoder.fillInLatLong(loc);
        assertEquals(38.895,loc.getLatitude(),0.001);
        assertEquals(-77.037,loc.getLongitude(),0.001);
    }
}
