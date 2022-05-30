package pl.project.enigmarest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.project.enigmarest.entities.GeoData;

@Repository
public interface GeoDataRepository extends CrudRepository<GeoData, Long> {
}
