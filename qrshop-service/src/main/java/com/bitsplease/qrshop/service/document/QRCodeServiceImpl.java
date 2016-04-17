package com.bitsplease.qrshop.service.document;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Chrisostomos Bakouras
 */
@Service
public class QRCodeServiceImpl implements QRCodeService {

    @Override
    public String qrCodify(String qrCodeData) {
        String filePath = System.getProperty("java.io.tmpdir") + "/" + UUID.randomUUID().toString() + ".png";

        String charset = "UTF-8";
        Map hintMap = new HashMap();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        try {
            createQRCode(qrCodeData, filePath, charset, hintMap, 80, 80);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;
    }

    public void createQRCode(String qrCodeData, String filePath,
                             String charset, Map hintMap, int qrCodeheight, int qrCodewidth)
            throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
        MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                .lastIndexOf('.') + 1), new File(filePath));
    }
}
