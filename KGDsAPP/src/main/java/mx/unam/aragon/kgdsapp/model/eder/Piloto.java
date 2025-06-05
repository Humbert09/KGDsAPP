package mx.unam.aragon.kgdsapp.model.eder;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "pilots")
public class Piloto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre_piloto", nullable = false, length = 100)
    private String nombre;
    @Column(name = "equipo", nullable = false, length = 50)
    private String equipo;
    @Column(name = "edad", nullable = true)
    private Integer edad;
    @Column(name = "numero", nullable = true)
    private Integer numero;
    @Column(name = "url_foto", nullable = true, insertable = true, columnDefinition = "VARCHAR(350) DEFAULT 'https://png.pngtree.com/png-vector/20230407/ourmid/pngtree-placeholder-line-icon-vector-png-image_6691835.png'")
    private String imagen;

    public Piloto() {
    }

    public Piloto(int id, String nombre, String equipo, Integer edad, Integer numero, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.equipo = equipo;
        this.edad = edad;
        this.numero = numero;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piloto piloto = (Piloto) o;
        return id == piloto.id && Objects.equals(nombre, piloto.nombre) && Objects.equals(equipo, piloto.equipo) && Objects.equals(edad, piloto.edad) && Objects.equals(numero, piloto.numero) && Objects.equals(imagen, piloto.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, equipo, edad, numero, imagen);
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", equipo='" + equipo + '\'' +
                ", edad=" + edad +
                ", numero=" + numero +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
