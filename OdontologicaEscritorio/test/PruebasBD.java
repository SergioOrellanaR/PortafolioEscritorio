/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import odontologicaescritorio.modelo.*;
import odontologicaescritorio.controlador.*;

/**
 *
 * @author Marco Antonio
 */
public class PruebasBD {
    
    public PruebasBD() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
//    @Test
//    public void pruebaRegistrarServicioBD(){
//        System.out.println(new Registro().registrarServicioBD("SERVICIO PRUEBA", 0));
//    }
    @Test
    public void pruebaBuscarPacienteBD(){
        System.out.println(new Consulta().buscarPaciente(18984598));
    }
    
    
}
