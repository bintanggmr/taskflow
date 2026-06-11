package com.taskflow.taskflow.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordUtil {

    // Fungsi untuk mengubah password mentah menjadi hash SHA-256 (Secure Hashing)
    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error: Algoritma enkripsi tidak ditemukan", e);
        }
    }
}