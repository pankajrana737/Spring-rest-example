package com.pankaj.springrestexample;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Locale;

import javax.activation.FileTypeMap;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
	@Autowired
	MessageSource messageSource;
	
	@GetMapping("/helloWorld")
	//public String Greeting(@RequestHeader(name="Accept-Language",required = false,defaultValue = "US") Locale locale) {
	// by default it will pick up locale.us
	public String Greeting() {
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
	
// serving image in broswer
	 @RequestMapping(value = "/get-images", method = RequestMethod.GET,
	            produces = MediaType.IMAGE_JPEG_VALUE)
	    public ResponseEntity<byte[]> getImage() throws IOException {
	    	String message = messageSource.getMessage("image-path",null, LocaleContextHolder.getLocale());
	        ClassPathResource imgFile = new ClassPathResource(message);
	        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

	        return ResponseEntity
	                .ok()
	                .contentType(MediaType.IMAGE_JPEG)
	                .body(bytes);
	    }

	// serving pdf in broswer
	@GetMapping("thing")
	public ResponseEntity<byte[]> what() throws IOException{
	    File file = new File("src/main/resources/static/sample.pdf");
	    return ResponseEntity.ok()
	            .header("Content-Disposition", "attachment; filename=" +file.getName())
	            .contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(file)))
	            .body(Files.readAllBytes(file.toPath()));
	}
}
