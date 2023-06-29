package com.curso.servicios.impl;

import com.curso.dtos.DatosAnimalito;
import com.curso.dtos.DatosDeNuevoAnimalito;
import com.curso.entidades.Animalito;
import com.curso.repositorios.RepositorioDeAnimalitos;
import com.curso.servicios.ServicioDeAnimalitos;
import com.curso.servicios.ServicioDeEmails;
import org.springframework.stereotype.Service;

// Spring !!! Empapate !!!
// // Que cuando alguien pida un ServicioDeAnimalitos, le entregará una instancia de esta clase
@Service
public class ServicioDeAnimalitosImpl implements ServicioDeAnimalitos {

    private RepositorioDeAnimalitos repositorioDeAnimalitos;
    private ServicioDeEmails servicioDeEmails;

    public ServicioDeAnimalitosImpl(ServicioDeEmails servicioDeEmails, RepositorioDeAnimalitos repositorioDeAnimalitos) {
        this.repositorioDeAnimalitos = repositorioDeAnimalitos;
        this.servicioDeEmails = servicioDeEmails;
    }

    @Override
    public DatosAnimalito altaDeAnimalito(DatosDeNuevoAnimalito datosNuevoAnimalito) {
        // Meter el animalito en el repositorio
        Animalito animalito = mapearDatosNuevoAnimalito2Animalito(datosNuevoAnimalito);
        Animalito animalitoConSuId = repositorioDeAnimalitos.save(animalito);
        if( servicioDeEmails.hanDeEnviarseEmails().isSeguroQueNoHayQueEnviar()
            && servicioDeEmails.hanDeEnviarseEmails().isHayQueEnviar() ) {
            // Enviar un email de confirmación
            servicioDeEmails.enviarEmail("destinatiario@prueba.com", "Alta de animalito",
                    "Se ha dado de alta el animalito " + animalitoConSuId.getNombre());
        }
        // Devolver los nuevos datos (incluyendo el ID)
        DatosAnimalito aDevolver = mapearAnimalito2DatosAnimalito(animalitoConSuId);
        return aDevolver;
    }

    private DatosAnimalito mapearAnimalito2DatosAnimalito(Animalito animalitoConSuId) {
        DatosAnimalito datosAnimalito = new DatosAnimalito();
        datosAnimalito.setId(animalitoConSuId.getId());
        datosAnimalito.setNombre(animalitoConSuId.getNombre());
        datosAnimalito.setTipo(animalitoConSuId.getTipo());
        datosAnimalito.setColor(animalitoConSuId.getColor());
        datosAnimalito.setEdad(animalitoConSuId.getEdad());
        return datosAnimalito;
    }

    private Animalito mapearDatosNuevoAnimalito2Animalito(DatosDeNuevoAnimalito datosNuevoAnimalito) {
        Animalito animalito = new Animalito();
        animalito.setNombre(datosNuevoAnimalito.getNombre());
        animalito.setTipo(datosNuevoAnimalito.getTipo());
        animalito.setColor(datosNuevoAnimalito.getColor());
        animalito.setEdad(datosNuevoAnimalito.getEdad());
        return animalito;
    }
}
