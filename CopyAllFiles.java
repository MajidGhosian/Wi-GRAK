import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class CopyAllFiles {

    // Set the root of the source hierarchy and destination folder here
    private static final String SOURCE_ROOT = "D:\\University\\My Papers\\9- IEEE Data Descriptions -\\Dataset\\Hierarchial";
    private static final String DESTINATION_FOLDER = "D:\\University\\My Papers\\9- IEEE Data Descriptions -\\Dataset\\All in One";

    public static void main(String[] args) {
        File sourceRoot = new File(SOURCE_ROOT);
        File destinationDir = new File(DESTINATION_FOLDER);

        if (!destinationDir.exists()) {
            destinationDir.mkdirs(); // Create destination folder if it doesn't exist
        }

        copyFilesRecursively(sourceRoot, destinationDir);
    }

    private static void copyFilesRecursively(File source, File destinationDir) {
        if (source.isDirectory()) {
            File[] files = source.listFiles();
            if (files != null) {
                for (File file : files) {
                    copyFilesRecursively(file, destinationDir);
                }
            }
        } else {
            try {
                // Create unique filename in case of duplicates
                String uniqueName = source.getName();
                Path destinationPath = Paths.get(destinationDir.getAbsolutePath(), uniqueName);
                Files.copy(source.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Copied: " + source.getAbsolutePath() + " -> " + destinationPath);
            } catch (IOException e) {
                System.err.println("Failed to copy file: " + source.getAbsolutePath());
                e.printStackTrace();
            }
        }
    }
}