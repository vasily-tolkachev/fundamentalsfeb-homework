package subtasks.one.two;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

interface ReaderWriter {
    String readFile(File file);

    void writeResult(String result, File file);
}

class CharReaderWriter implements ReaderWriter {
    private static final Logger log = LogManager.getLogger(CharReaderWriter.class);

    @Override
    public String readFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new FileReader(file))
        ) {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                stringBuilder.append(string).append("\n");
            }
        } catch (FileNotFoundException e) {
            log.info("CharReaderWriter.readFile file not found");
        } catch (IOException e) {
            log.info("CharReaderWriter.readFile IOException");
        }
        return stringBuilder.toString();
    }

    @Override
    public void writeResult(String result, File file) {
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))
        ) {
            file.createNewFile();
            bufferedWriter.write(result);
        } catch (IOException e) {
            log.info("CharReaderWriter.writeResult IOException");
        }
    }
}

class ByteReaderWriter implements ReaderWriter {
    private static final Logger log = LogManager.getLogger(ByteReaderWriter.class);

    @Override
    public String readFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (
                InputStream inputStream = new BufferedInputStream(
                        new FileInputStream(file))
        ) {
            byte[] buffer = new byte[1024];
            while (inputStream.read(buffer) > 0) {
                stringBuilder.append(new String(buffer));
                buffer = new byte[1024];
            }
        } catch (FileNotFoundException e) {
            log.info("ByteReaderWriter.readFile file not found");
        } catch (IOException e) {
            log.info("ByteReaderWriter.readFile IOException");
        }
        return stringBuilder.toString();
    }

    @Override
    public void writeResult(String result, File file) {
        try (
                OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))
        ) {
            file.createNewFile();
            byte[] bytes = result.getBytes();
            outputStream.write(bytes, 0, bytes.length);
        } catch (IOException e) {
            log.info("CharReaderWriter.writeResult IOException");
        }
    }
}
