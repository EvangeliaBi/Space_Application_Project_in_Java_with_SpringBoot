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
	private String orbitType;
	//
	@DecimalMin(value = "0.0", inclusive = true, message = "Altitude cannot be negative")
	private BigDecimal altitudeKm;
	//
	@DecimalMin(value = "0.0", inclusive = true, message = "Inclination cannot be negative")
	@DecimalMax(value = "180.0", message = "Inclination cannot be greater than 180 degrees")
	private BigDecimal inclinationDeg;
	//
	@NotBlank(message = "Status is required")
    @Pattern(regexp = "ACTIVE|INACTIVE|DECOMMISSIONED", message = "Status must be ACTIVE, INACTIVE or DECOMMISSIONED")
	private String status;
}
