package mx.unam.aragon.kgdsapp.model.humberto;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="nombre_operador", nullable = false, length = 100)
    private String nombre;
    @Column(name = "organizacion", nullable = false, length = 50)
    private String organizacion;
    @Column(name = "bando", nullable = false, length = 50)
    private String bando;
    @Column(name = "edad", nullable = false)
    private int edad;
    @Column(name = "anios_r6", nullable = false)
    private int aniosEnR6;
    @Column(name = "url_foto", nullable = true, insertable = true, columnDefinition = "VARCHAR(350) DEFAULT 'https://png.pngtree.com/png-vector/20230407/ourmid/pngtree-placeholder-line-icon-vector-png-image_6691835.png'")

    private String pfp;

    public Operador() {
    }

    public Operador(Long id, String nombre, String organizacion, String bando, int edad, int aniosEnR6, String pfp) {
        this.id = id;
        this.nombre = nombre;
        this.organizacion = organizacion;
        this.bando = bando;
        this.edad = edad;
        this.aniosEnR6 = aniosEnR6;
        this.pfp = pfp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getBando() {
        return bando;
    }

    public void setBando(String bando) {
        this.bando = bando;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAniosEnR6() {
        return aniosEnR6;
    }

    public void setAniosEnR6(int aniosEnR6) {
        this.aniosEnR6 = aniosEnR6;
    }

    public String getPfp() {
        return pfp;
    }

    public void setPfp(String pfp) {
        this.pfp = pfp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Operador operador = (Operador) o;
        return edad == operador.edad && aniosEnR6 == operador.aniosEnR6 && Objects.equals(id, operador.id) && Objects.equals(nombre, operador.nombre) && Objects.equals(organizacion, operador.organizacion) && Objects.equals(bando, operador.bando) && Objects.equals(pfp, operador.pfp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, organizacion, bando, edad, aniosEnR6, pfp);
    }

    @Override
    public String toString() {
        return "Operador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", organizacion='" + organizacion + '\'' +
                ", bando='" + bando + '\'' +
                ", edad=" + edad +
                ", aniosEnR6=" + aniosEnR6 +
                ", pfp='" + pfp + '\'' +
                '}';
    }
}
