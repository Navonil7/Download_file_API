package com.infrrd.FileAssignment.storage;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	void init();

    String store(MultipartFile file);

    Path load(String filename);

    Resource loadAsResource(String filename);

    void delete(String filename) throws IOException;
	
}
