package msm.ad.modelo;

import lombok.*;

import javax.persistence.*; // Para la version 5 de hibernate

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
// @Table (name = "NombreTabla")
public class Empleado {


    @Id // Esta anotacion se pone encima de lo que quieres que sea la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esta anotacion hace que el valor de abajo sea autonumerico
    private int id;
    private String nombre;
    private String apellidos;
    private String dni;
}
