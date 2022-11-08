package msm.ad;

import msm.ad.modelo.Empleado;

import javax.persistence.*;
import java.sql.SQLOutput;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creamos los EntityManagerFactory para manejar las entidades y transacciones
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {

            // Select
            System.out.println("Select al vuelo");
            Query queryTodosEmpleados = entityManager.createQuery("select e from Empleado as e");
            List<Empleado> listaEmpleados = queryTodosEmpleados.getResultList();
            listaEmpleados.forEach(System.out::println);

            System.out.println("Inserciones de un objeto en BBDD");

            // Insert
//        Empleado empleadotmp = Empleado.builder().dni("18445968J").nombre("Victor").apellidos("Fuertes").build();
//        transaction.begin();
//        entityManager.persist(empleadotmp);
//        transaction.commit();

            // Update
            System.out.println("Actualizamos el usuario 2");
            Empleado update = entityManager.find(Empleado.class, 2);
            update.setNombre("Donald");
            update.setApellidos("Pato");
            update.setDni("1845684999J");
            transaction.begin();
            entityManager.merge(update);
            transaction.commit();
            System.out.println("Hemos realizado el update");

            // Delete
            System.out.println("Eliminamos el Empleado 2");
            transaction.begin();
            entityManager.remove(update);
            transaction.commit();
            System.out.println("Hemos borrado " + update);
        } finally {
            if (transaction.isActive()) {
                System.out.println("Rollback");
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
