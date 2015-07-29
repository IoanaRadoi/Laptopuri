/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import view.LaptopNew;

public class laptopXML implements java.io.Serializable {

    private ArrayList<LaptopNew> laptopuri;

    public laptopXML() {
        laptopuri = new ArrayList<>();
    }

    public void setLaptopuri(ArrayList<LaptopNew> laptopuri) {
        this.laptopuri = laptopuri;
    }

    public ArrayList<LaptopNew> getLaptopuri() {
        return laptopuri;
    }

    //functia ce imi parseaza fisierul xml uploadat si imi pun datele in obiecte LaptopNew
    public void creareLaptopuri() {

        laptopuri.clear();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        factory.setValidating(false);
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.out.println("Eroare la crearea Document Builder - ului :" + e.getMessage());
            System.exit(1);
        }

        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elContext = fc.getELContext();
        ExpressionFactory ef = ExpressionFactory.newInstance();
        ValueExpression ve = ef.createValueExpression(elContext, "#{fileUploadController.nume}", String.class);
        String numefis = (String) ve.getValue(elContext);
        String s;
        StringBuffer sb = new StringBuffer("C:\\wamp\\www\\ComertLaptopuriRadoiIoana\\web\\upload\\");
        s = sb.append(numefis).toString();

        Document doc = null;
        try {
            doc = docBuilder.parse(new File(s));
        } catch (SAXException e) {
            System.err.println("Eroare la parsarea documentului [" + s + "]:" + e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Eroare I/O la deschierea fisierului[" + s + "]:" + e.getMessage());
            System.exit(1);
        }

        NodeList n1 = doc.getElementsByTagName("laptop");

        for (int i = 0; i < n1.getLength(); i++) {
            LaptopNew l = new LaptopNew();

            Element elm = (Element) n1.item(i).getParentNode();
            Node attr = elm.getAttributes().item(0);
            //System.out.println(attr.getNodeValue());
            l.setTip(attr.getNodeValue());

            Element elm2 = (Element) elm.getParentNode();
            Node attr2 = elm2.getAttributes().item(0);
            //System.out.println(attr2.getNodeValue());
            l.setMarca(attr2.getNodeValue());

            Element lap = (Element) n1.item(i);

            NodeList denu = lap.getElementsByTagName("denumire");
            Element elDen = (Element) denu.item(0);
            //System.out.println(elDen.getTextContent());
            l.setDenumire(elDen.getTextContent());

            NodeList disp = lap.getElementsByTagName("disponibilitate");
            Element elDisp = (Element) disp.item(0);
            //System.out.println(elDisp.getTextContent());
            l.setDisponibilitate(elDisp.getTextContent());

            NodeList carac = lap.getElementsByTagName("descriere");

            Element frec_proc = (Element) carac.item(0);
            //System.out.println(frec_proc.getTextContent());
            l.setFrec_proc(frec_proc.getTextContent());

            Element di_cache = (Element) carac.item(1);
            //System.out.println(di_cache.getTextContent());
            l.setDim_cache(di_cache.getTextContent());

            Element tip_uni = (Element) carac.item(2);
            //System.out.println(tip_uni.getTextContent());
            l.setTip_unitate_stocare(tip_uni.getTextContent());

            Element mem_ram = (Element) carac.item(3);
            //System.out.println(mem_ram.getTextContent());
            l.setMemorie_ram(mem_ram.getTextContent());

            Element cap_hdd = (Element) carac.item(4);
            //System.out.println(cap_hdd.getTextContent());
            l.setCap_hdd(cap_hdd.getTextContent());

            Element pret = (Element) carac.item(5);
            //System.out.println(pret.getTextContent());
            l.setPret(pret.getTextContent());

            NodeList poza = lap.getElementsByTagName("poza");
            Element elPoza = (Element) poza.item(0);
            //System.out.println(elDisp.getTextContent());
            l.setPoza(elPoza.getTextContent());

            laptopuri.add(l);
        }
    }
}
