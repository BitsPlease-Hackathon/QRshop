package com.bitsplease.qrshop.service.document;

import com.bitsplease.qrshop.domain.entity.system.Product;
import com.bitsplease.qrshop.domain.resository.system.ProductRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

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
        String path = System.getProperty("java.io.tmpdir") + "/" + UUID.randomUUID().toString() + ".pdf";

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(path));

            document.open();

            document.add(new Paragraph("Available Products"));

            for (String id : ids) {
                if (productRepository.exists(id)) {
                    Product product = productRepository.findOne(id);

                    String qrPath = qrCodeService.qrCodify(product.getId());

                    Image qrImage = Image.getInstance(qrPath);
                    Image productImage = Image.getInstance(base64ToImage(product.getImageBase64()));

                    PdfPTable placeholder = new PdfPTable(3);
                    placeholder.setSpacingBefore(10);

                    PdfPTable table = new PdfPTable(2);

                    table.addCell("Name");
                    table.addCell(product.getName());
                    table.addCell("Description");
                    table.addCell(product.getDescription());
                    table.addCell("Price");
                    table.addCell(String.valueOf(product.getPrice()));

                    placeholder.addCell(productImage);
                    placeholder.addCell(qrImage);
                    placeholder.addCell(table);

                    document.add(placeholder);
                }
            }

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }

    private String base64ToImage(String base64) throws IOException {
        String path = ".jpg";

        byte[] data = Base64.decodeBase64(base64);
        try (OutputStream stream = new FileOutputStream(path)) {
            stream.write(data);
        }

        return path;
    }
}
