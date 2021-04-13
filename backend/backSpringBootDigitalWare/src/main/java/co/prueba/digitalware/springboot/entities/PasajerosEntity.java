package co.prueba.digitalware.springboot.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pasajeros", schema = "public", catalog = "pruebadw")
public class PasajerosEntity {
    private Long id;
    private Short tipdocumento;
    private Long identificacion;
    private String pnombre;
    private String snombre;
    private String papellido;
    private String sapellido;
    private String email;
    private Long ncelular;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tipdocumento", nullable = false)
    public Short getTipdocumento() {
        return tipdocumento;
    }

    public void setTipdocumento(Short tipdocumento) {
        this.tipdocumento = tipdocumento;
    }

    @Basic
    @Column(name = "identificacion", nullable = false)
    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    @Basic
    @Column(name = "pnombre", nullable = false, length = 80)
    public String getPnombre() {
        return pnombre;
    }

    public void setPnombre(String pnombre) {
        this.pnombre = pnombre;
    }

    @Basic
    @Column(name = "snombre", nullable = true, length = 80)
    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }

    @Basic
    @Column(name = "papellido", nullable = false, length = 80)
    public String getPapellido() {
        return papellido;
    }

    public void setPapellido(String papellido) {
        this.papellido = papellido;
    }

    @Basic
    @Column(name = "sapellido", nullable = true, length = 80)
    public String getSapellido() {
        return sapellido;
    }

    public void setSapellido(String sapellido) {
        this.sapellido = sapellido;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 200)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "ncelular", nullable = true)
    public Long getNcelular() {
        return ncelular;
    }

    public void setNcelular(Long ncelular) {
        this.ncelular = ncelular;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasajerosEntity that = (PasajerosEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(tipdocumento, that.tipdocumento) && Objects.equals(identificacion, that.identificacion) && Objects.equals(pnombre, that.pnombre) && Objects.equals(snombre, that.snombre) && Objects.equals(papellido, that.papellido) && Objects.equals(sapellido, that.sapellido) && Objects.equals(email, that.email) && Objects.equals(ncelular, that.ncelular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipdocumento, identificacion, pnombre, snombre, papellido, sapellido, email, ncelular);
    }
}
