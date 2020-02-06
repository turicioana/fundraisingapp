package fundraisingapp.Helpers;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class FaceDetection implements IFaceDetection {

    @Override
    public BufferedImage decodeImage(String string64){
        BufferedImage bufferedImage = null;
        byte[] imageByte;
        try{
            BASE64Decoder decoder = new BASE64Decoder();
            string64 = string64.split(";base64,")[1];
            imageByte = decoder.decodeBuffer(string64);
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(imageByte);
            bufferedImage = ImageIO.read(byteInputStream);
            byteInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  bufferedImage;
    }

    @Override
    public BufferedImage toBufferedImage(Mat m) {
        if (!m.empty()) {
            int type = BufferedImage.TYPE_BYTE_GRAY;
            if (m.channels() > 1) {
                type = BufferedImage.TYPE_3BYTE_BGR;
            }
            int bufferSize = m.channels() * m.cols() * m.rows();
            byte[] b = new byte[bufferSize];
            m.get(0, 0, b); // get all the pixels
            BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
            final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
            System.arraycopy(b, 0, targetPixels, 0, b.length);
            return image;
        }

        return null;
    }

    @Override
    public String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            Base64.Encoder encoder = Base64.getEncoder();
            imageString = encoder.encodeToString(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    @Override
    public Mat detectFaces(BufferedImage imageBuffer) {
        nu.pattern.OpenCV.loadShared();
        CascadeClassifier faceDetector = new CascadeClassifier();
        faceDetector.load("E:\\Ioana\\Licenta\\fundraisingapp\\fundraisingapp\\src\\main\\resources\\haarcascade_frontalface_alt.xml");

        Mat image = new Mat(imageBuffer.getHeight(), imageBuffer.getWidth(), CvType.CV_8UC3);
        byte[] data = ((DataBufferByte) imageBuffer.getRaster().getDataBuffer()).getData();
        image.put(0, 0, data);

        MatOfRect faceDetection = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetection);

        for(Rect rect : faceDetection.toArray()){
            Mat rectMat = new Mat(image, rect);
            Imgproc.GaussianBlur(rectMat, rectMat, new Size(45, 45), 100, 100);
        }
//        String filename = "Output.jpg";
//        Imgcodecs.imwrite("C:\\Users\\turic\\Desktop\\licenta\\"+filename, image);
        return image;
    }
}
