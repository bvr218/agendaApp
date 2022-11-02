/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import java.awt.Font;
import java.io.IOException;

/**
 *
 * @author fvr
 */
public class export {

    public void export(){
        

    }
    public void exportar(String fecha, String nomTit, String CC, String NumCel, String Direc, String IDT, String Plan, String Costo, String CodB, String TEquipos[],String EDesc[],String EMac[],String ESerie[],String AMaterial[],String ACantidad[], String Tecnico){
       Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte Alumnos.pdf"));
            Image header = Image.getInstance("src/img/fututel-name_adobespark.png");
            header.scaleToFit(150, 300);
            header.setAbsolutePosition(400f, 700f);
            documento.open();

            PdfPTable DateTable = new PdfPTable(2);
            PdfPTable TitularTitleTable = new PdfPTable(1);
            PdfPTable TitularTable = new PdfPTable(2);
            PdfPTable Services = new PdfPTable(3);
            PdfPTable Equipos = new PdfPTable(4);
            PdfPTable Acces = new PdfPTable(2);

            Acces.setWidths(new int[]{150,150});
            Acces.addCell("MATERIALES");
            Acces.addCell("CANTIDAD");
            for(int i = 0; i < TEquipos.length; i++){
                Acces.addCell(AMaterial[i]);
                Acces.addCell(ACantidad[i]);
                
            }
         
            Equipos.setWidths(new int[]{75,75,75,75});
            Equipos.addCell("TIPO DE EQUIPO");
            Equipos.addCell("DESCRIPCION");
            Equipos.addCell("N. DE MAC");
            Equipos.addCell("N. DE SERIE");
            for(int i = 0; i < TEquipos.length; i++){
                Equipos.addCell(TEquipos[i]);
                Equipos.addCell(EDesc[i]);
                Equipos.addCell(EMac[i]);
                Equipos.addCell(ESerie[i]);
            }
            

            DateTable.setWidths(new int[]{150, 230});
            DateTable.addCell("FECHA DE INSTALACION");
            DateTable.addCell(fecha);

            
            TitularTitleTable.setWidths(new int[]{300});
            TitularTitleTable.addCell("DATOS CLIENTE TITULAR");

            
            TitularTable.setWidths(new int[]{120, 200});
            TitularTable.addCell("Nombres y apellidos:");
            TitularTable.addCell(nomTit);
            TitularTable.addCell("No. Cedula:");
            TitularTable.addCell(CC);
            TitularTable.addCell("No. Celular:");
            TitularTable.addCell(NumCel);
            TitularTable.addCell("direccion:");
            TitularTable.addCell(Direc);
            TitularTable.addCell("ID de trabajo:");
            TitularTable.addCell(IDT);
            

            
            Services.setWidths(new int[]{100, 100, 100});
            Services.addCell("PLAN");
            Services.addCell("COSTO DEL PLAN");
            Services.addCell("CODIGO DE CAJA");
            Services.addCell(Plan);
            Services.addCell(Costo);
            Services.addCell(CodB);
            

            
            Paragraph parrafo = new Paragraph();
            Paragraph Cparrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_TOP);
            parrafo.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo.setFont(FontFactory.getFont("Arial", 25, Font.BOLD, BaseColor.BLACK));
            parrafo.add("\n\nFUTUTEL \n");

            parrafo.setFont(FontFactory.getFont("Arial", 9, Font.BOLD, BaseColor.BLACK));
            parrafo.add("Razón Social: MORALES ROJAS JHON JADER \n");
            parrafo.add("NIT: ");
            parrafo.setFont(FontFactory.getFont("Arial", 9, BaseColor.BLACK));
            parrafo.add("1075241517-3 \n");
            parrafo.add("Pitalito - Huila -Colombia \n");
            parrafo.setFont(FontFactory.getFont("Arial", 9, Font.BOLD, BaseColor.BLACK));
            parrafo.add("Contacto: ");
            parrafo.setFont(FontFactory.getFont("Arial", 9, BaseColor.BLACK));
            parrafo.add("031 220 5225, 318 726 7705 \n");
            Cparrafo.setAlignment(Paragraph.ALIGN_CENTER);
            Cparrafo.setFont(FontFactory.getFont("Arial", 16, Font.BOLD, BaseColor.BLACK));
            Cparrafo.add("\nANEXO DE ACTA DE INSTALACIÓN\n\n");

            documento.add(header);
            documento.add(parrafo);
            documento.add(Cparrafo);
            documento.add(DateTable);

            Cparrafo.setFont(FontFactory.getFont("Arial", 16, Font.BOLD, BaseColor.BLACK));
            Cparrafo.clear();
            Cparrafo.add("\n");
            documento.add(Cparrafo);
            documento.add(TitularTitleTable);
            documento.add(TitularTable);
            Cparrafo.setFont(FontFactory.getFont("Arial", 16, Font.BOLD, BaseColor.BLACK));
            Cparrafo.add("\nSERVICIOS CONTRATADOS\n\n");
            documento.add(Cparrafo);
            documento.add(Services);
            Cparrafo.clear();
            Cparrafo.add("\n\n");
            Cparrafo.add("EQUIPOS INSTALADOS\n\n");
            documento.add(Cparrafo);
            documento.add(Equipos);
            Cparrafo.clear();
            Cparrafo.add("\n\n");
            Cparrafo.add("ACCESORIOS INSTALADOS\n\n");
            documento.add(Cparrafo);
            documento.add(Acces);
            Cparrafo.clear();
            Cparrafo.setFont(FontFactory.getFont("Arial", 9, Font.BOLD, BaseColor.BLACK));
            Cparrafo.setAlignment(Paragraph.ALIGN_BOTTOM);
            Cparrafo.setAlignment(Paragraph.ALIGN_RIGHT);
            Cparrafo.add("\n\n\n\n");
            Cparrafo.add("TECNICO INSTALADOR: " + Tecnico);
            documento.add(Cparrafo);

            documento.close();
            JOptionPane.showMessageDialog(null, "reporte creado");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
}
