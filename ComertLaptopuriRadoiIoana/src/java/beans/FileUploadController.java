/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author Oana
 */

 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
 

import org.primefaces.model.UploadedFile;
  

public class FileUploadController implements java.io.Serializable{
   //folderul destinatie unde va fi pus fisierul uploadat
   private String destination="C:\\wamp\\www\\ComertLaptopuriRadoiIoana\\web\\upload\\";
   
   //numele fisierului uploadat
   private String nume;
   //fisierul uploadat
   private UploadedFile file;
 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = null;
        this.file = file;
        nume= this.file.getFileName();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
  
    
    //functia de upload de fisier ce creaza un mesaj si apeleaza functia copyFile
    public void upload() {  
        FacesMessage msg = new FacesMessage("Success! ", file.getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);             
        try {
            copyFile(file.getFileName(), file.getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    //functia de generare html cu ajutorul xsl-ului si xml-ul uploadat
    public void generateHtml() throws FileNotFoundException, TransformerConfigurationException, TransformerException{
   
        TransformerFactory tFactory=TransformerFactory.newInstance();
             
        Source xslDoc=new StreamSource("C:\\wamp\\www\\ComertLaptopuriRadoiIoana\\web\\files\\ComertLaptopuriRadoiIoana.xsl");       
        
        String s; 
        StringBuffer sb = new StringBuffer("C:\\wamp\\www\\ComertLaptopuriRadoiIoana\\web\\upload\\");
        s = sb.append(this.nume).toString();
        
        Source xmlDoc=new StreamSource(s);        
        
        String outputFileName="C:\\wamp\\www\\ComertLaptopuriRadoiIoana\\web\\result.xhtml";

        OutputStream htmlFile= new FileOutputStream(outputFileName);
        Transformer trasform=tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(htmlFile));
        
       
    }
 
    
    //functia de copiere a fisierului uploadat in folderul dorit
    public void copyFile(String fileName, InputStream in) throws IOException {
        OutputStream out = null;
       try {
           out = new FileOutputStream(new File(destination + fileName));
           int read = 0;
           byte[] bytes = new byte[1000];
           while ((read = in.read(bytes)) != -1) {
               out.write(bytes, 0, read);
           }
           in.close();
           out.flush();
           out.close();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           try {
               out.close();
           } catch (IOException ex) {
               Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
              
              
                
    }
}