package Space.Operations.repository;
//
import org.springframework.data.jpa.repository.JpaRepository;
import Space.Operations.model.Satellite;

public interface SatelliteRepository extends JpaRepository<Satellite, Long>{
	
}
