import java.io.File;

public class RenameFilesCustom {
	static String path = "D:\\University\\My Papers\\9- IEEE Data Descriptions -\\Dataset\\Kitchen_03\\Kitchen3_Transceiver_Data\\Kitchen03\\Participant 3";

	static String participant = "p3";
	static String environment = "e3";
	static String sensor = "s1";

	
	public static void main(String[] args) {
		renameFiles(path + "\\Chop", "Chop", participant + "_" + environment + "_" + sensor + "_" + "a1_t");
		renameFiles(path + "\\Frenchcut", "Frenchcut", participant + "_" + environment + "_" + sensor + "_" + "a3_t");
		renameFiles(path + "\\Ladle", "Ladle", participant + "_" + environment + "_" + sensor + "_" + "a6_t");
		renameFiles(path + "\\Place", "Place", participant + "_" + environment + "_" + sensor + "_" + "a9_t");
		renameFiles(path + "\\Pour", "Pour", participant + "_" + environment + "_" + sensor + "_" + "a4_t");
		renameFiles(path + "\\Slice", "Slice", participant + "_" + environment + "_" + sensor + "_" + "a2_t");
		renameFiles(path + "\\Stir", "Stir", participant + "_" + environment + "_" + sensor + "_" + "a5_t");
		renameFiles(path + "\\Store", "Store", participant + "_" + environment + "_" + sensor + "_" + "a7_t");
		renameFiles(path + "\\Wash", "wash0", participant + "_" + environment + "_" + sensor + "_" + "a8_t");
	}

	private static void renameFiles(String folderPath, String oldPrefix, String newPrefix) {
		File folder = new File(folderPath);
		if (!folder.isDirectory()) {
			System.out.println(folderPath + " is not a valid directory.");
			return;
		}

		File[] files = folder.listFiles();
		if (files == null) {
			System.out.println("Cannot access files in " + folderPath);
			return;
		}

		for (File file : files) {
			String fileName = file.getName();
			if (fileName.startsWith(oldPrefix)) {
				String newFileName = newPrefix + fileName.substring(oldPrefix.length());
				File newFile = new File(folder, newFileName);
				if (file.renameTo(newFile)) {
					System.out.println("Renamed in " + folderPath + ": " + fileName + " -> " + newFileName);
				} else {
					System.out.println("Failed to rename in " + folderPath + ": " + fileName);
				}
			}
		}
	}
}