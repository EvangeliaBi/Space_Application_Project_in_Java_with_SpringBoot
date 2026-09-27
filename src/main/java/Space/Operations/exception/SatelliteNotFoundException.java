package Space.Operations.exception;

public class SatelliteNotFoundException extends RuntimeException{
	// Constructor
	public SatelliteNotFoundException(Long id) {
		super("Satellite with id " + id + " not found.");
	}
}
