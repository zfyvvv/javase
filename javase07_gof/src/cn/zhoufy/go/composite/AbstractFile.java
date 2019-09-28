package cn.zhoufy.go.composite;
/**
 * 1.使用组合模式，构件一个杀毒软件；
 * 2.树形结构的文件，推荐使用！
 */
import java.util.ArrayList;
import java.util.List;

public interface AbstractFile {
	void killVirus();
}

class ImageFile implements AbstractFile{
	private String name;
	
	public ImageFile(String name) {
		super();
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("---imagefile："+name+"-->killed");
	}
}
class TxtFile implements AbstractFile{
	private String name;
	
	public TxtFile(String name) {
		super();
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("---txtfile:"+name+"-->killed");
	}
}
class VideoFile implements AbstractFile{
	private String name;
	
	public VideoFile(String name) {
		super();
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("---videofile:"+name+"-->killed");
	}
}
class Folder implements AbstractFile{
	private List<AbstractFile> list=new ArrayList<AbstractFile>();
	private String name;

	public Folder(String name) {
		super();
		this.name = name;
	}
	public void add(AbstractFile abstractfile) {
		list.add(abstractfile);
	} 
	public void remove(AbstractFile abstractfile) {
		list.remove(abstractfile);
	}
	public AbstractFile getAbstractFile(int index){
		return list.get(index);
	}
	@Override
	public void killVirus() {
	System.out.println("---folder:"+name+"-->killed");
	for(AbstractFile temp:list ) {
		temp.killVirus();
	}
	}
	
}





