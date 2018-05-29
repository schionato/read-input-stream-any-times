package com.github.schionato;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

class InputStreamCloner {

    private final byte[] raw;

    InputStreamCloner(final InputStream inputStream) throws IOException {
	this.raw = toByteArrayOutputStream(inputStream).toByteArray();
    }

    private static ByteArrayOutputStream toByteArrayOutputStream(InputStream inputStream) throws IOException {
	final byte[] data = new byte[1024];
	int read;

	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	while ((read = inputStream.read(data, 0, data.length)) != -1) {
	    baos.write(data, 0, read);
	}
	baos.flush();
	return baos;
    }

    InputStream makeCopy() {
	return new ByteArrayInputStream(raw);
    }
}
