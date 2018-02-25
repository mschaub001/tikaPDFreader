/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// https://stackoverflow.com/questions/18098400/how-to-get-raw-text-from-pdf-file-using-java
package com.example.ms.tikapdfreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;

/**
 *
 * @author ms
 */
public class tikaPDFreader {

    public static void main(final String[] args) throws IOException, TikaException {

        try {
            BodyContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            FileInputStream inputstream = new FileInputStream(new File("c:/temp/O_Lehrpersonen.pdf"));
            ParseContext pcontext = new ParseContext();

            //parsing the document using PDF parser
            PDFParser pdfparser = new PDFParser();
            pdfparser.parse(inputstream, handler, metadata, pcontext);

            //getting the content of the document
            System.out.println(
                    "Contents of the PDF :" + handler.toString());

            //getting metadata of the document
            System.out.println(
                    "Metadata of the PDF:");
            String[] metadataNames = metadata.names();

            for (String name : metadataNames) {
                System.out.println(name + " : " + metadata.get(name));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
