package pl.sda.pdf;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;
import pl.sdacademy.model.Company;
import pl.sdacademy.service.DataService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;


public class PdfFactory {

    public void createPdf() {
        Properties properties = DataService.loadProperties();
        String pdfPath = properties.getProperty("pdfPath");

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath + File.separator + "file.pdf"));
            document.open();
            document.add(new Paragraph());  //paragraph to jeden z elementow ktore sa w pdf
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void pdfFromCompany(Company company){
        Properties properties = DataService.loadProperties();
        String pdfPath = properties.getProperty("pdfPath");
        DataService dataService = new DataService();
        List<String> list = dataService.printCompanyInfo(company);
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath + File.separator + "file.pdf"));
            document.setPageSize(new Rectangle(180, 240));
            document.open();
            for(String e: list) {
                document.add(new Paragraph(e));
            }
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

