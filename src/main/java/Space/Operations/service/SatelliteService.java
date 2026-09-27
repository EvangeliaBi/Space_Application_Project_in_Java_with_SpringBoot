package Space.Operations.service;
//
import java.util.List;
import java.util.Optional;
//
import org.springframework.stereotype.Service;
//
import Space.Operations.model.Satellite;
import Space.Operations.repository.SatelliteRepository;
//
@Service
public class SatelliteService {
	private final SatelliteRepository satelliteRepository;
	//
	// Constructor
	public SatelliteService(SatelliteRepository satelliteRepository) {
		this.satelliteRepository = satelliteRepository;
	}
	//
	// Return all the satellites.
	public List<Satellite> getSatellites(){
		return satelliteRepository.findAll();
	}
	//
	// Return the satellites based on the Id.
	public Optional<Satellite> getSatelliteById(Long id){
		return satelliteRepository.findById(id);
	}
	//
	public Satellite createSatellite(Satellite satellite) {
		if (satellite.getCreatedAt() == null) {
			satellite.setCreatedAt(java.time.Instant.now());
		}
	return satelliteRepository.save(satellite);
	}
	//
	public Optional<Satellite> updateSatellite(Long id, Satellite updatedSatellite) {
		Optional<Satellite> existingSatellite = satelliteRepository.findById(id);
		//
		if (existingSatellite.isEmpty()) {
			return Optional.empty();
		}
		//
		Satellite satellite = existingSatellite.get();
		//
		satellite.setSatelliteCode(updatedSatellite.getSatelliteCode());
        satellite.setName(updatedSatellite.getName());
        satellite.setNoradId(updatedSatellite.getNoradId());
        satellite.setOperator(updatedSatellite.getOperator());
        satellite.setOrbitType(updatedSatellite.getOrbitType());
        satellite.setAltitudeKm(updatedSatellite.getAltitudeKm());
        satellite.setInclinationDeg(updatedSatellite.getInclinationDeg());
        satellite.setStatus(updatedSatellite.getStatus());
        satellite.setLaunchDate(updatedSatellite.getLaunchDate());
        //
        return Optional.of(satelliteRepository.save(satellite));
	}
	//
	// Delete the satellite with this Specific Id.
	public boolean deleteSatellite(Long id) {
		if(!satelliteRepository.existsById(id)) {
			return false;
		}
	//
	satelliteRepository.deleteById(id);
	return true;
	}	
}
