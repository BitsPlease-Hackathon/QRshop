package com.bitsplease.qrshop.service.document;

import java.util.List;

/**
 * @author Chrisostomos Bakouras
 */
public interface DownloadPdfService {
    String generateProductPdf(List<String> ids);
}
