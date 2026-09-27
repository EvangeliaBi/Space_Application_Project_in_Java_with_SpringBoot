package Space.Operations.model;
//
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
//
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//
@Entity
@Table(name = "satellites")

public class Satellite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//
	@Column(name = "satellite_code", nullable = false, unique = true, length = 50)
	private String satelliteCode;
	//
	@Column(nullable = false, length = 100)
	private String name;
	//
	@Column(name = "norad_id", unique = true)
	private Integer noradId;
	//
	@Column(length = 100)
	private String operator;
	//
	@Column(name = "orbit_type", nullable = false, length = 50)
	private String orbit_type;
	//
	@Column(name = "altitude_km", precision = 10, scale = 2)
	private BigDecimal altitudeKm;
	//
	@Column(name = "inclination_deg", precision = 7, scale = 3)
	private BigDecimal inclinationDeg;
	//
	@Column(nullable = false, length = 20)
	private String status;
	//
	@Column(name = "launch_date")
	private LocalDate launchDate;
	//
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;
	//
	public Satellite() {}
	//
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSatelliteCode() {
		return satelliteCode;
	}
	public void setSatelliteCode(String satelliteCode) {
		this.satelliteCode = satelliteCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNoradId() {
		return noradId;
	}
	public void setNoradId(Integer noradId) {
		this.noradId = noradId;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOrbitType() {
		return orbit_type;
	}
	public void setOrbitType(String orbitType) {
		this.orbit_type = orbitType;
	}
	public BigDecimal getAltitudeKm() {
        return altitudeKm;
    }

    public void setAltitudeKm(BigDecimal altitudeKm) {
        this.altitudeKm = altitudeKm;
    }

    public BigDecimal getInclinationDeg() {
        return inclinationDeg;
    }

    public void setInclinationDeg(BigDecimal inclinationDeg) {
        this.inclinationDeg = inclinationDeg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }	
}
