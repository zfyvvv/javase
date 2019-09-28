package cn.zhoufy.go.composite;

public class Client {
	public static void main(String[] args) {
		AbstractFile f1,f2,f3;
		Folder f4,f5;
		f1=new ImageFile("wodetupian.jpg");
		f2=new TxtFile("wodehanzi.txt");
		f3=new VideoFile("shiping.avi");
		f4=new Folder("wodeuzch");
		f5=new Folder("yule!");
		f4.add(f5);
		f5.add(f1);
		f5.add(f2);
		f5.add(f3);
		f4.killVirus();
	}

}
