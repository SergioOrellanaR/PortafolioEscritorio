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

import net.sf.nervalreports.core.ReportGenerationException;
import net.sf.nervalreports.core.ReportGenerator;
import net.sf.nervalreports.generators.PDFReportGenerator;



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
//    @Test
//    public void pruebaBuscarPacienteBD(){
//        System.out.println(new Consulta().buscarPaciente(18984598));
//    }
    
    private static void generate(ReportGenerator reportGenerator) throws ReportGenerationException {
        /* Every document should begin. */
        reportGenerator.beginDocument();

        /* A document must have a head, where some things are declared, for example new colors.
         * For now, let's just declare it without anything besides their normal behavior. */
        reportGenerator.beginDocumentHead();
        reportGenerator.endDocumentHead();

        /* All report visible elements are inserted inside the document's body, so we must declare its block. */
        reportGenerator.beginDocumentBody();

        /* Finally, hello! */
        reportGenerator.addText("Hello world!");

        /* As body began, it must end. */
        reportGenerator.endDocumentBody();

        /* every document should end */
        reportGenerator.endDocument();
    }
        
    @Test
    public void generarReportePrueba(){
        /* By default, our tutorials usually use PDFReportGenerator. But you can change it for any other generator. */
        PDFReportGenerator reportGenerator = new PDFReportGenerator();
        try {
                generate(reportGenerator);
                System.out.println("GENERADO!");
                reportGenerator.saveToFile("D:\\tutorial_01_hello_world.pdf");

                /* After the generator is no longer needed is a good practice to release it.
                 * Although for the tutorial is not really necessary, as we'll no longer use it anyway. */
                reportGenerator.release();
        } catch (ReportGenerationException e) {
                System.out.printf("Exception when generating the report: %s\n", e.getMessage());
        }

    }

}
