package com.portfolio.kiraPortfolio.file;

import java.nio.file.Path;
import java.util.stream.Stream;

import com.portfolio.kiraPortfolio.project.Project;
import com.portfolio.kiraPortfolio.project.ProjectImage;
import com.portfolio.kiraPortfolio.skill.CertificationImage;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
  public void init();

  public void save(MultipartFile file);
  public void saveProjectImages(MultipartFile file, ProjectImage projectImage);
  public void saveProjectVideo(MultipartFile file, Project project);
  public void saveCertificateImage(MultipartFile file, CertificationImage image);
  public Resource load(String filename);

  public void deleteAll();

  public Stream<Path> loadAll();
}
