package com.iterlife.zeus.xspring.core;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public interface Resource extends InputStreamSource {
    boolean isExist();

    boolean isReadable();

    boolean isOpen();

    URL getURL() throws IOException;

    URI getURI() throws IOException;

    File getFile() throws IOException;

    long getContentLength() throws IOException;

    long lastModified() throws IOException;

    String getFileName();

    String getDescription();

    File createRelativeFile(String relativePath) throws IOException;
}
