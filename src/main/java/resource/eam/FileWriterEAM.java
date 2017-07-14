package resource.eam;

import java.io.FileWriter;
import java.io.IOException;

/**
 * EAM : Execute Around Method
 * Created by hotjoyit on 2017-07-15.
 */
public class FileWriterEAM {

  private final FileWriter writer;

  private FileWriterEAM(final String fileName) throws IOException {
    writer = new FileWriter(fileName);
  }

  private void close() throws IOException {
    System.out.println("close called automatically");
    writer.close();
  }

  public void writeStuff(final String message) throws IOException {
    writer.write(message);
  }

  // Execute Around Method : 외부 리소스의 할당과 해제를 템플릿 코드로 제공
  public static void use(final String fileName, final UseInstance<FileWriterEAM, IOException> block) throws IOException {
    final FileWriterEAM writerEAM = new FileWriterEAM(fileName);
    try {
      block.accept(writerEAM);
    } finally {
      writerEAM.close();
    }
  }

  // Consumer 는 메소드 시그니처에 예외를 포함하지 않기 때문에 새로 정의함
  @FunctionalInterface
  public interface UseInstance<T, X extends Throwable> {
    void accept(T instance) throws X;
  }

  public static void main(String[] args) {
    try {
      FileWriterEAM.use("eam.txt", writerEAM -> writerEAM.writeStuff("awesome"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
