package development;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FilesSortAndDelete {
	public static void main(String[] args) {
		
//		listOutAllFilesAndSort();
		
//		filterAndlistOutARZipFilesAndSort();
		
		deleteARZipFileExcept2();
		
		System.out.println(getRecentARZipFile().getAbsolutePath());
	}
	
	
	private static File getRecentARZipFile() {
		File directory = new File("C:\\Users\\Sasanka_Talukder\\Downloads");
		File[] files = directory.listFiles(arZipFilefilter);
		Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
		if(files.length != 0) {
			return files[0];
		}
		return null;
	}


	private static void deleteARZipFileExcept2() {
		File directory = new File("C:\\Users\\Sasanka_Talukder\\Downloads");
		File[] files = directory.listFiles(arZipFilefilter);
		for(int i=0;i<files.length;i++) {
			System.out.println(files[i].getAbsolutePath());
		}
		System.out.println("------------------");
		Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
//		for(int i=0;i<files.length;i++) {
//			System.out.println(files[i].getAbsolutePath());
//		}
		if(files.length > 2) {
			for(int i=2;i<files.length;i++) {
				files[i].delete();
			}
		}
		for(int i=0;i<files.length;i++) {
			System.out.println(files[i].getAbsolutePath());
		}
	}


	static FileFilter arZipFilefilter = new FileFilter() {
		public boolean accept(File file) {
			if (file.getName().endsWith(".zip") && file.getName().startsWith("AR_")) {
				return true;
			}
			return false;
		}
	};

	private static void filterAndlistOutARZipFilesAndSort() {
		File directory = new File("C:\\Users\\Sasanka_Talukder\\Downloads");
		File[] files = directory.listFiles(arZipFilefilter);
		for(int i=0;i<files.length;i++) {
			System.out.println(files[i].getAbsolutePath());
		}
		System.out.println("------------------");
		Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
//		for(int i=0;i<files.length;i++) {
//			System.out.println(files[i].getAbsolutePath());
//		}
		if(files.length > 2) {
			for(int i=2;i<files.length;i++) {
				files[i].delete();
			}
		}
		for(int i=0;i<files.length;i++) {
			System.out.println(files[i].getAbsolutePath());
		}
	}

	private static void listOutAllFilesAndSort() {
		File directory = new File("C:\\Users\\Sasanka_Talukder\\Downloads");
		File[] files = directory.listFiles();
		for(int i=0;i<files.length;i++) {
			System.out.println(files[i].getName());
			System.out.println(files[i].getAbsolutePath());
		}
		System.out.println("------------------");
		Arrays.sort(files, Comparator.comparingLong(File::lastModified));
		for(int i=0;i<files.length;i++) {
			System.out.println(files[i].getAbsolutePath());
		}
	}
	
	public static List<String> getAllPathsInsideDir(String dirPath) {
		List<String> fileAbPAth = new ArrayList<>();
		File directory = new File(dirPath);
		File[] files = directory.listFiles();
		for(int i=0;i<files.length;i++) {
			fileAbPAth.add(files[i].getAbsolutePath());
		}
		return fileAbPAth;
	}
	
	public static String getContentOfFileAsTExt(String filePath) {
		String everything = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			try {
			    StringBuilder sb = new StringBuilder();
			    String line = br.readLine();

			    while (line != null) {
			        sb.append(line);
			        sb.append(System.lineSeparator());
			        line = br.readLine();
			    }
			    everything = sb.toString();
			} finally {
			    br.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return everything;
	}
}
