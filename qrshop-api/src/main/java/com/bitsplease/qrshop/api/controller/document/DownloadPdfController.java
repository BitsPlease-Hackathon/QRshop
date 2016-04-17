package com.bitsplease.qrshop.api.controller.document;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

/**
 * @author Chrisostomos Bakouras
 */
public interface DownloadPdfController {
    ResponseEntity<InputStreamResource> downloadPDFFile(List<String> id) throws IOException;
}
