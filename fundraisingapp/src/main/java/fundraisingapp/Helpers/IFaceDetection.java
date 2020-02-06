package fundraisingapp.Helpers;

import org.opencv.core.Mat;

import java.awt.image.BufferedImage;

public interface IFaceDetection {
    Mat detectFaces(BufferedImage image);
    String encodeToString(BufferedImage image, String type);
    BufferedImage decodeImage(String string64);
    BufferedImage toBufferedImage(Mat m);

}
