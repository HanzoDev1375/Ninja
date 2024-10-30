package ninja.lang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NinjaFile {
  protected File file;

  public NinjaFile(File file) {
    this.file = file;
  }

  public boolean exists() {
    return file.exists();
  }

  public String readContent() throws IOException {
    if (!exists()) {
      throw new IOException("File does not exist.");
    }

    StringBuilder content = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        content.append(line).append("\n");
      }
    }
    return content.toString();
  }

  public boolean deleteFile() {
    return file.delete();
  }

  public boolean renameFile(String newName) {
    File newFile = new File(file.getParent(), newName);
    return file.renameTo(newFile);
  }

  public boolean isDirectory() {
    return file.isDirectory();
  }

  public List<File> getListFile() {
    File files = new File(file.getPath());
    File[] arrFile = files.listFiles();
    List<File> mylistFile = new ArrayList<>(Arrays.asList(arrFile));
    return mylistFile;
  }

  public boolean copyFile(File destination) throws IOException {
    if (!exists()) {
      throw new IOException("File does not exist.");
    }
    Files.copy(file.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
    return true;
  }

  public long getFileSize() {
    if (!exists()) {
      return -1;
    }
    return file.length();
  }

  public void writeContent(String content) throws IOException {
    try (FileWriter writer = new FileWriter(file, false)) {
      writer.write(content);
    }
  }

  public void appendContent(String content) throws IOException {
    try (FileWriter writer = new FileWriter(file, true)) {
      writer.write(content);
      writer.write("\n");
    }
  }

  public boolean searchInFile(String searchString) throws IOException {
    String content = readContent();
    return content.contains(searchString);
  }

  public boolean setReadable(boolean readable) {
    return file.setReadable(readable);
  }

  public boolean setWritable(boolean writable) {
    return file.setWritable(writable);
  }

  public boolean setExecutable(boolean executable) {
    return file.setExecutable(executable);
  }

  public String getFileNameWithoutExtension() {
    String name = file.getName();
    int dotIndex = name.lastIndexOf('.');
    if (dotIndex > 0) {
      return name.substring(0, dotIndex);
    }
    return name;
  }

  public boolean moveFile(String targetPath) throws IOException {
    File targetFile = new File(targetPath);
    Files.move(file.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    return true;
  }

  public List<String> readLines() throws IOException {
    return Files.readAllLines(Paths.get(file.getPath()));
  }
}
