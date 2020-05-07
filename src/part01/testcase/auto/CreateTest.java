package part01.testcase.auto;

import java.io.File;
import java.io.FileNotFoundException;

public class CreateTest {
	public String getClassName() {
		String classFullName = this.getClass().getName();
		String[] str = classFullName.split("\\.");
		String className = str[str.length-1];
		return className;
	}
	
	public void createTest(int type, int T, int N, int min, int max) throws FileNotFoundException {
		CreateRandomCase tc = new CreateRandomCase();
		String path = getFilePath();
		tc.createTestCase(path, type, T, N, min, max);
	}
	
	public void createTest(int type, int T, int matMin, int matMax) throws FileNotFoundException {
		CreateRandomCase tc = new CreateRandomCase();
		String path = getFilePath();
		tc.createTestCase(path, type, T, matMin, matMax);
	}
	
	public String getFilePath() {
		String path = "";
		String classFullName = this.getClass().getName();
		path += "src/" + classFullName.replace(".", "/") + ".txt"; 
		return path;
	}
	
	public File getTestFile() {
		String filePath = getFilePath();
		File file = new File(filePath);
		return file;
	}
	
	public String goTest(int type, int T, int N, int min, int max) throws FileNotFoundException {
		createTest(type, T, N, min, max);
		return getFilePath();
	}
	
	public String goTest(int type, int T, int matMin, int matMax) throws FileNotFoundException {
		createTest(type, T, matMin, matMax);
		return getFilePath();
	}
	
}
