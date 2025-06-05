package com.example.cleancoder.tdd.tyrant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TyrantMap {
    public static final int OPERATION_PREFIX = 0xC8;
    public static final int OPERATION_PUT = 0x10;
    public static final int OPERATION_GET = 0x30;

    private Socket socket;
    private DataOutputStream writer;
    private DataInputStream reader;

    public void put(String key, String value) throws IOException {
        writeHeader(OPERATION_PUT);
        writeKeyValue(key, value);
        verifyStatus();
    }

    public void open() throws IOException {
        socket = new Socket("localhost", 1978);
        writer = new DataOutputStream(socket.getOutputStream());
        reader = new DataInputStream(socket.getInputStream());
    }

    public byte[] get(String key) throws IOException {
        writeHeader(OPERATION_GET);
        writeKey(key);
        verifyStatus();
        return readResults();
    }

    public void close() throws IOException {
        reader.close();
        writer.close();
        socket.close();
    }

    private void writeKey(String key) throws IOException {
        writer.writeInt(key.length());
        writer.write(key.getBytes());
    }

    private void writeHeader(int operationCode) throws IOException {
        writer.write(OPERATION_PREFIX);
        writer.write(operationCode);
    }

    private void writeKeyValue(String key, String value) throws IOException {
        writer.writeInt(key.length());
        writer.writeInt(value.length());
        writer.write(key.getBytes());
        writer.write(value.getBytes());
    }

    private void verifyStatus() throws IOException {
        int status = reader.read();
        assert status == 0;
    }

    private byte[] readResults() throws IOException {
        int length = reader.readInt();
        byte[] results = new byte[length];
        reader.read(results);
        return results;
    }
}
