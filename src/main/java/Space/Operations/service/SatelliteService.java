package Space.Operations.service;
//
import java.time.Instant;
import java.util.List;
import java.util.Optional;
//
import org.springframework.stereotype.Service;
//
import Space.Operations.model.Satellite;
import Space.Operations.repository.SatelliteRepository;
import Space.Operations.dto.SatelliteRequest;
import Space.Operations.dto.SatelliteResponse;
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
	public List<SatelliteResponse> getAllSatellites() {
		return satelliteRepository.findAll()
				.stream()
				.map(this::toResponse)
				.toList();
	}
	//
	// Return the satellites based on the Id.
	public Optional<SatelliteResponse> getSatelliteById(Long id){
		return satelliteRepository.findById(id).map(this::toResponse);
	}
	//
	public SatelliteResponse createSatellite(SatelliteRequest request) {
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
        satellite.setCreatedAt(Instant.now());
	    //
        Satellite savedSatellite = satelliteRepository.save(satellite);
	return toResponse(savedSatellite);
	}
	//
	public Optional<SatelliteResponse> updateSatellite(Long id, SatelliteRequest request) {
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
        Satellite updatedSatellite = satelliteRepository.save(satellite);
       return Optional.of(toResponse(updatedSatellite));
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
	//
	// Helper Method.
	private SatelliteResponse toResponse(Satellite satellite) {
		return new SatelliteResponse(
				satellite.getId(),
				satellite.getSatelliteCode(),
				satellite.getName(),
                satellite.getNoradId(),
                satellite.getOperator(),
                satellite.getOrbitType(),
                satellite.getAltitudeKm(),
                satellite.getInclinationDeg(),
                satellite.getStatus(),
                satellite.getLaunchDate(),
                satellite.getCreatedAt()
	  );
	}
}
