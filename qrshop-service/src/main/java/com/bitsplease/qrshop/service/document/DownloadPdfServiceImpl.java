package com.bitsplease.qrshop.service.document;

import com.bitsplease.qrshop.domain.entity.system.Product;
import com.bitsplease.qrshop.domain.resository.system.ProductRepository;
import com.google.zxing.Writer;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static org.springframework.transaction.support.TransactionSynchronizationManager.getResource;

/**
 * @author Chrisostomos Bakouras
 */
@Service
public class DownloadPdfServiceImpl implements DownloadPdfService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private QRCodeService qrCodeService;

    @Override
    public String generateProductPdf(List<String> ids) {
        String path = getResource("./") + UUID.randomUUID().toString() + ".pdf";

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(path));

            document.open();

            document.add(new Paragraph("Available Products"));

            for(String id : ids) {
                if(productRepository.exists(id)) {
                    Product product = productRepository.findOne(id);

                    String qrPath = qrCodeService.qrCodify(product.getId());

                    Image img = null;
                    try {
                        img = Image.getInstance(qrPath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    PdfPTable placeholder = new PdfPTable(2);
                    placeholder.setSpacingBefore(10);

                    PdfPTable table = new PdfPTable(2);

                    table.addCell("Name");
                    table.addCell(product.getName());
                    table.addCell("Description");
                    table.addCell(product.getDescription());
                    table.addCell("Price");
                    table.addCell(String.valueOf(product.getPrice()));

                    placeholder.addCell(img);
                    placeholder.addCell(table);

                    document.add(placeholder);
                }
            }

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return path;
    }
}
