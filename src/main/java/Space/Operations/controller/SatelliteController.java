package Space.Operations.controller;
//
import java.util.List;
//
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
//
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
//
import jakarta.validation.Valid;
//
import Space.Operations.model.Satellite;
import Space.Operations.service.SatelliteService;
import Space.Operations.dto.SatelliteRequest;
//
// HTTP requests:
@RestController		
@RequestMapping("/api/satellites")
public class SatelliteController {
	private final SatelliteService satelliteService;
	//
	// Constructor
	public SatelliteController(SatelliteService satelliteService) {
		this.satelliteService = satelliteService;
	}
	//
	// Get all the satellites.
	@GetMapping
	public List<Satellite> getAllSatellites() {
		return satelliteService.getSatellites();
	}
	//
	// Get all the satellites based on the Satellite Id.
	@GetMapping("/{id}")
	public ResponseEntity<Satellite> getSatelliteById(@PathVariable Long id) {
		return satelliteService.getSatelliteById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	//
	// Create a Satellite through POST.
	@PostMapping
	public ResponseEntity<Satellite> createSatellite(@Valid @RequestBody SatelliteRequest request){
		Satellite createdSatellite = satelliteService.createSatellite(request);
		//
	return ResponseEntity.status(HttpStatus.CREATED).body(createdSatellite);
	}
	//
	// Update Satellite with PUT Mapping Endpoint.
	@PutMapping("/{id}")
	public ResponseEntity<Satellite> updateSatellite(@PathVariable Long id, @Valid @RequestBody SatelliteRequest request) {
		return satelliteService.updateSatellite(id, request)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	//
	// Delete Satellite with a specific Id with Delete Mapping.
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSatelite(@PathVariable Long id) {
		boolean deleted = satelliteService.deleteSatellite(id);
		//
		if (!deleted) {
			return ResponseEntity.notFound().build(); 
		}
		//
		return ResponseEntity.noContent().build();
	}	
}
