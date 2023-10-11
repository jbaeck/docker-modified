// based on https://github.com/bechhansen/docker-win-5543/tree/master

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;

public class ModifiedTest {

  public static void main(String[] args) throws IOException, InterruptedException {

    long time = System.currentTimeMillis();
    String path = "./";
    if (args.length == 1) {
      path = args[0];
    }

    File srcFile = new File(path + time + "-srcFile");
    srcFile.createNewFile();

    File testFile = new File(path + time + "-testFile");
    testFile.createNewFile();

    FileTime lastModifiedTime = Files.getLastModifiedTime(srcFile.toPath());

    System.out.println("Setting the timestamp of file2 to " + lastModifiedTime.toMillis());
    Files.setLastModifiedTime(testFile.toPath(), lastModifiedTime);
    System.out.println(
        "Getting the timestamp of file2 to "
            + Files.getLastModifiedTime(testFile.toPath()).toMillis());

    long file1Millis = Files.getLastModifiedTime(srcFile.toPath()).toMillis();
    long file2Millis = testFile.lastModified();

    if (file1Millis == file2Millis) {
      System.out.println("Timestamps are equal - no bug is found");
    } else {
      System.out.println("Timestamps are not equal - It should... this is a bug");
    }
  }
}

