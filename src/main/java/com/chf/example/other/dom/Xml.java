package com.chf.example.other.dom;

import org.apache.commons.collections.CollectionUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.chf.example.apache.fastxml.xml.XmlUtil;
import com.chf.example.domain.A;
import com.chf.example.domain.D;

public class Xml {

    public static String parse(String xmlstring) {

        try {
            Document doc = DocumentHelper.parseText(xmlstring);

            Element root = doc.getRootElement();
            enumElememt(root);
            return doc.asXML();
        } catch (DocumentException e) {
        }
        return "";
    }

    private static void enumElememt(Element element) {
        for (Object o : element.elements()) {
            Element e = (Element) o;

            if (CollectionUtils.isNotEmpty(e.elements())) {
                enumElememt(e);
            } else {
                System.out.println(e.getText());
                e.setText("a");
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        a.setA(2);
        a.setStr("123");
        a.setD(new D("d"));
        String xml = XmlUtil.formObject(a);
        System.out.println(xml);
        System.out.println(Xml.parse(xml));

    }
}
