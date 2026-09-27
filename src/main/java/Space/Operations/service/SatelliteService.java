package Space.Operations.service;
//
import java.util.List;
import java.util.Optional;
//
import org.springframework.stereotype.Service;
//
import Space.Operations.model.Satellite;
import Space.Operations.repository.SatelliteRepository;
import Space.Operations.dto.SatelliteRequest;
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
	public Satellite createSatellite(SatelliteRequest request) {
		Satellite satellite = new Satellite();
		//
		satellite.setSatelliteCode(request.getSatelliteCode());
		satellite.setName(request.getName());
		satellite.setNoradId(request.getNoradId());
		satellite.setOperator(request.getOperator());
		satellite.setOrbitType(request.getOrbitType());
	    satellite.setAltitudeKm(request.getAltitudeKm());
	    satellite.setInclinationDeg(request.getInclinationDeg());
	    satellite.setStatus(request.getStatus());
	    satellite.setLaunchDate(request.getLaunchDate());
		//
	    satellite.setCreatedAt(java.time.Instant.now());
	    //
	return satelliteRepository.save(satellite);
	}
	//
	public Optional<Satellite> updateSatellite(Long id, SatelliteRequest request) {
		Optional<Satellite> existingSatellite = satelliteRepository.findById(id);
		//
		if (existingSatellite.isEmpty()) {
			return Optional.empty();
		}
		//
		Satellite satellite = existingSatellite.get();
		//
		satellite.setSatelliteCode(request.getSatelliteCode());
        satellite.setName(request.getName());
        satellite.setNoradId(request.getNoradId());
        satellite.setOperator(request.getOperator());
        satellite.setOrbitType(request.getOrbitType());
        satellite.setAltitudeKm(request.getAltitudeKm());
        satellite.setInclinationDeg(request.getInclinationDeg());
        satellite.setStatus(request.getStatus());
        satellite.setLaunchDate(request.getLaunchDate());
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
