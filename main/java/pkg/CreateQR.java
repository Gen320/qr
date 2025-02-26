package pkg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class CreateQR {
	public static String createQr(String key) {
		String filePath = null;
		try {
	        String source = key;
	        String encoding = "UTF-8";
	        int size = 300;
	        String p1 = Paths.get("").toAbsolutePath().toString() + "/src/main/webapp/img/";
	        filePath = p1 + "qr_code.png";
	
	        Map<EncodeHintType, Object> hints = new HashMap<>();
	        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
	        hints.put(EncodeHintType.CHARACTER_SET, encoding);
	        hints.put(EncodeHintType.MARGIN, 2); // マージンを2に変更
	
	        QRCodeWriter writer = new QRCodeWriter();
	        BitMatrix bitMatrix = writer.encode(source, BarcodeFormat.QR_CODE, size, size, hints);
	        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
	
	        ImageIO.write(image, "png", new File(filePath));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		return filePath;
	}
	
	public static void main(String[] args) {
	}
}
