package com.iterlife.zeus.spring.core;

import java.io.File;

public class FileSystemResource extends AbstractResource {

    private final File   file;
    private final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    public File getFile() {
        return file;
    }

    public String getPath() {
        return path;
    }
}
