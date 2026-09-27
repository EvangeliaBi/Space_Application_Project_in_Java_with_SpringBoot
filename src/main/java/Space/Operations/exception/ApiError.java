package Space.Operations.exception;
//
import java.time.Instant;
//
public class ApiError {
	// Private Fields.
	private Instant timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
	//
	// The first constructor without parameters.
	public ApiError() {}
	//
	// The second constructor with parameters and initialization of the private fields.
	public ApiError(Instant timestamp, int status, String error, String message, String path) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	// Getters
	public Instant getTimestamp() {
		return timestamp;
	}
	public int getStatus() {
		return status;
	}
	public String getError() {
		return error;
	}
	public String getMessage() {
		return message;
	}
	public String getPath() {
		return path;
	}	
}
