package com.infrrd.FileAssignment.controllers;


import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.infrrd.FileAssignment.response.FileResponse;
import com.infrrd.FileAssignment.storage.StorageService;

@Controller
public class FileController {
	
	private StorageService storageService;

    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }
    
    @GetMapping("/download/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

        Resource resource = storageService.loadAsResource(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
    
    
    @PostMapping("/upload-file")
    @ResponseBody
    public FileResponse uploadFile(@RequestParam("file") MultipartFile file) {
    	System.out.println("file1= "+file);
        String name = storageService.store(file);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(name)
                .toUriString();

        System.out.println("file2= "+file);
        return new FileResponse(name, uri, file.getContentType(), file.getSize());
    }
    
    @DeleteMapping("/download/{filename:.+}")
    public ResponseEntity<Void> deleteFile(@PathVariable String filename) throws IOException
    {
    	storageService.delete(filename);
    	
    	return ResponseEntity.noContent().build();
    }	
    

}
