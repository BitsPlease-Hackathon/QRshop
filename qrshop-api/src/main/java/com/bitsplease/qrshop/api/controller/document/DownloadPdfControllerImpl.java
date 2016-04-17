package com.bitsplease.qrshop.api.controller.document;

import com.bitsplease.qrshop.service.document.DownloadPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author Chrisostomos Bakouras
 */
@RestController
@RequestMapping("/pdf")
public class DownloadPdfControllerImpl implements DownloadPdfController {

    @Autowired
    private DownloadPdfService downloadPdfService;

    @Override
    @RequestMapping(method = RequestMethod.GET, produces = "application/pdf")
    public ResponseEntity<InputStreamResource> downloadPDFFile(@RequestParam List<String> id) throws IOException {

        String path = downloadPdfService.generateProductPdf(id);

        FileSystemResource pdfFile = new FileSystemResource(path);

        return ResponseEntity
                .ok()
                .contentLength(pdfFile.contentLength())
                .contentType(
                        MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(pdfFile.getInputStream()));
    }
}
