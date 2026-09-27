package Space.Operations.dto;
//
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
//
public class SatelliteResponse {
	// Private fields
	private Long id;
	private String satelliteCode;
	private String name;
	private Integer noradId;
	private String operator;
    private String orbitType;
    private BigDecimal altitudeKm;
    private BigDecimal inclinationDeg;
    private String status;
    private LocalDate launchDate;
    private Instant createdAt;
    //
    public SatelliteResponse() {} // The first constructor without parameters.
    public SatelliteResponse(Long id, String satelliteCode, String name, Integer noradId, String operator, String orbitType, BigDecimal altitudeKm, BigDecimal inclinationDeg, String status, LocalDate launchDate, Instant createdAt) {  // The second constructor with parameters and initialisation of the fields.
    	this.id = id;
    	this.satelliteCode = satelliteCode;
    	this.name = name;
        this.noradId = noradId;
        this.operator = operator;
        this.orbitType = orbitType;
        this.altitudeKm = altitudeKm;
        this.inclinationDeg = inclinationDeg;
        this.status = status;
        this.launchDate = launchDate;
        this.createdAt = createdAt;
    }
    //
    /*Getters*/
    public Long getId() {
        return id;
    }
    public String getSatelliteCode() {
        return satelliteCode;
    }
    public String getName() {
        return name;
    }
    public Integer getNoradId() {
        return noradId;
    }
    public String getOperator() {
        return operator;
    }
    public String getOrbitType() {
        return orbitType;
    }
    public BigDecimal getAltitudeKm() {
        return altitudeKm;
    }
    public BigDecimal getInclinationDeg() {
        return inclinationDeg;
    }
    public String getStatus() {
        return status;
    }
    public LocalDate getLaunchDate() {
        return launchDate;
    }
    public Instant getCreatedAt() {
        return createdAt;
    }
}
