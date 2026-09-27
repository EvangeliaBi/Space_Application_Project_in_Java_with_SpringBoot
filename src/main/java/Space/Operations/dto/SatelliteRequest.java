package Space.Operations.dto;
//
import java.math.BigDecimal;
import java.time.LocalDate;
//
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
//
public class SatelliteRequest {
	@NotBlank(message = "Satellite code is required")
	private String satelliteCode;
	//
	@NotBlank(message = "Satellite name is required")
	private String name;
	//
	@Positive(message = "NORAD ID must be positive")
	private Integer noradId;
	//
	private String operator;
	//
	@NotBlank(message = "Orbit type is required")
	@Pattern(regexp = "LEO|MEO|GEO|HEO", message = "Orbit type must be LEO, MEO, GEO, OR HEO")
	//
	private String orbittype;
	//
	@DecimalMin(value = "0.0", inclusive = true, message = "Altitude cannot be negative")
	private BigDecimal altitudeKm;
	
}
