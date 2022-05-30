package pl.project.enigmarest.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.enigmarest.entities.GeoData;
import pl.project.enigmarest.repositories.GeoDataRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class GeoDataService {

    Logger logger = LoggerFactory.getLogger(GeoDataService.class);

    @Autowired
    GeoDataRepository geoDataRepository;

    public GeoData saveGeoData(GeoData geoData) {
        logger.info("Called saveGeoData() from service");
        return geoDataRepository.save(geoData);
    }

    public void updateGeoData(GeoData geoData) {
        logger.info("Called updateGeoData() from service");
        saveGeoData(geoData);
    }

    public List<GeoData> getAllGeoDatas() {
        logger.info("Called getAllGeoDatas() from service");
        Iterator<GeoData> iterableGD = geoDataRepository.findAll().iterator();
        List<GeoData> allGeoDatas = new ArrayList<>();

        while (iterableGD.hasNext()) {
            allGeoDatas.add(iterableGD.next());
        }

        return allGeoDatas;
    }

    public GeoData findGeoDataById(Long id) {
        logger.info("Called findGeoDataById() from service");
        return geoDataRepository.findById(id).get();
    }

    public void deleteGeoDataById(Long id) {
        logger.info("Called deleteGeoDataById() from service");
        geoDataRepository.delete(
                geoDataRepository.findById(id).get()
        );
    }

    public void deleteGeoData(GeoData geoData) {
        logger.info("Called deleteGeoData() from service");
        geoDataRepository.delete(geoData);
    }

    public boolean isGeoDataWithId(Long id) {
        if(id == null) {
            return false;
        }
        
        Iterator<GeoData> geoDataIterator = geoDataRepository.findAll().iterator();

        while (geoDataIterator.hasNext()) {
            if(id.intValue() == geoDataIterator.next().getDeviceId().intValue()) {
                return true;
            }
        }

        return false;
    }
}
