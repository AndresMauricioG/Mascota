import java.util.ArrayList;
import javax.swing.JOptionPane;
 
public class Mascota {
    // Atributos
	int codigo;
    String nombre;
    String especie;
    int edad;
    String edadString;
    
    ArrayList<String> informacionMascota;

    //Constructor sin parametros
    public Mascota() {
    	  nombre = "Firu";
          especie = "Default";
          edad = 0;
          
          informacionMascota = new ArrayList<>();
    }
    
    public void ingresar() {
    	String val;
    	
    	do {
    	nombre = JOptionPane.showInputDialog("Ingrese nombre");
        especie = JOptionPane.showInputDialog("ingrese la especie de " + nombre);
        edad = Integer.parseInt(JOptionPane.showInputDialog("edad de la mascota " + nombre));
        
        informacionMascota.add(nombre);
        informacionMascota.add(especie);
        edadString = Integer.toString(edad);
        informacionMascota.add(edadString);
        
        val = JOptionPane.showInputDialog("¿desea ingresar otra?");
    	}while(val.equalsIgnoreCase("SI"));
    }

    
    // Constructor con parametros
    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }
    
    // MÃ©todo para mostrar informaciÃ³n de la mascota
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad + " años");
    }

    public void mostrarInformacionGeneral(){
    	for (int i = 0; i < informacionMascota.size(); i++) {
    		
    		System.out.println(informacionMascota.get(i));
    	}
        
    }
    
    public void consultaIndividual() {
        if (informacionMascota.isEmpty()) {
            System.out.println("No hay mascotas registradas.");
            return;
        }

        String nombreBuscado = JOptionPane.showInputDialog("Ingrese el nombre de la mascota a consultar");
        boolean encontrada = false;

        for (int i = 0; i < informacionMascota.size(); i += 3) {
            String nombre = informacionMascota.get(i);

            if (nombre.equalsIgnoreCase(nombreBuscado)) {
                String especie = informacionMascota.get(i + 1);
                String edadString = informacionMascota.get(i + 2);
                int edad = Integer.parseInt(edadString);

                Mascota mascotaConsultada = new Mascota(nombre, especie, edad);
                mascotaConsultada.mostrarInformacion();
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("La mascota no se encontró en la lista.");
        }
    	
    }

    
    
    // MÃ©todo para hacer que la mascota realice un sonido
    public void hacerSonido() {
        if (especie.equalsIgnoreCase("perro")) {
            System.out.println("Â¡Guau guau!");
        } else if (especie.equalsIgnoreCase("gato")) {
            System.out.println("Â¡Miau miau!");
        } else {
            System.out.println("La mascota no hace sonidos conocidos.");
        }
    }
}
