package com.portfolio.kiraPortfolio.file;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.portfolio.kiraPortfolio.project.Project;
import com.portfolio.kiraPortfolio.project.ProjectImage;
import com.portfolio.kiraPortfolio.skill.CertificationImage;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageServiceImpl implements FileStorageService {

  private final Path root = Paths.get("uploads");

  @Override
  public void init() {
    try {
      Files.createDirectory(root);
    } catch (IOException e) {
      throw new RuntimeException("Could not initialize folder for upload!");
    }
  }

  @Override
  public void save(MultipartFile file) {
    try {
      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
    } catch (Exception e) {
      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
    }
  }
  @Override
  public void saveProjectImages(MultipartFile file, ProjectImage projectImage){
    try{
      Path path = Path.of("uploads/projectImages/" + projectImage.getProject().getId());
      if(!Files.exists(path)){
        Files.createDirectory(path);
      }
      Files.copy(file.getInputStream(),path.resolve(file.getOriginalFilename()));
    }catch(Exception e){
      System.out.println(e);
    }
  }
  public void saveProjectVideo(MultipartFile file, Project project){
    try{
      Path path = Path.of("uploads/projectVideos/");
      if(!Files.exists(path)){
        Files.createDirectory(path);
      }
      Files.copy(file.getInputStream(),path.resolve(project.getId().toString()));
    }catch(Exception e){
      System.out.println(e);
    }
  }
  @Override
  public void saveCertificateImage(MultipartFile file, CertificationImage image){
    try{
      Path path = Path.of("uploads/certificationImages/");
      if(!Files.exists(path)){
        Files.createDirectory(path);
      }
      Files.copy(file.getInputStream(),path.resolve(image.getCertificate().getId().toString()));
    }catch(Exception e){
      System.out.println(e);
    }
  }
  @Override
  public Resource load(String filename) {
    try {
      Path file = root.resolve(filename);
      Resource resource = new UrlResource(file.toUri());

      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read the file!");
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }

  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(root.toFile());
  }

  @Override
  public Stream<Path> loadAll() {
    try {
      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
    } catch (IOException e) {
      throw new RuntimeException("Could not load the files!");
    }
  }
}
