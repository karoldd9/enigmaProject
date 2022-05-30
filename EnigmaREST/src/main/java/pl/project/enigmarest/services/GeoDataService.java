package pl.project.enigmarest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.enigmarest.entities.GeoData;
import pl.project.enigmarest.repositories.GeoDataRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class GeoDataService {

    @Autowired
    GeoDataRepository geoDataRepository;

    public GeoData saveGeoData(GeoData geoData) {
        return geoDataRepository.save(geoData);
    }

    public void updateGeoData(GeoData geoData) {
        saveGeoData(geoData);
    }

    public List<GeoData> getAllGeoDatas() {
        Iterator<GeoData> iterableGD = geoDataRepository.findAll().iterator();
        List<GeoData> allGeoDatas = new ArrayList<>();

        while (iterableGD.hasNext()) {
            allGeoDatas.add(iterableGD.next());
        }

        return allGeoDatas;
    }

    public GeoData findGeoDataById(Long id) {
        return geoDataRepository.findById(id).get();
    }

    public void deleteGeoDataById(Long id) {
        geoDataRepository.delete(
                geoDataRepository.findById(id).get()
        );
    }

    public void deleteGeoData(GeoData geoData) {
        geoDataRepository.delete(geoData);
    }
}
