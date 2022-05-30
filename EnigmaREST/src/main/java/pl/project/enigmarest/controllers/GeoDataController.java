package pl.project.enigmarest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.project.enigmarest.entities.GeoData;
import pl.project.enigmarest.services.GeoDataService;

import java.util.List;

@RestController
public class GeoDataController {

    @Autowired
    GeoDataService geoDataService;

    @PostMapping
    public GeoData saveGeoData(@RequestBody GeoData geoData) throws Exception {
        if(geoDataService.isGeoDataWithId(geoData.getDeviceId())) {
            throw new Exception("Database has already created GeoData with id "+geoData.getDeviceId());
        }
        return geoDataService.saveGeoData(geoData);
    }

    @GetMapping("/getll")
    public List<GeoData> getAllGeoDatas() {
        return geoDataService.getAllGeoDatas();
    }

    @GetMapping("/getById-{id}")
    public GeoData getGeoDataById(@PathVariable("id") Long id) throws Exception{
        if(! geoDataService.isGeoDataWithId(id)) {
            throw new Exception("Couldn't find id "+id);
        }
        return geoDataService.findGeoDataById(id);
    }

    @DeleteMapping("/deleteById-{id}")
    public void deleteById(@PathVariable("id") Long id) throws Exception{
        if(! geoDataService.isGeoDataWithId(id)) {
            throw new Exception("Couldn't find id "+id);
        }
        geoDataService.deleteGeoDataById(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody GeoData geoData) throws Exception {
        if(! geoDataService.isGeoDataWithId(geoData.getDeviceId())) {
            throw new Exception("Couldn't find id "+geoData.getDeviceId());
        }
        geoDataService.deleteGeoData(geoData);
    }

    @PutMapping("/update")
    public void update(GeoData geoData) {
        geoDataService.updateGeoData(geoData);
    }
}
