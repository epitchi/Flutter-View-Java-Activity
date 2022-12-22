package com.example.flutter_view_java_activity.nvstream.http;

import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;

public interface LimelightCryptoProvider {
    X509Certificate getClientCertificate();
    RSAPrivateKey getClientPrivateKey();
    byte[] getPemEncodedClientCertificate();
    String encodeBase64String(byte[] data);
}
